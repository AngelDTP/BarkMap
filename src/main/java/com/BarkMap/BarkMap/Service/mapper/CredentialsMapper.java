package com.BarkMap.BarkMap.Service.mapper;

import com.BarkMap.BarkMap.Models.Credentials;
import com.BarkMap.BarkMap.Service.dto.CredentialsDTO;
import org.springframework.stereotype.Component;

@Component
public class CredentialsMapper {
    public CredentialsDTO toDTO(Credentials credentials) {
        return new CredentialsDTO(
                credentials.getEmail(),
                credentials.getPassword(),
                credentials.getRole());
    }

    public Credentials toEntity(CredentialsDTO credentialsDTO) {
        return new Credentials(
                credentialsDTO.getEmail(),
                credentialsDTO.getPassword(),
                credentialsDTO.getRole());
    }
}
