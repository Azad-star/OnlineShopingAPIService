package com.Yusuf.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoShopProductIU {
	@NotNull
	private Long shopId;
	
	@NotNull
	private Long productId;

}
