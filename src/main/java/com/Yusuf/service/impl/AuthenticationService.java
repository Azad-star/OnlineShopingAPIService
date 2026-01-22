package com.Yusuf.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Yusuf.dto.DtoUser;
import com.Yusuf.entity.AuthRequest;
import com.Yusuf.entity.AuthResponse;
import com.Yusuf.entity.RefreshToken;
import com.Yusuf.entity.RefreshTokenRequest;
import com.Yusuf.entity.User;
import com.Yusuf.exception.BaseException;
import com.Yusuf.exception.ErrorMessage;
import com.Yusuf.exception.MessageType;
import com.Yusuf.jwt.JwtService;
import com.Yusuf.repository.RefreshTokenRepository;
import com.Yusuf.repository.UserRepository;
import com.Yusuf.service.IAuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService{
	
	private final UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtService jwtService;
	
	private final RefreshTokenRepository refreshTokenRepository;

	
	private User createUser(AuthRequest input) {
		User user = new User();
		
		user.setCreateTime(new Date());
		BeanUtils.copyProperties(input, user);
		
		return user;
	}
	
	@Override
	public DtoUser register(AuthRequest input) {
		
		User user = createUser(input);
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		User savedUser = userRepository.save(user);
		DtoUser dtoUser = new DtoUser();
		BeanUtils.copyProperties(savedUser, dtoUser);
		return dtoUser;
	}
	

	@Override
	public AuthResponse authenticate(AuthRequest input) {
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword());
			authenticationProvider.authenticate(authenticationToken);
			Optional<User> optUser = userRepository.findByUsername(input.getUsername());
			String accessToken = jwtService.generateToken(optUser.get());
			RefreshToken savedRefreshToken = refreshTokenRepository.save(jwtService.createRefreshToken(optUser.get()));
			return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken());
		
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.INVALID_USERNAME_OR_PASSWORD, e.getMessage()));
		}
	}

	@Override
	public AuthResponse refreshtoken(RefreshTokenRequest input) {
		Optional<RefreshToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(input.getRefreshToken());
		if(optRefreshToken.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.INVALID_REFRESHTOKEN, input.getRefreshToken()));
		}
		if(!jwtService.isValidRefreshToken(optRefreshToken.get().getExpiredDate())) {
			throw new BaseException(new ErrorMessage(MessageType.EXPIRED_REFRESHTOKEN, input.getRefreshToken()));
		}
		User user = optRefreshToken.get().getUser();
		String accessToken = jwtService.generateToken(user);
		RefreshToken savedRefreshToken = refreshTokenRepository.save(jwtService.createRefreshToken(user));
		
		return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
	}

}
