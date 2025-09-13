package com.nxhu.sistema_ventas.user.infrastructure.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nxhu.sistema_ventas.user.application.ports.out.UserPersistencePort;
import com.nxhu.sistema_ventas.user.domain.model.UserModel;
import com.nxhu.sistema_ventas.user.infrastructure.adapters.out.persistence.mapper.UserPersistenceMapper;
import com.nxhu.sistema_ventas.user.infrastructure.adapters.out.persistence.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {
	
	private final UserRepository userRepository;
	private final UserPersistenceMapper userPersistenceMapper;
	
	@Override
	public UserModel saveUser(UserModel userModel) {
		return userPersistenceMapper.toUserModel(userRepository.save(userPersistenceMapper.toUserEntity(userModel)));
	}

	@Override
	public List<UserModel> findAllUsers() {
		return userPersistenceMapper.toUserModels(userRepository.findAll());
	}

	@Override
	public Optional<UserModel> findUserById(Long id) {
		return userRepository.findById(id).map(userPersistenceMapper::toUserModel);
		// userRepository.findById(id).map(entity -> userPersistenceMapper.toUserModel(entity));
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public long countUser() {
		return userRepository.count();
	}
}
