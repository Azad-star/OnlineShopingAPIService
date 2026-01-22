package com.Yusuf.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoAddressIU {
	
	@NotNull
	private String city;
	
	@NotNull
	private String neighbor;
	
	@NotNull
	private String street;
	
	@NotNull
	private String apartmentNo;

}
