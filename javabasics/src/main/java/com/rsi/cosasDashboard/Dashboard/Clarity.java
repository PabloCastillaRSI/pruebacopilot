package com.rsi.cosasDashboard.Dashboard;

public class Clarity {

    private String peticionClarity;
    private String nombreProyecto;
    private Double horasImputadas;
    private Integer idPersona;

    public Clarity(String peticionClarity, String nombreProyecto, Double horasImputadas, Integer idPersona) {
        this.peticionClarity = peticionClarity;
        this.nombreProyecto = nombreProyecto;
        this.horasImputadas = horasImputadas;
        this.idPersona = idPersona;
    }

    public String getPeticionClarity() {
        return peticionClarity;
    }

    public void setPeticionClarity(String peticionClarity) {
        this.peticionClarity = peticionClarity;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Double getHorasImputadas() {
        return horasImputadas;
    }

    public void setHorasImputadas(Double horasImputadas) {
        this.horasImputadas = horasImputadas;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Clarity{" + "peticionClarity='" + peticionClarity + '\'' + ", nombreProyecto='" + nombreProyecto + '\'' + ", horasImputadas=" + horasImputadas + ", idPersona=" + idPersona + '}';
    }
}
