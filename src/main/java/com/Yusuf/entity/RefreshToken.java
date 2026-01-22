package com.Yusuf.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "refreshToken")
@Data
public class RefreshToken extends BaseEntity {
	
	@Column(name = "refresh_Token")
	private String refreshToken;
	
	@Column(name = "expired_Token")
	private Date expiredDate;
	
	@ManyToOne
	private User user;

}
