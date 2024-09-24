package com.lds.aluguel_carros.entity;

import java.util.Date;

import com.lds.aluguel_carros.enums.PrazoAluguel;
import com.lds.aluguel_carros.enums.StatusPedido;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
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
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O prazo é obrigatório")
    @Enumerated(EnumType.STRING)
    @Schema(description = "Prazo do aluguel", example = "MESES_12")
    private PrazoAluguel prazo;

    @NotNull(message = "O status é obrigatório")
    @Enumerated(EnumType.STRING)
    @Schema(description = "Status do pedido de aluguel", example = "PENDENTE")
    private StatusPedido status;

    @NotNull(message = "A data de início é obrigatória")
    @Schema(description = "Data de início do aluguel", example = "2023-07-01")
    private Date dataInicio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contrato_id")
    private ContratoAluguel contrato;

    @ManyToOne
    @JoinColumn(name = "automovel_id")
    private Automovel automovel;

    @NotNull(message = "A opção de adquirir propriedade é obrigatória")
    @Schema(description = "Indica se o cliente deseja adquirir a propriedade ao final do contrato")
    private boolean adquirirPropriedade;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}