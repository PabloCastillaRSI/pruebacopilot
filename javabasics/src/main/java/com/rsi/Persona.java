package com.rsi;

import java.util.List;

public class Persona <V> {

    private String  nombre;
    private List<V> lista;

    public Persona(String nombre, List<V> lista) {
        this.nombre = nombre;
        this.lista = lista;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<V> getLista() {
        return lista;
    }

    public void setLista(List<V> lista) {
        this.lista = lista;
    }


    public Integer getNCoches() {
         return lista.size();
    }
}
