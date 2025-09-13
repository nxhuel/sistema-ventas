package com.nxhu.sistema_ventas.user.infrastructure.adapters.out.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.nxhu.sistema_ventas.user.domain.model.UserModel;
import com.nxhu.sistema_ventas.user.infrastructure.adapters.out.persistence.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

	UserEntity toUserEntity(UserModel userModel);
	
	UserModel toUserModel(UserEntity userEntity);
	
	List<UserModel> toUserModels(List<UserEntity> userEntities);
}
