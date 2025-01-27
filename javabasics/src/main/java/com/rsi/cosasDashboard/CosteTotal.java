package com.rsi.cosasDashboard;

import java.util.HashMap;
import java.util.Map;

public class CosteTotal {
 
    public static void main(String[] args) {
        // Mapa 1: idPersona -> coste por hora
        Map<Integer, Double> costePorHora = new HashMap<>();
        costePorHora.put(1, 50.0);
        costePorHora.put(2, 75.0);
        costePorHora.put(3, 100.0);
 
        // Mapa 2: idPersona -> horas imputadas
        Map<Integer, Integer> horasImputadas = new HashMap<>();
        horasImputadas.put(1, 10);
        horasImputadas.put(2, 8);
        horasImputadas.put(3, 5);
 
        // Calcular el coste total
        double costeTotal= calcularCosteTotal(costePorHora, horasImputadas);
 
        System.out.println("El coste total de las horas imputadas es: " + costeTotal);
    }
 
    public static double calcularCosteTotal(Map<Integer, Double> costePorHora, Map<Integer, Integer> horasImputadas) {
        double total=0.0;
 
        for (Map.Entry<Integer, Integer> entry : horasImputadas.entrySet()) {
            Integer idPersona = entry.getKey();
            Integer horas = entry.getValue();
            // Verificar si el idPersona existe en ambos mapas
            if (costePorHora.containsKey(idPersona)) {
                Double costeHora = costePorHora.get(idPersona);
                total += costeHora * horas; // Sumar al total el coste por las horas imputadas
            }
        }
        return total;
    }

}
