package com.Yusuf.service;

import com.Yusuf.dto.DtoUser;
import com.Yusuf.entity.AuthRequest;
import com.Yusuf.entity.AuthResponse;
import com.Yusuf.entity.RefreshTokenRequest;

public interface IAuthenticationService {
	
	public DtoUser register(AuthRequest input);
	
	public AuthResponse authenticate(AuthRequest input);
	
	public AuthResponse refreshtoken(RefreshTokenRequest input);

}
