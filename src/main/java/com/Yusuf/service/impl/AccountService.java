package com.Yusuf.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Yusuf.dto.DtoAccount;
import com.Yusuf.dto.DtoAccountIU;
import com.Yusuf.entity.Account;
import com.Yusuf.repository.AccountRepository;
import com.Yusuf.service.IAccountService;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
		Account account = new Account();
		account.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoAccountIU, account);
		Account savedAccount = accountRepository.save(account);
		DtoAccount dtoAccount = new DtoAccount();
		BeanUtils.copyProperties(savedAccount, dtoAccount);
		return dtoAccount;
	
	}




}
