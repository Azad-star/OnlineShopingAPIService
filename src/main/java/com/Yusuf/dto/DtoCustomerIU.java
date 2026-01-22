package com.Yusuf.dto;

import com.Yusuf.entity.Account;
import com.Yusuf.entity.Address;
import com.Yusuf.entity.Basket;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoCustomerIU {
	
	@NotNull
	private String name;
	
	@NotNull
	private Long age;
	
	@NotNull
	private Long accountId;
	
	@NotNull
	private Long adressId;
	
	@NotNull
	private Long basketId;

}
