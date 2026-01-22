package com.Yusuf.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Yusuf.controller.IAccountController;
import com.Yusuf.dto.DtoAccount;
import com.Yusuf.dto.DtoAccountIU;
import com.Yusuf.service.IAccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/account")
public class AccountController implements IAccountController{
	
	@Autowired
	private IAccountService accountService; 

	@Override
	@PostMapping("/save")
	public DtoAccount saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
		DtoAccount dtoAccount = accountService.saveAccount(dtoAccountIU);
		return dtoAccount;
	}

}
