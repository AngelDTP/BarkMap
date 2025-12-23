package com.BarkMap.BarkMap.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompteDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String biographie;
    private String photo;
    private CredentialsDTO credentials;

    public CompteDTO(CredentialsDTO credentials, String username, String firstName, String lastName, String photo) {
        this.credentials = credentials;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
    }

    public CompteDTO(String username, String photo) {
        this.username = username;
        this.photo = photo;
    }
}
