package com.Yusuf.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class DtoCustomer  extends DtoBase{

	private String name;
	
	private DtoAccount account;
	
	private DtoBasket basket;
}
