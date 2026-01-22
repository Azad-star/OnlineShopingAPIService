package com.Yusuf.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.Yusuf.dto.DtoAccount;
import com.Yusuf.dto.DtoBasket;
import com.Yusuf.dto.DtoCreateCustomerIU;
import com.Yusuf.dto.DtoCustomer;
import com.Yusuf.entity.Account;
import com.Yusuf.entity.Address;
import com.Yusuf.entity.Basket;
import com.Yusuf.entity.Customer;
import com.Yusuf.entity.CustomerBasket;
import com.Yusuf.repository.CustomerBasketRepository;
import com.Yusuf.repository.CustomerRepository;
import com.Yusuf.service.ICreateCustomerService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // final aracılığı ile oluşturduğumuz objectler  için constructor oluşturur
@Transactional // Ya Hep, Ya Hiç
public class CreateCustomerService implements ICreateCustomerService {
	
	// Repositories
	private final CustomerRepository customerRepository;
	
	private final CustomerBasketRepository customerBasketRepository;

	@Override
	public DtoCustomer createCustomer(DtoCreateCustomerIU dtoCustomerIU) {
		
		//Objects
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAccount dtoAccount = new  DtoAccount();
		DtoBasket dtoBasket = new DtoBasket();
		
		Customer customer = new Customer();
		Account account = new Account();
		Address address = new Address();
		Basket basket = new Basket();
		CustomerBasket customerBasket = new CustomerBasket();
	
		
		// Get input from client
		BeanUtils.copyProperties(dtoCustomerIU, customer);
		BeanUtils.copyProperties(dtoCustomerIU, account);
		BeanUtils.copyProperties(dtoCustomerIU, address);
		
		// Set up Dates
		customer.setCreateTime(new Date());
		account.setCreateTime(new Date());
		address.setCreateTime(new Date());
		basket.setCreateTime(new Date());
	
		// Set up customer
		customer.setAccount(account);
		customer.setAddress(address);
		customer.setBasket(basket);
	
		// Save customer
		Customer savedCustomer = customerRepository.save(customer);
		
		// Set up dtoCustomer to return
		BeanUtils.copyProperties(basket, dtoBasket);
		BeanUtils.copyProperties(account, dtoAccount);
		BeanUtils.copyProperties(savedCustomer, dtoCustomer);
		dtoCustomer.setAccount(dtoAccount);
		dtoCustomer.setBasket(dtoBasket);
		
		//Set up customerBasket and Save
		customerBasket.setCreateTime(new Date ());
		customerBasket.setCustomer(savedCustomer);
		customerBasket.setBasket(basket);
		customerBasketRepository.save(customerBasket);


		return dtoCustomer;
	}

}
