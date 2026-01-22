package com.Yusuf.exception;

import lombok.Getter;

@Getter
public enum MessageType {
	//Exceptions
	INVALID_USERNAME_OR_PASSWORD("1000","Username or password is invalid"),
	INVALID_REFRESHTOKEN("1001","RefreshToken is invalid"),
	EXPIRED_REFRESHTOKEN("1002","RefreshToken got expired"),
	SHOPID_OR_PASSWORD_INVALID("1003","ShopId or password is invalid"),
	INVALID_ID("1004","Invalid id"),
	INVALID_PASSWORD("1005","Invalid password"),
	NO_ENOUGH_BALANCE("1006","There is no enough balance in account"),
	
	GENERAL_ERROR("9999", "GENERAL ERROR");
	
	private String code;
	private String message;
	
	MessageType(String code, String message){
		this.code = code;
		this.message = message;
	}

}
