package com.Yusuf.dto;

import lombok.Data;

@Data
public class DtoSeller extends DtoBase{
	
	private String sellerName;
	
	private String password;
	
	private DtoShop shop;

}
