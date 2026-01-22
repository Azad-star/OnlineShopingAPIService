package com.Yusuf.service;

import com.Yusuf.dto.DtoProduct;
import com.Yusuf.dto.DtoProductIU;

public interface IProductService {
	
	public DtoProduct saveProduct(DtoProductIU dtoProductIU);

}
