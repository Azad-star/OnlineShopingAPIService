package com.Yusuf.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Yusuf.controller.BaseController;
import com.Yusuf.controller.IProductController;
import com.Yusuf.controller.rootEntity.RootEntity;
import com.Yusuf.dto.DtoProduct;
import com.Yusuf.dto.DtoProductIU;
import com.Yusuf.service.IProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/api/product")
@RequiredArgsConstructor
public class ProductController extends BaseController implements IProductController {

	private final IProductService productService;
	
	@Override
	@PostMapping("/save")
	public RootEntity<DtoProduct> saveProduct(@Valid @RequestBody DtoProductIU dtoProductIU) {
		return ok(productService.saveProduct(dtoProductIU));
	}

}
