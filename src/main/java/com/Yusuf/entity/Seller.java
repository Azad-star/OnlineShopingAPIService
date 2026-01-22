package com.Yusuf.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seller")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller extends BaseEntity {
	
	@Column(name = "seller_name")
	private String sellerName;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Shop shop;
}
