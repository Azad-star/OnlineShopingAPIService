package com.Yusuf.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DtoProductForPurchase {
	
    private String productName;
	
	private String category;

	private BigDecimal price;
	

}
