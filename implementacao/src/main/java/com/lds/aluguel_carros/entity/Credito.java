package com.lds.aluguel_carros.entity;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
public class Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser positivo")
    @Schema(description = "Valor do crédito", example = "24000.00")
    private BigDecimal valor;

    @NotNull(message = "A taxa de juros é obrigatória")
    @Positive(message = "A taxa de juros deve ser positiva")
    @Schema(description = "Taxa de juros do crédito", example = "0.05")
    private BigDecimal taxaJuros;

    @ManyToOne
    @JoinColumn(name = "concedente_id")
    private FuncionarioBanco concedente;
}
