package com.Yusuf.controller;

import com.Yusuf.dto.DtoAccount;
import com.Yusuf.dto.DtoAccountIU;

public interface IAccountController {
	
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);

}
