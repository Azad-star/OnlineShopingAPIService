package com.Yusuf.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Yusuf.controller.BaseController;
import com.Yusuf.controller.ICreateCustomerController;
import com.Yusuf.controller.rootEntity.RootEntity;
import com.Yusuf.dto.DtoCreateCustomerIU;
import com.Yusuf.dto.DtoCustomer;
import com.Yusuf.service.ICreateCustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/api/customer")
@RequiredArgsConstructor
public class CreateCustomerController extends BaseController implements ICreateCustomerController {
	
	private final ICreateCustomerService createCustomerService;

	@Override
	@PostMapping("/save")
	public RootEntity<DtoCustomer> createCustomer(@Valid @RequestBody DtoCreateCustomerIU dtoCustomerIU) {
		return ok(createCustomerService.createCustomer(dtoCustomerIU));
	}

}
