package com.nxhu.sistema_ventas;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.entity.CategoryEntity;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.entity.ProductEntity;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.repository.CategoryRepository;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.repository.ProductRepository;
import com.nxhu.sistema_ventas.user.domain.model.RoleEnum;
import com.nxhu.sistema_ventas.user.infrastructure.adapters.out.persistence.entity.UserEntity;
import com.nxhu.sistema_ventas.user.infrastructure.adapters.out.persistence.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SistemaVentasApplication implements CommandLineRunner{
	
	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaVentasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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
		
		List<CategoryEntity> categoryEntities = Arrays.asList(
				new CategoryEntity(null, "Tecnologia", "Tecnologia diversa", true, null),
				new CategoryEntity(null, "Educación", "Libros, cursos, etc", true, null),
				new CategoryEntity(null, "Servicios", "Disney plus, netflix, etc", true, null)
				);
		categoryRepository.saveAll(categoryEntities);
		
		List<ProductEntity> productEntities = Arrays.asList(
			    new ProductEntity(null, "SmartTv", "Tv 8 pulgadas", new BigDecimal("800000"), 500L, true, categoryEntities.get(0)),
			    new ProductEntity(null, "Laptop Gamer", "16GB RAM, RTX 3060", new BigDecimal("250000"), 50L, true, categoryEntities.get(0)),
			    new ProductEntity(null, "Auriculares Bluetooth", "Sony WH-1000XM4", new BigDecimal("45000"), 200L, true, categoryEntities.get(0)),
			    new ProductEntity(null, "Libro de Fisica", "Fisica II", new BigDecimal("12000"), 20L, true, categoryEntities.get(1)),
			    new ProductEntity(null, "Libro de Programacion Java", "Guia completa", new BigDecimal("15000"), 30L, true, categoryEntities.get(1)),
			    new ProductEntity(null, "Curso de Ingles Online", "Nivel intermedio", new BigDecimal("20000"), 25L, true, categoryEntities.get(1)),
			    new ProductEntity(null, "Netflix", "Servicio por 12 meses", new BigDecimal("10000"), 100L, true, categoryEntities.get(2)),
			    new ProductEntity(null, "Disney Plus", "12 meses de suscripción", new BigDecimal("12000"), 80L, true, categoryEntities.get(2)),
			    new ProductEntity(null, "Spotify Premium", "12 meses de suscripción", new BigDecimal("8000"), 150L, true, categoryEntities.get(2))
			);

		productRepository.saveAll(productEntities);
	}
}
