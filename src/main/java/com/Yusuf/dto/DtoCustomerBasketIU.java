package com.Yusuf.dto;

import com.Yusuf.entity.Basket;
import com.Yusuf.entity.Customer;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoCustomerBasketIU {
	
	@NotNull
	private Long customerId;
	
	@NotNull
	private Long basketId;
	


	
	

}
