package com.Yusuf.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoSellerIU {
	
	@NotNull
	private String sellerName;
	
	@NotNull
	private String password;
	
	@NotNull
	private String shopName;
}
