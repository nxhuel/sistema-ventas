package com.nxhu.restfull_api;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nxhu.restfull_api.user.domain.model.RoleEnum;
import com.nxhu.restfull_api.user.infrastructure.adapters.out.persistence.entity.UserEntity;
import com.nxhu.restfull_api.user.infrastructure.adapters.out.persistence.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SistemaVentasApplication implements CommandLineRunner{
	
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaVentasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Esbozo de método generado automáticamente
		List<UserEntity> userEntities = Arrays.asList(
				new UserEntity(null, "Nahuel", "Tisera", "nahueltisera03@gmail.com", "nahuelPass1234", RoleEnum.ADMIN),
				new UserEntity(null, "Juan", "Pérez", "juan.perez@example.com", "juanPass1234", RoleEnum.EMPLOYEE),
				new UserEntity(null, "María", "Gómez", "maria.gomez@example.com", "mariaPass1234", RoleEnum.EMPLOYEE),
				new UserEntity(null, "Carlos", "Fernández", "carlos.fernandez@example.com", "carlosPass1234", RoleEnum.EMPLOYEE),
				new UserEntity(null, "Lucía", "Martínez", "lucia.martinez@example.com", "luciaPass1234", RoleEnum.EMPLOYEE),
				new UserEntity(null, "Javier", "Rodríguez", "javier.rodriguez@example.com", "javierPass1234", RoleEnum.EMPLOYEE),
				new UserEntity(null, "Ana", "López", "ana.lopez@example.com", "anaPass1234", RoleEnum.EMPLOYEE),
				new UserEntity(null, "Pedro", "Sánchez", "pedro.sanchez@example.com", "pedroPass1234", RoleEnum.EMPLOYEE),
				new UserEntity(null, "Laura", "Ramírez", "laura.ramirez@example.com", "lauraPass1234", RoleEnum.EMPLOYEE),
				new UserEntity(null, "Diego", "Torres", "diego.torres@example.com", "diegoPass1234", RoleEnum.EMPLOYEE),
				new UserEntity(null, "Sofía", "Morales", "sofia.morales@example.com", "sofiaPass1234", RoleEnum.EMPLOYEE)
				);
		
		userRepository.saveAll(userEntities);
	}
}
