package com.Yusuf.controller;

import com.Yusuf.controller.rootEntity.RootEntity;
import com.Yusuf.dto.DtoBasketProduct;
import com.Yusuf.dto.DtoBasketProductIU;

public interface IBasketProductController {
	
	public RootEntity<DtoBasketProduct> saveBasketProduct(DtoBasketProductIU dtoBasketProductIU);

}
