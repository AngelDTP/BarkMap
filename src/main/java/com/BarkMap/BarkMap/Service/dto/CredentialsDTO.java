package com.BarkMap.BarkMap.Service.dto;

import com.BarkMap.BarkMap.Models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CredentialsDTO {
    private String email;
    private String password;
    private Role role;
}
