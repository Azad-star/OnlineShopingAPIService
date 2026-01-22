package com.Yusuf.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoSellerShopIU {

	@NotNull
	private Long sellerId;
	
	@NotNull
	private Long shopId;

}
