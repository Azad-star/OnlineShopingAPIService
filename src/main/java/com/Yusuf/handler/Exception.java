package com.Yusuf.handler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exception <T> {
	
	private String path;
	
	private Date createTime;
	
	private String hostName;
	
	private T message;

}
