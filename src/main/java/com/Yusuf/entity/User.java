package com.Yusuf.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  extends BaseEntity implements UserDetails{

	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return null;
	}

	@Override
	public  String getPassword() {
	
		return this.password;
	}

	@Override
	public String getUsername() {
	
		return this.username;
	}

}
