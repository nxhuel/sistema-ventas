package com.nxhu.restfull_api.user.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.nxhu.restfull_api.user.domain.model.UserModel;

public interface UserPersistencePort {
	UserModel saveUser(UserModel userModel);
	
	List<UserModel> findAllUsers();
	
	Optional<UserModel> findUserById(Long id);
	
	long countUser();
	
	void deleteUserById(Long id);
}
