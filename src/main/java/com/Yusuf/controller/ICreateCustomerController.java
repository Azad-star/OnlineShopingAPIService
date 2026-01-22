package com.Yusuf.controller;

import com.Yusuf.controller.rootEntity.RootEntity;
import com.Yusuf.dto.DtoCreateCustomerIU;
import com.Yusuf.dto.DtoCustomer;

public interface ICreateCustomerController {
	
	public RootEntity<DtoCustomer> createCustomer(DtoCreateCustomerIU dtoCustomerIU);

}
