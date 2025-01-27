package com.rsi.cosasDashboard.Dashboard.objetosAleatorios;
import com.rsi.cosasDashboard.Dashboard.Area;
import com.rsi.cosasDashboard.Dashboard.Externo;
import com.rsi.cosasDashboard.Dashboard.Interno;
import com.rsi.cosasDashboard.Dashboard.Persona;
import com.rsi.cosasDashboard.Dashboard.Proveedor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeneradorPersona {

    private static final Random random = new Random();

    // Método para comprobar si un año es bisiesto
    private static boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    //Método para obtener el número de días de un mes específico, teniendo en cuenta el año
    private static int obtenerDiasDelMes(int mes, int año) {
        return switch (mes) {  // Enero
            // Marzo
            // Mayo
            // Julio
            // Agosto
            // Octubre
            // Diciembre
            case 1, 3, 5, 7, 8, 10, 12 ->
                    31;
            // Abril
            // Junio
            // Septiembre
            // Noviembre
            case 4, 6, 9, 11 ->
                    30;
            case 2 ->  // Febrero
                    esBisiesto(año) ? 29 : 28;
            default -> throw new IllegalArgumentException("Mes no válido: " + mes);
        };
    }

    public List<Persona> obtenerListaPersonas(){
        List<Persona> randomPersonas = new ArrayList<>();
        for(int i =0; i<= 49;i++){
            randomPersonas.add(generarPersonaAleatoria(random.nextBoolean()));
        }
        return randomPersonas;
    }

    private static Persona generarPersonaAleatoria(boolean esInterno) {
        // Generar id aleatorio (por ejemplo, entre 1 y 1000)
        Integer id = random.nextInt(1000) + 1;

        // Generar nombre aleatorio (puedes mejorar esto usando una lista de nombres más amplia)
        List<String> nombres = Arrays.asList("Juan", "Ana", "Carlos", "Maria", "Luis", "Ronaldo", "Rincon", "Vegas", "Gonzalo", "Javier Aka El Jefe", "El Manager", "Jaime", "Tomastur");
        String nombre = nombres.get(random.nextInt(nombres.size()));

        // Generar costeHora aleatorio entre 10 y 100
        BigDecimal costeHora = BigDecimal.valueOf(10 + random.nextDouble() * 90).setScale(0,BigDecimal.ROUND_HALF_UP);//(2, BigDecimal.ROUND_HALF_UP);

        // Generar área aleatoria (puedes definir un enum de áreas para tener más control)
        List<Area> areas = Arrays.asList(Area.ANALISTA,Area.UX,Area.BACKEND,Area.NEGOCIO,Area.FRONTEND,Area.DATA); // Supón que tienes un enum Area
        Area area = areas.get(random.nextInt(areas.size()));

        // Generar proveedor aleatorio para Externo (si es un Externo)
        Proveedor proveedor = null;
        if (!esInterno) {
            List<Proveedor> proveedores = Arrays.asList(Proveedor.RANDSTAD, Proveedor.CAPITOL);
            proveedor = proveedores.get(random.nextInt(proveedores.size()));
        }

        // Generar fechaIncorporacion aleatoria (por ejemplo, entre 2000 y 2024)
        int anio = random.nextInt(24) + 2000;
        int mes = random.nextInt(12) + 1;
        int dia = random.nextInt(obtenerDiasDelMes(mes,anio)) + 1;
        LocalDate fechaIncorporacion = LocalDate.of(anio, mes, dia);

        // Crear y devolver el objeto correspondiente según el tipo
        if (esInterno) {
            return new Interno(id, nombre, area, costeHora, fechaIncorporacion);
        } else {
            return new Externo(id, nombre, costeHora, area, proveedor, fechaIncorporacion);
        }
    }
}

