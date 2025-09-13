package com.nxhu.sistema_ventas.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private RoleEnum role;

	public void assignDefaultRole(boolean isFirstUser) {
	    if (isFirstUser) {
	        this.role = RoleEnum.ADMIN;
	        System.out.println("[LOG]: user role " + RoleEnum.ADMIN);
	    } else {
	        this.role = RoleEnum.EMPLOYEE;
	        System.out.println("[LOG]: user role " + RoleEnum.EMPLOYEE);
	    }
	}
}
