package com.BarkMap.BarkMap.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOM_UTILISATEUR")
    private String username;

    @Column(name = "PRENOM")
    private String firstName;

    @Column(name = "NOM")
    private String lastName;

    @Column(name = "BIOGRAPHIE")
    private String biographie;

    @Column(name = "PHOTO", length = Integer.MAX_VALUE)
    private String photo;

    @Embedded
    private Credentials credentials;

    public Compte(String username, String firstName, String lastName, String biographie, String photo, Credentials credentials) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biographie = biographie;
        this.photo = photo;
        this.credentials = credentials;
    }

    public Compte(Credentials credentials, String username, String firstName, String lastName, String photo) {
        this.credentials = credentials;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
    }

    public Compte(String username, String photo) {
        this.username = username;
        this.photo = photo;
    }

    public String getEmail(){
        return credentials.getEmail();
    }

    public String getPassword(){
        return credentials.getPassword();
    }

    public Collection<? extends GrantedAuthority> getAuthorities(){
        return credentials.getAuthorities();
    }

}
