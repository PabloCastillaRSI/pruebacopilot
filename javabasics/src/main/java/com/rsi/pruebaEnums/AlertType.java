package com.rsi.pruebaEnums;

/**
 * The alert Card type.
 *
 * @author Javier del Pozo
 * @author Miguel Alonso
 * @author Gonzalo Blanco
 * @author Carlos Gómez
 * @author Victor Hernando
 */
public enum AlertType {

    /**
     * Saldo alert type.
     */
    SALDO(1),

    /**
     * Fecha alert type.
     */
    FECHA(3);

    private final int alertTypeCode;

    AlertType(final int alertTypeCode) {
        this.alertTypeCode = alertTypeCode;
    }

    public int getAlertTypeCode() {
        return alertTypeCode;
    }
}
