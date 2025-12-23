package com.BarkMap.BarkMap.Presentation;

import com.BarkMap.BarkMap.Service.CompteService;
import com.BarkMap.BarkMap.Service.dto.CompteDTO;
import com.BarkMap.BarkMap.Service.dto.JWTAuthResponse;
import com.BarkMap.BarkMap.Service.dto.LoginDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/compte")
@CrossOrigin(origins = "http://localhost:3000")
public class CompteController {

    private final CompteService compteService;

    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @PostMapping("/creerCompte")
    public ResponseEntity<CompteDTO> creerEtudiant(@RequestBody CompteDTO compteDTO) {

        try {
            Optional<CompteDTO> compteCree = compteService.creerCompte(compteDTO);

            if (compteCree.isPresent()) {

                return ResponseEntity.status(HttpStatus.CREATED).body(compteCree.get());
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            System.out.println("Erreur lors de la création du compte : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDTO loginDto){
        System.out.println("Login: " + loginDto.getEmail() + " " + loginDto.getPassword());
        try {
            String accessToken = compteService.authenticateUser(loginDto);
            System.out.println("Token: " + accessToken);
            final JWTAuthResponse authResponse = new JWTAuthResponse(accessToken);
            return ResponseEntity.accepted()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(authResponse);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JWTAuthResponse());
        }
    }

    @GetMapping("/me")
    public ResponseEntity<CompteDTO> getMe(HttpServletRequest request){
        return ResponseEntity.accepted().contentType(MediaType.APPLICATION_JSON).body(
                compteService.getMe(request.getHeader("Authorization")));
    }
}