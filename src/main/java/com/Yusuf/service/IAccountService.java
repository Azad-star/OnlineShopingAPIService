package com.Yusuf.service;

import com.Yusuf.dto.DtoAccount;
import com.Yusuf.dto.DtoAccountIU;

public interface IAccountService {
	
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);

}
