package com.lds.aluguel_carros.entity;

import java.math.BigDecimal;

import com.lds.aluguel_carros.enums.StatusContrato;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
public class ContratoAluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O status é obrigatório")
    @Enumerated(EnumType.STRING)
    @Schema(description = "Status do contrato")
    private StatusContrato status;

    @NotNull(message = "O valor total é obrigatório")
    @Positive(message = "O valor total deve ser positivo")
    @Schema(description = "Valor total do contrato", example = "24000.00")
    private BigDecimal valorTotal;

    @OneToOne
    @JoinColumn(name = "credito_id")
    private Credito credito;

    @ManyToOne
    @JoinColumn(name = "propriedade_id")
    private Usuario propriedade;
}
