package com.Yusuf.dto;

import lombok.Data;

@Data
public class DtoBasketProduct extends DtoBase{
	
	// Special DtoProduct class for purchasing to return
	private DtoProductForPurchase product;
	
	// Special DtoShop class for purchasing to return
	private DtoShopForPurchase shop;
	
	// Special DtoCustomer class for purchasing to return
	private DtoCustomerForPurchase customer;
}
