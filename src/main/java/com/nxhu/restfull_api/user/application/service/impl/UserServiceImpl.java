package com.nxhu.restfull_api.user.application.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nxhu.restfull_api.user.application.ports.in.UserServicePort;
import com.nxhu.restfull_api.user.application.ports.out.UserPersistencePort;
import com.nxhu.restfull_api.user.domain.exception.UserNotFoundException;
import com.nxhu.restfull_api.user.domain.model.RoleEnum;
import com.nxhu.restfull_api.user.domain.model.UserModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServicePort {
	
	private final UserPersistencePort userPersistencePort;
	
	@Override
	public UserModel saveUser(UserModel user) {
		boolean isFirstUser = userPersistencePort.countUser() == 0;
		user.assignDefaultRole(isFirstUser);
		return userPersistencePort.saveUser(user);
	}

	@Override
	public List<UserModel> findAllUsers() {
		return userPersistencePort.findAllUsers();
	}

	@Override
	public UserModel findUserById(Long id) throws UserNotFoundException {
		return userPersistencePort.findUserById(id)
				.orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
	}

	@Override
	public UserModel updateUserById(Long id, UserModel newUser) throws UserNotFoundException {
		return userPersistencePort.findUserById(id)
				.map(savedUser -> {
					savedUser.setFirstName(newUser.getFirstName());
					savedUser.setLastName(newUser.getLastName());
					savedUser.setEmail(newUser.getEmail());
					savedUser.setPassword(newUser.getPassword());
					savedUser.setRole(RoleEnum.EMPLOYEE);
					return userPersistencePort.saveUser(savedUser);
				})
				.orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));	
	}
	
	@Override
	public UserModel patchUserById(Long id, Map<String, Object> updates) throws UserNotFoundException {
		UserModel user = userPersistencePort.findUserById(id)
				.orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));	
		
		updates.forEach((key, value) -> {
			switch (key) {
			case "firstName" -> user.setFirstName((String) value);
			case "lastName" -> user.setLastName((String) value);
			case "email" -> user.setEmail((String) value);
			case "password" -> user.setPassword((String) value);			
			}
		});
		return userPersistencePort.saveUser(user);
	}

	@Override
	public void deleteUserById(Long id) throws UserNotFoundException {
		if (userPersistencePort.findUserById(id).isEmpty()) {
			throw new UserNotFoundException("User with ID " + id + " not found");
		}
		userPersistencePort.deleteUserById(id);
	}
}
