package com.Yusuf.controller;

import com.Yusuf.controller.rootEntity.RootEntity;
import com.Yusuf.dto.DtoProduct;
import com.Yusuf.dto.DtoProductIU;

public interface IProductController {
	
	public RootEntity<DtoProduct> saveProduct(DtoProductIU dtoProductIU);

}
