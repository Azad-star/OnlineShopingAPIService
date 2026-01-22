package com.Yusuf.dto;

import java.util.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class DtoBase {
	
	private Long id;
	
	private Date createTime;

}
