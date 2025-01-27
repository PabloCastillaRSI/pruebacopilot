package com.rsi.cosasDashboard;
import java.util.Map;
import java.util.HashMap;

public class CosteTotal2 {

    // Clase para agrupar coste por hora y horas imputadas
    static class Datos {
        double costePorHora;
        int horasImputadas;

        public Datos(double costePorHora, int horasImputadas) {
            this.costePorHora = costePorHora;
            this.horasImputadas = horasImputadas;
        }
    }

    public static void main(String[] args) {
        // Mapa único: idPersona -> Datos (coste por hora y horas imputadas)
        Map<Integer, Datos> datosPersonas = new HashMap<>();
        datosPersonas.put(1, new Datos(50.0, 10));
        datosPersonas.put(2, new Datos(75.0, 8));
        datosPersonas.put(3, new Datos(100.0, 5));

        // Calcular el coste total
        double costeTotal = calcularCosteTotal(datosPersonas);

        System.out.println("El coste total de las horas imputadas es: " + costeTotal);
    }

    public static double calcularCosteTotal(Map<Integer, Datos> datosPersonas) {
        double total = 0.0;

        for (Map.Entry<Integer, Datos> entry : datosPersonas.entrySet()) {
            Datos datos = entry.getValue();
            total += datos.costePorHora * datos.horasImputadas; // Calcular y acumular
        }

        return total;
    }
}