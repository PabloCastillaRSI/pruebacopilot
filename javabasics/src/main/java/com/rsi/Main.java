package com.rsi;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        Persona<Coche> p2 = new Persona<>("JuanPa", List.of(new Coche("yaris"), new Coche("chili")));
        Persona<Coche> p3 = new Persona<>("JuanPa", List.of(new Yaris(), new Chili()));



        Main.pintaModelo(p2.getLista());
        Main.pintaModelo(p3.getLista());


    }

    public static void pintaModelo(List<Coche> lista) {
        lista.forEach(c -> System.out.println(c.getModelo()));
    }
}
