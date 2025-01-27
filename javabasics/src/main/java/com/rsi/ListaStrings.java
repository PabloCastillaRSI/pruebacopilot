package com.rsi;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class ListaStrings {

    public static void main(String[] args) {


//        BinaryOperator<Date> max = (a, b) -> a.after(b) ? a : b;
//        System.out.println(max.apply(new Date(1989, Calendar.OCTOBER,14), new Date(1990, Calendar.AUGUST,7)));

        // BinaryOperator para comparar LocalDateTime
        BinaryOperator<LocalDateTime> max = (a, b) -> a.isAfter(b) ? a : b;

        // Lista de fechas y horas
        List<LocalDateTime> dates = Arrays.asList(
            LocalDateTime.of(1989, Month.OCTOBER, 14, 10, 30),
            LocalDateTime.of(1990, Month.AUGUST, 7, 15, 45),
            LocalDateTime.of(1985, Month.JULY, 24, 8, 15),
            LocalDateTime.of(2015, Month.JANUARY, 15, 12, 0)
        );

        // Encontrar la fecha más reciente
        LocalDateTime mostRecentDate = dates.stream()
                                            .reduce(max)
                                            .orElse(null); // Manejar caso de lista vacía

        // Imprimir la fecha más reciente
        System.out.println("Fecha más reciente: " + mostRecentDate);

        List<String> listaCompleta = List.of("Manue", "Joze", "Luca", "Omar", "Tomastur","Gonzalolalo");

        Predicate<String> filtro = generateFilter("o");
        List<String> listaFiltrada = listaCompleta.stream()
                .filter(filtro)
                .toList();

        System.out.println(listaFiltrada);



        List<Integer> listaMapeada = listaFiltrada.stream()
                .map(String::length)
                .toList();

        System.out.println(listaMapeada);
        Integer resultado = listaMapeada
                .stream()
                .reduce(0, Integer::sum);
        System.out.println(resultado);

    }

    private static Predicate<String> generateFilter(String character) {
        String upperCaseCharacter = character.toUpperCase();
        return (String text) -> text.toUpperCase().contains(upperCaseCharacter);

    }
}

