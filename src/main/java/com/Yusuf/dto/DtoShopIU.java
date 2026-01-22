package com.Yusuf.dto;

import com.Yusuf.entity.Product;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoShopIU {
	
	@NotNull
	private String shopName;
}
