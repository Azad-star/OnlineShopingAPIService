package com.Yusuf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop extends BaseEntity {
	
	@Column(name = "shop_name")
	private String shopName;
}
