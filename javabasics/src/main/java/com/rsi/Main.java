package com.rsi;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Persona<Coche>> personas = generarPersonasFijas();

        //pintar los nombres de toddas las personas que tengan un coche que sea Chili
        List<String> nombrePersonasChili = getNombresPersonasChiliLambda(personas);
        nombrePersonasChili.forEach(System.out::println);
        System.out.println("--------------------------------------");

        //nombre de las personas que no tienen coches que tengan letras que coincidan con las de su nombre
        List<String> nombrePersonas = personas.stream()
            .filter(p -> p.getLista().stream().allMatch(c -> c.getModelo().chars().noneMatch(ch -> p.getNombre().chars().anyMatch(ch2 -> ch2 == ch))))
            .map(Persona::getNombre)
            .toList();
        nombrePersonas.forEach(System.out::println);
        System.out.println("--------------------------------------");
        double resultado = raizCuadradaSegundoGrado(3, 43, 4);
        System.out.println(resultado);
    }


    //Método que resuelva una ecuación de segundo grado de la forma ax^2 + bx + c = 0
    public static double raizCuadradaSegundoGrado(double a, double b, double c) {
        double discriminante = Math.pow(b, 2) - 4 * a * c;
        if (discriminante < 0) {
            return Double.NaN;
        }
        double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
        return Math.max(x1, x2);
    }



    private static List<String> getNombresPersonasChiliLambda(List<Persona<Coche>> personas) {
        return personas.stream()
                .filter(p -> p.getLista().stream().anyMatch(c -> c.getModelo().equals("Chili")))
                .map(Persona::getNombre)
                .toList();
    }

    public static void pintaModelo(List<Coche> lista) {
        lista.forEach(c -> System.out.println(c.getModelo()));
    }

    public static List<Persona<Coche>> generarPersonasFijas() {
        List<Persona<Coche>> personas = new ArrayList<>();

        personas.add(new Persona<>("Juan", List.of(new Coche("Yaris"), new Coche("Chili"))));
        personas.add(new Persona<>("Pedro", List.of(new Coche("Civic"))));
        personas.add(new Persona<>("Maria", List.of(new Coche("Corolla"), new Coche("Mustang"))));
        personas.add(new Persona<>("Ana", List.of(new Coche("Yaris"))));
        personas.add(new Persona<>("Luis", List.of(new Coche("Chili"), new Coche("Civic"))));
        personas.add(new Persona<>("Carlos", List.of(new Coche("Corolla"))));
        personas.add(new Persona<>("Laura", List.of(new Coche("Mustang"), new Coche("Yaris"))));
        personas.add(new Persona<>("Marta", List.of(new Coche("Chili"))));
        personas.add(new Persona<>("Jose", List.of(new Coche("Civic"), new Coche("Corolla"))));
        personas.add(new Persona<>("Elena", List.of(new Coche("Mustang"))));

        return personas;
    }


}
