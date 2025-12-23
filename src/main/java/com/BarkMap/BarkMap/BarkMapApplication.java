package com.BarkMap.BarkMap;

import com.BarkMap.BarkMap.Models.Role;
import com.BarkMap.BarkMap.Service.AdminService;
import com.BarkMap.BarkMap.Service.CompteService;
import com.BarkMap.BarkMap.Service.dto.CompteDTO;
import com.BarkMap.BarkMap.Service.dto.CredentialsDTO;
import com.BarkMap.BarkMap.Service.dto.LoginDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BarkMapApplication implements CommandLineRunner {

	private final PasswordEncoder passwordEncoder;
	private final CompteService compteService;
	private final AdminService adminService;

	public BarkMapApplication(PasswordEncoder passwordEncoder, CompteService compteService, AdminService adminService) {
		this.passwordEncoder = passwordEncoder;
		this.compteService = compteService;
		this.adminService = adminService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BarkMapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*
		compteService.creerCompte(
				new CompteDTO(
						"AdminAngel192",
						"Angel",
						"Tenorio Paredes",
						"Créateur et administrateur de 'BarkMap'",
						null,
						new CredentialsDTO("email@gmail.com", "123", Role.GESTIONNAIRE)
				));

		compteService.authenticateUser(new LoginDTO("email@gmail.com", "123"));
 */
	}
}
