package com.Yusuf.service;

import com.Yusuf.dto.DtoCreateCustomerIU;
import com.Yusuf.dto.DtoCustomer;

public interface ICreateCustomerService {
	
	public DtoCustomer createCustomer(DtoCreateCustomerIU dtoCustomerIU);

}
