package com.nxhu.restfull_api.user.infrastructure.adapters.in.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxhu.restfull_api.user.application.ports.in.UserServicePort;
import com.nxhu.restfull_api.user.domain.exception.UserNotFoundException;
import com.nxhu.restfull_api.user.domain.model.UserModel;
import com.nxhu.restfull_api.user.infrastructure.adapters.in.rest.mapper.UserRestMapper;
import com.nxhu.restfull_api.user.infrastructure.adapters.in.rest.model.request.UserCreateRequest;
import com.nxhu.restfull_api.user.infrastructure.adapters.in.rest.model.response.UserResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestAdapter {

	private final UserServicePort userServicePort;
	private final UserRestMapper userRestMapper;
	
	@PostMapping("/v1/api")
	public ResponseEntity<UserResponse> saveUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
//		req -> model -> entidad
		UserResponse savedUser = userRestMapper.toUserResponse(userServicePort.saveUser(userRestMapper.toUserModel(userCreateRequest)));
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/v1/api")
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		List<UserResponse> userResponses = userRestMapper.toUserResponses(userServicePort.findAllUsers());
		return new ResponseEntity<>(userResponses, HttpStatus.OK);
	}
	
	@GetMapping("/v1/api/{id}")
	public ResponseEntity<UserResponse> findUserById(@PathVariable Long id) throws UserNotFoundException {
		UserResponse user = userRestMapper.toUserResponse(userServicePort.findUserById(id));
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PutMapping("/v1/api/{id}")
	public ResponseEntity<UserResponse> updateUserById(@PathVariable Long id, @Valid @RequestBody UserCreateRequest userCreateRequest) throws UserNotFoundException {
		UserModel userModel = userServicePort.updateUserById(id, userRestMapper.toUserModel(userCreateRequest));
		UserResponse updatedUser = userRestMapper.toUserResponse(userModel);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@PatchMapping("/v1/api/{id}")
	public ResponseEntity<UserResponse> patchUserById(
			@PathVariable Long id, @RequestBody Map<String, Object> updates) throws UserNotFoundException {
		UserModel userModel = userServicePort.patchUserById(id, updates);
		UserResponse updatedUser = userRestMapper.toUserResponse(userModel);
		
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/v1/api/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws UserNotFoundException {
		userServicePort.deleteUserById(id);
		return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
	}
	
	
}
