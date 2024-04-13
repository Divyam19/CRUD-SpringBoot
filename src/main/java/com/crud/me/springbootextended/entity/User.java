package com.crud.me.springbootextended.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
	
	@Id
	@Column(name="u_name")
	private String userName;
	
	@Column(name="u_password")
	private String userPassword;
	
/*
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public User() {}
*/	
	

}
