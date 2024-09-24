package com.lds.aluguel_carros.enums;

import java.math.BigDecimal;

public enum PrazoAluguel {
    MESES_12,
    MESES_24,
    MESES_36,
    MESES_48;

    public BigDecimal multiplier() {
        return switch (this) {
            case MESES_12 -> new BigDecimal("12");
            case MESES_24 -> new BigDecimal("24");
            case MESES_36 -> new BigDecimal("36");
            case MESES_48 -> new BigDecimal("48");
        };
    }
}