package com.nxhu.restfull_api.user.infrastructure.adapters.in.rest.model.response;
import com.nxhu.restfull_api.user.domain.model.RoleEnum;

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
public class UserResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private RoleEnum role;
}
