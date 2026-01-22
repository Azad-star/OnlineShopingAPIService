package com.Yusuf.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Yusuf.controller.BaseController;
import com.Yusuf.controller.IBasketProductController;
import com.Yusuf.controller.rootEntity.RootEntity;
import com.Yusuf.dto.DtoBasketProduct;
import com.Yusuf.dto.DtoBasketProductIU;
import com.Yusuf.service.IBasketProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/api/purchase")
@RequiredArgsConstructor
public class BasketProductController extends BaseController implements IBasketProductController  {
	
	private final IBasketProductService basketProductService;

	@Override
	@PostMapping("/product")
	public RootEntity<DtoBasketProduct> saveBasketProduct(@Valid @RequestBody DtoBasketProductIU dtoBasketProductIU) {

		return ok(basketProductService.saveBasketProduct(dtoBasketProductIU));
	}

}
