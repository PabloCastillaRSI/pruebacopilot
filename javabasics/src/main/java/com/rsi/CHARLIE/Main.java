package com.rsi.CHARLIE;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Charlie!");
    }



    //quiero un un controlador que tenga endpoints para sumar, restar, multiplicar y dividir
    //cada uno de estos endpoints debe recibir dos números en el path y devolver el resultado de la operación
    @GetMapping("/sumar/{num1}/{num2}")
    public double sumar(@PathVariable double num1, @PathVariable double num2) {
        return num1 + num2;
    }

    @GetMapping("/restar/{num1}/{num2}")
    public double restar(@PathVariable double num1, @PathVariable double num2) {
        return num1 - num2;
    }

    @GetMapping("/multiplicar/{num1}/{num2}")
    public double multiplicar(@PathVariable double num1, @PathVariable double num2) {
        return num1 * num2;
    }

    @GetMapping("/dividir/{num1}/{num2}")
    public double dividir(@PathVariable double num1, @PathVariable double num2) {
        return num1 / num2;
    }

    @GetMapping("/raizCuadradaSegundoGrado/{a}/{b}/{c}")
    public double raizCuadradaSegundoGrado(@PathVariable double a, @PathVariable double b, @PathVariable double c) {
        double discriminante = Math.pow(b, 2) - 4 * a * c;
        if (discriminante < 0) {
            return 0;
        }
        double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
        return raiz1;
    }
@GetMapping("/modelo/{marca}")
public CarModel modelo(@PathVariable("marca") String marca) {
    switch (marca) {
        case "Audi":
            return new CarModel("Audi", "A4", 2023, "Petrol", 40000);
        case "BMW":
            return new CarModel("BMW", "X5", 2023, "Diesel", 60000);
        case "Mercedes":
            return new CarModel("Mercedes", "C-Class", 2023, "Hybrid", 50000);
        case "Volkswagen":
            return new CarModel("Volkswagen", "Golf", 2023, "Electric", 30000);
        case "Renault":
            return new CarModel("Renault", "Clio", 2023, "Petrol", 20000);
        case "Peugeot":
            return new CarModel("Peugeot", "208", 2023, "Diesel", 22000);
        case "Citroen":
            return new CarModel("Citroen", "C3", 2023, "Petrol", 21000);
        case "Fiat":
            return new CarModel("Fiat", "500", 2023, "Electric", 25000);
        case "Ford":
            return new CarModel("Ford", "Focus", 2023, "Hybrid", 27000);
        case "Opel":
            return new CarModel("Opel", "Astra", 2023, "Diesel", 23000);
        default:
            return new CarModel("Unknown", "Unknown", 0, "Unknown", 0);
    }
}

@GetMapping("/comparar/{marca1}/{marca2}")
public Map<String, CarModel> comparar(@PathVariable("marca1") String marca1, @PathVariable("marca2") String marca2) {
    CarModel car1 = modelo(marca1);
    CarModel car2 = modelo(marca2);

    Map<String, CarModel> comparison = new HashMap<>();
    comparison.put("car1", car1);
    comparison.put("car2", car2);

    return comparison;
}
    //quiero un controlador que tenga un endpoint que devuelva una lista de nombres de ciudades y pueda HACER CLIC CON EL RATON que diga UNA ciudad
    @GetMapping("/ciudades")
    public String[] ciudades() {
        return new String[] {"Madrid", "Barcelona", "Valencia", "Sevilla", "Zaragoza", "Málaga", "Murcia", "Palma", "Las Palmas", "Bilbao"};
    }

    @GetMapping("/ciudad")
    public String ciudad() {
        return "Ciudad";
    }







}
