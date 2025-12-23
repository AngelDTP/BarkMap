package com.BarkMap.BarkMap.Service.mapper;

import com.BarkMap.BarkMap.Models.Compte;
import com.BarkMap.BarkMap.Models.Credentials;
import com.BarkMap.BarkMap.Service.dto.CompteDTO;
import com.BarkMap.BarkMap.Service.dto.CredentialsDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompteMapper {

    public CompteMapper() {

    }

    public CompteDTO toDTO(Compte compte) {
        return new CompteDTO(
            compte.getUsername(),
            compte.getFirstName(),
            compte.getLastName(),
            compte.getBiographie(),
            compte.getPhoto(),
            new CredentialsDTO(
                compte.getCredentials().getEmail(),
                compte.getCredentials().getPassword(),
                compte.getCredentials().getRole()
            )
        );
    }

    public Compte toEntity(CompteDTO compteDTO) {
        return new Compte(
            compteDTO.getUsername(),
            compteDTO.getFirstName(),
            compteDTO.getLastName(),
            compteDTO.getBiographie(),
            compteDTO.getPhoto(),
            new Credentials(
                compteDTO.getCredentials().getEmail(),
                compteDTO.getCredentials().getPassword(),
                compteDTO.getCredentials().getRole()
            )
        );
    }
}
