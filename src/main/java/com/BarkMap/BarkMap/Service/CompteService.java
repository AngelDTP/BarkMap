package com.BarkMap.BarkMap.Service;

import com.BarkMap.BarkMap.Models.Compte;
import com.BarkMap.BarkMap.Models.Credentials;
import com.BarkMap.BarkMap.Repository.CompteRepository;
import com.BarkMap.BarkMap.Security.JwtTokenProvider;
import com.BarkMap.BarkMap.Security.exception.UserNotFoundException;
import com.BarkMap.BarkMap.Service.dto.CompteDTO;
import com.BarkMap.BarkMap.Service.dto.CredentialsDTO;
import com.BarkMap.BarkMap.Service.dto.LoginDTO;
import com.BarkMap.BarkMap.Service.mapper.CompteMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompteService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;

    private final CompteRepository compteRepository;

    private final CompteMapper compteMapper;

    public CompteService(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder, CompteRepository compteRepository, CompteMapper compteMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.compteRepository = compteRepository;
        this.compteMapper = compteMapper;
    }

    public Optional<CompteDTO> creerCompte(CompteDTO compteDTO) {
        try {
            CredentialsDTO credentials = compteDTO.getCredentials();
            if (credentials == null) {
                return Optional.empty();
            }
            String encodedPassword = passwordEncoder.encode(credentials.getPassword());

            Compte compte = new Compte(
                    compteDTO.getUsername(),
                    compteDTO.getFirstName(),
                    compteDTO.getLastName(),
                    compteDTO.getBiographie(),
                    compteDTO.getPhoto(),
                new Credentials(credentials.getEmail(), encodedPassword, credentials.getRole())
            );

            Compte compteSauvegarde = compteRepository.save(compte);
            return Optional.of(compteMapper.toDTO(compteSauvegarde));
        } catch (Exception e) {
            System.out.println("Erreur lors de la création du compte : " + e.getMessage());
            return Optional.empty();
        }
    }

    public String authenticateUser(LoginDTO loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        return jwtTokenProvider.generateToken(authentication);
    }

    public CompteDTO getMe(String token) {
        token = token.startsWith("Bearer") ? token.substring(7) : token;
        String email = jwtTokenProvider.getEmailFromJWT(token);
        System.out.println("Email: " + email);
        Compte user = compteRepository.findUserAppByEmail(email).orElseThrow(UserNotFoundException::new);
        return compteMapper.toDTO(user);
    }
}
