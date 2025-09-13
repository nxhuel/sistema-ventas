package com.nxhu.sistema_ventas.user.infrastructure.adapters.in.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nxhu.sistema_ventas.user.domain.model.UserModel;
import com.nxhu.sistema_ventas.user.infrastructure.adapters.in.rest.model.request.UserCreateRequest;
import com.nxhu.sistema_ventas.user.infrastructure.adapters.in.rest.model.response.UserResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRestMapper {
	
	UserModel toUserModel(UserCreateRequest userCreateRequest);

	UserResponse toUserResponse(UserModel userModel);
	
	List<UserResponse> toUserResponses(List<UserModel> userModels);
}
