package com.Yusuf.dto;

import lombok.Data;

@Data
public class DtoShopProduct extends DtoBase {

	private DtoShop shop;
	
	private DtoProduct product;

}
