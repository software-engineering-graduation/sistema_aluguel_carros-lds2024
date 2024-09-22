package com.lds.aluguel_carros.entity;

import java.math.BigDecimal;

import com.lds.aluguel_carros.enums.StatusAutomovel;
import com.lds.aluguel_carros.enums.TipoUsuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A matrícula é obrigatória")
    @Schema(description = "Matrícula do automóvel", example = "ABC123")
    private String matricula;

    @NotNull(message = "O ano é obrigatório")
    @Min(value = 1900, message = "O ano deve ser maior que 1900")
    @Schema(description = "Ano do automóvel", example = "2022")
    private int ano;

    @NotBlank(message = "A marca é obrigatória")
    @Schema(description = "Marca do automóvel", example = "Toyota")
    private String marca;

    @NotBlank(message = "O modelo é obrigatório")
    @Schema(description = "Modelo do automóvel", example = "Corolla")
    private String modelo;

    @NotBlank(message = "A placa é obrigatória")
    @Pattern(regexp = "[A-Z]{3}[0-9]{4}", message = "Placa inválida")
    @Schema(description = "Placa do automóvel", example = "ABC1234")
    private String placa;

    @NotNull(message = "O status é obrigatório")
    @Enumerated(EnumType.STRING)
    @Schema(description = "Status do automóvel")
    private StatusAutomovel status;

    @NotNull(message = "O valor mensal é obrigatório")
    @Positive(message = "O valor mensal deve ser positivo")
    @Schema(description = "Valor mensal do aluguel", example = "1000.00")
    private BigDecimal valorMensal;

    @NotNull(message = "O proprietário é obrigatório")
    @NotBlank(message = "O proprietário é obrigatório")
    @Schema(description = "Proprietário do automóvel (CNPJ ou CPF)", example = "12345678910")
    private String proprietarioIdentificacao;

    @NotNull(message = "O tipo do proprietário é obrigatório")
    @Enumerated(EnumType.STRING)
    @Schema(description = "Tipo do proprietário", example = "CLIENTE")
    private TipoUsuario proprietarioTipo;
}
