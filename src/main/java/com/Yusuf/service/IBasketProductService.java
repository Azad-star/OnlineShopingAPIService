package com.Yusuf.service;

import com.Yusuf.dto.DtoBasketProduct;
import com.Yusuf.dto.DtoBasketProductIU;

public interface IBasketProductService {
	
	public DtoBasketProduct saveBasketProduct(DtoBasketProductIU dtoBasketProductIU);

}
