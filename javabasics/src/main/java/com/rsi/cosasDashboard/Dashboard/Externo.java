package com.rsi.cosasDashboard.Dashboard;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Externo implements Persona{

    private Integer id;
    private     String        nombre;
    private     BigDecimal    costeHora;
    private     Area          area;
    private     Proveedor     proveedor;
    private LocalDate fechaIncorporacion;


    public Externo(Integer id, String nombre, BigDecimal costeHora, Area area, Proveedor proveedor, LocalDate fechaIncorporacion) {
        this.id = id;
        this.nombre = nombre;
        this.costeHora = costeHora;
        this.area = area;
        this.proveedor = proveedor;
        this.fechaIncorporacion = fechaIncorporacion;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return this.proveedor;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
        return "Externo{" + "id=" + id + ", nombre='" + nombre + '\'' + ", costeHora=" + costeHora + ", area=" + area + ", proveedor=" + proveedor + ", fechaIncorporacion=" + fechaIncorporacion + '}';
    }
}
