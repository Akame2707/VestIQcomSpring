package com.senai.vestiq.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class UsuarioDTO {
    @NotBlank(message = "O campo nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "O campo senha não pode ser nulo")
    private String senha;

    
    @NotBlank(message = "O campo cargo não pode ser nulo")
    private String cargo;

    @Email 
    @NotBlank(message = "O email cargo não pode ser nulo")
    private String email;
}