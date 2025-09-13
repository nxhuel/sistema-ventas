package com.nxhu.sistema_ventas.user.infrastructure.adapters.in.rest.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

	@NotNull(message = "first name must not be empty or null")
	private String firstName;
	
	@NotNull(message = "last name must not be empty or null")
	private String lastName;
	
	@NotNull(message = "email must not be empty or null")
	@Email(message = "Email should be valid")
	private String email;
	
	@NotNull(message = "password must not be empty or null")
	@Size(min = 8, message = "Password must be at least 8 characters long")
	@Pattern(
		    regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[^\\s]{8,}$",
		    message = "Password must contain at least one uppercase, one lowercase, one number, one special character and no spaces"
		)
	private String password;
}
