package com.Yusuf.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Yusuf.controller.BaseController;
import com.Yusuf.controller.IAuthenticationController;
import com.Yusuf.controller.rootEntity.RootEntity;
import com.Yusuf.dto.DtoUser;
import com.Yusuf.entity.AuthRequest;
import com.Yusuf.entity.AuthResponse;
import com.Yusuf.entity.RefreshTokenRequest;
import com.Yusuf.service.IAuthenticationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
public class AuthenticationController extends BaseController implements IAuthenticationController {
	
	private final IAuthenticationService authenticationService;

	@Override
	@PostMapping("/register")
	public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {
		
		return ok(authenticationService.register(input));
	}

	@Override
	@PostMapping("/authenticate")
	public RootEntity<AuthResponse> authentication(@Valid @RequestBody AuthRequest input) {
		
		return ok(authenticationService.authenticate(input));
	}

	@Override
	@PostMapping("/refreshToken")
	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input) {
		
		return ok(authenticationService.refreshtoken(input));
	}

}
