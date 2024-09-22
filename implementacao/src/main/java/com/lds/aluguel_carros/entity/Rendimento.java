package com.lds.aluguel_carros.entity;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
public class Rendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Schema(description = "Nome da fonte de rendimento", example = "Empresa X")
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Pattern(regexp = "\\d{14}", message = "CNPJ inválido")
    @Schema(description = "CNPJ da empresa", example = "12345678000190")
    private String cnpj;

    @NotNull(message = "O status atual é obrigatório")
    @Schema(description = "Indica se é o rendimento atual")
    private boolean atual;

    @NotNull(message = "A renda é obrigatória")
    @Positive(message = "A renda deve ser um valor positivo")
    @Schema(description = "Valor da renda", example = "5000.00")
    private BigDecimal renda;

    @NotNull(message = "A data de início é obrigatória")
    @Past(message = "A data de início deve ser no passado")
    @Schema(description = "Data de início do rendimento", example = "2022-01-01")
    private Date dataInicio;

    @Schema(description = "Data de fim do rendimento", example = "2023-12-31")
    private Date dataFim;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
