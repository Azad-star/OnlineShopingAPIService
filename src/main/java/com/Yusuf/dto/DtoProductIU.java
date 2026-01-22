package com.Yusuf.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoProductIU {
	
	@NotNull
	private String productName;
	
	@NotNull
	private String category;
	
	@NotNull
	private BigDecimal price;
	
	@NotNull
	private Long stock;
	
	//for Shop
	@NotNull
	private Long shopId;
	
	//for Seller
	@NotNull
	private Long sellerId;
	
	@NotNull
	private String password;

}
