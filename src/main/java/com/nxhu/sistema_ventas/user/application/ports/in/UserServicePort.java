package com.nxhu.sistema_ventas.user.application.ports.in;

import java.util.List;
import java.util.Map;

import com.nxhu.sistema_ventas.user.domain.exception.UserNotFoundException;
import com.nxhu.sistema_ventas.user.domain.model.UserModel;

public interface UserServicePort {
	
	UserModel saveUser(UserModel user);
	
	List<UserModel> findAllUsers();
	
	UserModel findUserById(Long id) throws UserNotFoundException;
	
	UserModel updateUserById(Long id, UserModel newUser) throws UserNotFoundException;
	
	UserModel patchUserById(Long id, Map<String, Object> updates) throws UserNotFoundException;
	
	void deleteUserById(Long id) throws UserNotFoundException;
}
