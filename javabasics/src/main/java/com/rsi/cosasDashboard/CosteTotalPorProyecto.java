package com.rsi.cosasDashboard;

import java.util.Map;
import java.util.HashMap;

public class CosteTotalPorProyecto {

    public static void main(String[] args) {
        // Mapa 1: idPersona -> coste por hora
        Map<Integer, Double> costePorHora = new HashMap<>();
        costePorHora.put(1, 50.0);
        costePorHora.put(2, 75.0);
        costePorHora.put(3, 100.0);

        // Mapa 2: idPersona -> {proyecto -> horas imputadas}
        Map<Integer, Map<String, Integer>> horasPorProyecto = new HashMap<>();

        // Datos de ejemplo
        Map<String, Integer> proyectosPersona1 = new HashMap<>();
        proyectosPersona1.put("ProyectoA", 5);
        proyectosPersona1.put("ProyectoB", 5);
        horasPorProyecto.put(1, proyectosPersona1);

        Map<String, Integer> proyectosPersona2 = new HashMap<>();
        proyectosPersona2.put("ProyectoA", 8);
        horasPorProyecto.put(2, proyectosPersona2);

        Map<String, Integer> proyectosPersona3 = new HashMap<>();
        proyectosPersona3.put("ProyectoB", 3);
        proyectosPersona3.put("ProyectoC", 2);
        horasPorProyecto.put(3, proyectosPersona3);

        // Calcular el coste total por proyecto
        Map<String, Double> costePorProyecto = calcularCostePorProyecto(costePorHora, horasPorProyecto);

        // Mostrar los resultados
        double costeTotal = 0.0;
        for (Map.Entry<String, Double> entry : costePorProyecto.entrySet()) {
            String proyecto = entry.getKey();
            double coste = entry.getValue();
            System.out.println("Coste total para " + proyecto + ": " + coste);
            costeTotal += coste; // Acumular el coste total
        }
        System.out.println(costeTotal);
    }

    public static Map<String, Double> calcularCostePorProyecto(
            Map<Integer, Double> costePorHora,
            Map<Integer, Map<String, Integer>> horasPorProyecto) {
        // Mapa para almacenar el coste total por proyecto
        Map<String, Double> costePorProyecto = new HashMap<>();

        // Recorrer cada persona y sus proyectos
        for (Map.Entry<Integer, Map<String, Integer>> entryPersona : horasPorProyecto.entrySet()) {
            Integer idPersona = entryPersona.getKey();
            Map<String, Integer> proyectos = entryPersona.getValue();

            // Verificar si existe el coste por hora para esta persona
            if (costePorHora.containsKey(idPersona)) {
                Double costeHora = costePorHora.get(idPersona);

                // Calcular el coste por proyecto
                for (Map.Entry<String, Integer> entryProyecto : proyectos.entrySet()) {
                    String proyecto = entryProyecto.getKey();
                    Integer horas = entryProyecto.getValue();

                    // Acumular el coste total por proyecto
                    costePorProyecto.merge(proyecto, costeHora * horas, Double::sum);
                }
            }
        }

        return costePorProyecto;
    }
}
