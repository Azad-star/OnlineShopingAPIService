package com.Yusuf.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoCreateCustomerIU {
	
	@NotNull
	private String name;
	
	@NotNull
	private Long Age;
	
	//Address
	@NotNull
	private String city;
	
	@NotNull
	private String street;
	
	@NotNull
	private String neighbor;	
	
	@NotNull
	private String apartmentNo;
	
	//Account
	
	@NotNull
	private BigDecimal balance;

}
