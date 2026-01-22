package com.Yusuf.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoBasketProductIU {
	
	@NotNull
	private Long customerId;
	
	@NotNull
	private Long productId;

}
