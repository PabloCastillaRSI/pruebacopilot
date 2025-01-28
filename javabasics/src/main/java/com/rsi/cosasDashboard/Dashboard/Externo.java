package com.rsi.cosasDashboard.Dashboard;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The Externo class represents an external employee with specific attributes such as id, name, hourly cost, area, provider, and incorporation date.
 */
public class Externo implements Persona {

    private Integer id;
    private String nombre;
    private BigDecimal costeHora;
    private Area area;
    private Proveedor proveedor;
    private LocalDate fechaIncorporacion;

    /**
     * Constructs a new Externo with the specified details.
     *
     * @param id the unique identifier of the employee
     * @param nombre the name of the employee
     * @param costeHora the hourly cost of the employee
     * @param area the area to which the employee belongs
     * @param proveedor the provider associated with the employee
     * @param fechaIncorporacion the date the employee was incorporated
     */
    public Externo(Integer id, String nombre, BigDecimal costeHora, Area area, Proveedor proveedor, LocalDate fechaIncorporacion) {
        this.id = id;
        this.nombre = nombre;
        this.costeHora = costeHora;
        this.area = area;
        this.proveedor = proveedor;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    /**
     * Gets the unique identifier of the employee.
     *
     * @return the unique identifier of the employee
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the employee.
     *
     * @param id the new unique identifier of the employee
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of the employee.
     *
     * @return the name of the employee
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the name of the employee.
     *
     * @param nombre the new name of the employee
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the hourly cost of the employee.
     *
     * @return the hourly cost of the employee
     */
    public BigDecimal getCosteHora() {
        return costeHora;
    }

    /**
     * Sets the hourly cost of the employee.
     *
     * @param costeHora the new hourly cost of the employee
     */
    public void setCosteHora(BigDecimal costeHora) {
        this.costeHora = costeHora;
    }

    /**
     * Gets the area to which the employee belongs.
     *
     * @return the area of the employee
     */
    public Area getArea() {
        return area;
    }

    /**
     * Sets the area to which the employee belongs.
     *
     * @param area the new area of the employee
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * Gets the provider associated with the employee.
     *
     * @return the provider associated with the employee
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * Sets the provider associated with the employee.
     *
     * @param proveedor the new provider associated with the employee
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Gets the incorporation date of the employee.
     *
     * @return the incorporation date of the employee
     */
    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    /**
     * Sets the incorporation date of the employee.
     *
     * @param fechaIncorporacion the new incorporation date of the employee
     */
    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    /**
     * Returns a string representation of the Externo object.
     *
     * @return a string representation of the Externo object
     */
    @Override
    public String toString() {
        return "Externo{" + "id=" + id + ", nombre='" + nombre + '\'' + ", costeHora=" + costeHora + ", area=" + area + ", proveedor=" + proveedor + ", fechaIncorporacion=" + fechaIncorporacion + '}';
    }
}