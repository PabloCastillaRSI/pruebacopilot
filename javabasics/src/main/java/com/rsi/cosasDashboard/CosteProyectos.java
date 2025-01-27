package com.rsi.cosasDashboard;

import java.math.BigDecimal;

public class CosteProyectos {

    private String nombreProyecto;
    private BigDecimal costeHora;

    public CosteProyectos(String nombreProyecto, BigDecimal costeHora) {
        this.nombreProyecto = nombreProyecto;
        this.costeHora = costeHora;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public BigDecimal getCosteHora() {
        return costeHora;
    }

    public void setCosteHora(BigDecimal costeHora) {
        this.costeHora = costeHora;
    }
}
