package com.Yusuf.dto;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DtoAccount extends DtoBase{
	
	private BigDecimal balance;

}
