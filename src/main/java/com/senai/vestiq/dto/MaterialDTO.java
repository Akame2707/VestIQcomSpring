package com.senai.vestiq.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class MaterialDTO {

    @NotBlank(message = "O campo tipo não pode ser nulo")
    @Size(max = 50, message = "O campo tipo não pode ter mais de 50 caracteres")
    private String tipo;
    
    @NotBlank(message = "O campo nome não pode ser nulo") 
    @Size(max = 150, message = "O campo nome não pode ter mais de 150 caracteres")
    private String nome;
    
    @NotNull(message = "O campo quantidade não pode ser nulo")
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    private int quantidade;
}
