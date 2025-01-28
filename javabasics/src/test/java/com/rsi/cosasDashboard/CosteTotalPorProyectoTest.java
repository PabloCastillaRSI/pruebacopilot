package com.rsi.cosasDashboard;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CosteTotalPorProyectoTest {

    @Test
    public void testCalcularCostePorProyecto() {
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
        Map<String, Double> costePorProyecto = CosteTotalPorProyecto.calcularCostePorProyecto(costePorHora, horasPorProyecto);

        // Verificar los resultados
        assertEquals(650.0, costePorProyecto.get("ProyectoA"));
        assertEquals(650.0, costePorProyecto.get("ProyectoB"));
        assertEquals(200.0, costePorProyecto.get("ProyectoC"));
    }

}