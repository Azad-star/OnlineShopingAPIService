package com.Yusuf.controller;

import com.Yusuf.controller.rootEntity.RootEntity;
import com.Yusuf.dto.DtoUser;
import com.Yusuf.entity.AuthRequest;
import com.Yusuf.entity.AuthResponse;
import com.Yusuf.entity.RefreshTokenRequest;


public interface IAuthenticationController {
	
	public RootEntity<DtoUser> register(AuthRequest input);
	
	public RootEntity<AuthResponse> authentication(AuthRequest input);

	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
