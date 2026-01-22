package com.Yusuf.controller;

import com.Yusuf.controller.rootEntity.RootEntity;
import com.Yusuf.dto.DtoSeller;
import com.Yusuf.dto.DtoSellerIU;

public interface ISellerController {
	
	public RootEntity<DtoSeller> saveSeller(DtoSellerIU dtoSellerIU);	

}
