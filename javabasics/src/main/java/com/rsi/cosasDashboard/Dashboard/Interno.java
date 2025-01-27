package com.rsi.cosasDashboard.Dashboard;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Interno implements Persona {

    private static final String RSI = "Rural Servicios Informaticos";

    private Integer id;
    private String nombre;
    private BigDecimal costeHora;
    private Area area;
    private LocalDate fechaIncorporacion;


    public Interno(Integer id, String nombre, Area area, BigDecimal costeHora, LocalDate fechaIncorporacion) {
        this.id = id;
        this.nombre = nombre;
        this.area = area;
        this.costeHora = costeHora;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Interno() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCosteHora() {
        return costeHora;
    }

    public void setCosteHora(BigDecimal costeHora) {
        this.costeHora = costeHora;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Interno{" + "id=" + id + ", nombre='" + nombre + '\'' + ", costeHora=" + costeHora + ", area=" + area + ", fechaIncorporacion=" + fechaIncorporacion + '}';
    }
}
