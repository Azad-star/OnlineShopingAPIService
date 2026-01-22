package com.Yusuf.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Yusuf.controller.BaseController;
import com.Yusuf.controller.ISellerController;
import com.Yusuf.controller.rootEntity.RootEntity;
import com.Yusuf.dto.DtoSeller;
import com.Yusuf.dto.DtoSellerIU;
import com.Yusuf.service.ISellerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/api/seller")
@RequiredArgsConstructor
public class SellerController extends BaseController implements ISellerController{
	
	private final ISellerService sellerService;
	
	@Override
	@PostMapping("/save")
	public RootEntity<DtoSeller> saveSeller(@Valid @RequestBody DtoSellerIU dtoSellerIU) {
		
		return ok(sellerService.saveSeller(dtoSellerIU));
	}



}
