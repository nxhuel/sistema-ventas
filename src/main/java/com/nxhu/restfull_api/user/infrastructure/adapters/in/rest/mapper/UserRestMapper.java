package com.nxhu.restfull_api.user.infrastructure.adapters.in.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nxhu.restfull_api.user.domain.model.UserModel;
import com.nxhu.restfull_api.user.infrastructure.adapters.in.rest.model.request.UserCreateRequest;
import com.nxhu.restfull_api.user.infrastructure.adapters.in.rest.model.response.UserResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRestMapper {
	
	UserModel toUserModel(UserCreateRequest userCreateRequest);

	UserResponse toUserResponse(UserModel userModel);
	
	List<UserResponse> toUserResponses(List<UserModel> userModels);
}
