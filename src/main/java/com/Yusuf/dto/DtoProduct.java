package com.Yusuf.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DtoProduct extends DtoBase {
	

	private String productName;
	
	private String category;

	private BigDecimal price;
	
	private Long stock;
	
	private DtoShop shop;

}
