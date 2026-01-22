package com.Yusuf.dto;

import com.Yusuf.entity.Basket;
import com.Yusuf.entity.Customer;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoCustomerBasket extends DtoBase{
	
	private DtoCustomer customer;
	
	private DtoBasket basket;
	
}
