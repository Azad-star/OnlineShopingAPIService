package com.Yusuf.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoAccountIU {

	@NotNull
	private BigDecimal balance;
}
