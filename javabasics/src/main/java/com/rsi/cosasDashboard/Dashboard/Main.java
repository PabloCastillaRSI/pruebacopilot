package com.rsi.cosasDashboard.Dashboard;

import com.rsi.cosasDashboard.CosteProyectos;
import com.rsi.cosasDashboard.Dashboard.objetosAleatorios.GeneradorPersona;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


public class Main {

       public static void main(String[] args) {
//           Persona p1 = new Interno(1,"Gonzalo", Area.BACKEND, new BigDecimal(50), LocalDate.of(2015,7,10));
//           Persona p2 = new Interno(2,"Javi", Area.BACKEND, new BigDecimal(50), LocalDate.of(2014,7,5));
//           Persona p3 = new Interno(3,"Michenlo", Area.NEGOCIO, new BigDecimal(40), LocalDate.of(2010,1,6));
//           Persona p4 = new Interno(4,"Mikel", Area.NEGOCIO, new BigDecimal(70), LocalDate.of(2015,6,30));
//
//           Persona p5 = new Externo(5,"Rincon", new BigDecimal(15), Area.ANALISTA, Proveedor.RANDSTAD, LocalDate.of(1998,2,1));
//           Persona p11 = new Externo(11,"Rincon", new BigDecimal(15), Area.ANALISTA, Proveedor.RANDSTAD, LocalDate.of(1998,2,1));
//           Persona p12 = new Externo(12,"Rincon", new BigDecimal(15), Area.ANALISTA, Proveedor.RANDSTAD, LocalDate.of(1998,2,1));
//           Persona p13 = new Externo(13,"Rincon", new BigDecimal(15), Area.ANALISTA, Proveedor.RANDSTAD, LocalDate.of(1998,2,2));
//           Persona p6 = new Externo(6,"Carlos", new BigDecimal(30), Area.BACKEND, Proveedor.RANDSTAD, LocalDate.of(2000,7,1));
//           Persona p7 = new Externo(7,"Maria",  new BigDecimal(20),Area.NEGOCIO ,Proveedor.CAPITOL, LocalDate.of(2018,7,1));
//           Persona p8 = new Externo(8,"Marina",  new BigDecimal(18),Area.UX, Proveedor.CAPITOL, LocalDate.of(2002,7,1));
//           Persona p9 = new Externo(9,"Churumbembe",  new BigDecimal(11),Area.UX, Proveedor.CAPITOL, LocalDate.of(2020,7,1));
//
//           Persona p10 = new Interno();
//           List<Persona> empleados = List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p11,p12,p13);
//           List<Persona> empleados2 = List.of(p10, new Interno());
           GeneradorPersona generadorPersona = new GeneradorPersona();
           List<Persona> empleados = generadorPersona.obtenerListaPersonas();

           List<Integer> listaIdsP05248 = empleados.stream()
                   .map(Persona::getId)
                   .toList();


           List<Clarity> listaImputaciones = List.of(
                     new Clarity("P05248","Dashboard Managers", 15.00,listaIdsP05248.get(0)),
                     new Clarity("P05248","Dashboard Managers", 20.00,listaIdsP05248.get(1)),
                     new Clarity("P05248","Dashboard Managers", 50.00,listaIdsP05248.get(2)),
                     new Clarity("P05248","Dashboard Managers", 50.00,listaIdsP05248.get(9)),
                     new Clarity("P05255","METAS", 52.00,listaIdsP05248.get(2)),
                     new Clarity("P05255","METAS", 10.00,listaIdsP05248.get(7)),
                     new Clarity("P05255","METAS", 5.00,listaIdsP05248.get(8)),
                     new Clarity("P05255","METAS", 5.00,listaIdsP05248.get(9)),
                     new Clarity("P01111","NPS", 3.00,listaIdsP05248.get(9)),
                     new Clarity("P01111","NPS", 3.00,listaIdsP05248.get(2))
           );



           Map<String, BigDecimal> costePorProyecto = calculaCosteImputaciones(empleados, listaImputaciones);

           costePorProyecto.forEach((key, value) -> System.out.println("Coste total para " + key + ": " + value));

            Map<Area, BigDecimal> costePorArea = costePorArea(empleados, listaImputaciones);

            costePorArea.forEach((key, value) -> System.out.println("Coste total para " + key + ": " + value));

            List<CosteProyectos> costePorProyectos = calculaCosteImputacionesLista(empleados,listaImputaciones);

            costePorProyectos.forEach(elemento -> System.out.println("El coste para " + elemento.getNombreProyecto() + " es de: " + elemento.getCosteHora() ));

           Optional <BigDecimal> sumaCosteHora = empleados
                   .stream()
                   .filter(e -> e.getFechaIncorporacion().getMonth().equals(Month.FEBRUARY))
                   .filter(Externo.class::isInstance)
                   .map(Externo.class::cast)
                   .filter(e -> Area.UX.equals(e.getArea()) && Proveedor.CAPITOL.equals(e.getProveedor()))
                   .map(externo -> externo.getCosteHora())
                   .reduce(BigDecimal::add);

           System.out.println("La suma del coste/hora sería: " + sumaCosteHora);

           Integer numeroPersonasRandstad = 0;

           for (Persona empleado: empleados){
               if (empleado instanceof Externo empleado1) {
                   if (Proveedor.RANDSTAD.equals(empleado1.getProveedor())){
                       numeroPersonasRandstad++;
                   }
               }
           }
           //System.out.println("Total: " + numeroPersonasRandstad);

           long empleadosRandstad = empleados.stream()
                .filter(v -> {
                    if (v instanceof Externo empleado1) {
                        return Proveedor.RANDSTAD.equals(empleado1.getProveedor());
                    }
                    return false;
                })
                .count();

            Long empleadosExternos = empleados.stream()
                    .filter(persona -> persona instanceof Externo)
                    .map(personaExterna -> (Externo) personaExterna)
                    .filter(externo -> Proveedor.CAPITOL.equals(externo.getProveedor()))
                    .count();

            Optional<BigDecimal> costeMasAltoInterno = empleados.stream()
                    .filter(persona -> persona instanceof Interno)
                    .map(Persona::getCosteHora)
                    .max(BigDecimal::compareTo);

            if(costeMasAltoInterno.isPresent()){
                //System.out.println(costeMasAltoInterno.get());
            }

           final Optional<BigDecimal> reduce = empleados
                   .stream()
                   .filter(persona -> persona instanceof Externo)
                   .map(personaExterna -> (Externo) personaExterna)
                   .filter(externo -> Proveedor.CAPITOL.equals(externo.getProveedor()))
                   .filter(ux -> Area.UX.equals(ux.getArea()))
                   .map(Externo::getCosteHora)
                   .reduce(BigDecimal::add);

              if(reduce.isPresent()){
                //System.out.println(reduce.get());
            }

           //System.out.println("Total: " + empleadosExternos);
           try {
               LocalDate fechaMasAntigua = empleados.stream().map(Persona::getFechaIncorporacion)
                       //.reduce(LocalDate.now(),(a,b)->a.isBefore(b) ? a : b);
                       .reduce(null, Main::getMasAntgua);

               System.out.println(fechaMasAntigua);

               empleados.forEach(empleado->{
                   if (empleado.getFechaIncorporacion().isEqual(fechaMasAntigua)){
                       System.out.println(empleado.getNombre() + " forEach");
                   }
               });

               empleados.stream()
                       .filter(empleado -> empleado.getFechaIncorporacion().isEqual(fechaMasAntigua))
                       .map(Persona::getNombre)
                       .forEach(System.out::println);

           } catch (IllegalArgumentException e){
               System.out.println(e.getMessage());
           }


       }

       private static LocalDate getMasAntgua(LocalDate primera, LocalDate siguiente){

           if (Objects.isNull(primera) && Objects.isNull(siguiente)){
               throw new IllegalArgumentException("Fechas nulas.");
           }

           if (Objects.isNull(primera)){
               return siguiente;
           }

           if(Objects.isNull(siguiente)){
               return primera;
           }

           return primera.isBefore(siguiente) ? primera : siguiente;
       }

       private static List<CosteProyectos> calculaCosteImputacionesLista (List<Persona> personas, List<Clarity> imputaciones){
           List<CosteProyectos> listaResultado = new ArrayList<>();

            for (Persona persona : personas) {

                // Iteramos sobre cada claridad (registro de imputación de horas)
                for (Clarity imputacion : imputaciones) {

                    // Comprobamos si la persona coincide con el ID de la claridad (registro)
                    if (persona.getId().equals(imputacion.getIdPersona())) {

                        // Calculamos el coste para la persona en el proyecto correspondiente
                        BigDecimal costeImputacion = persona.getCosteHora().multiply(BigDecimal.valueOf(imputacion.getHorasImputadas()));

                        // Si el proyecto no está en el mapa, lo añadimos con el coste calculado
                        listaResultado.add(new CosteProyectos(imputacion.getNombreProyecto(), costeImputacion));

//                        costesPorProyecto.merge(imputacion.getNombreProyecto(), costeImputacion, BigDecimal::add);
                    }
                }
            }
            return listaResultado;
       }

       private static Map<String, BigDecimal> calculaCosteImputaciones(List<Persona> personas, List<Clarity> imputaciones) {

            // Mapa para almacenar los cálculos de coste por proyecto
            Map<String, BigDecimal> costesPorProyecto = new HashMap<>();

            // Iteramos sobre cada persona
            for (Persona persona : personas) {

                // Iteramos sobre cada claridad (registro de imputación de horas)
                for (Clarity imputacion : imputaciones) {

                    // Comprobamos si la persona coincide con el ID de la claridad (registro)
                    if (persona.getId().equals(imputacion.getIdPersona())) {

                        // Calculamos el coste para la persona en el proyecto correspondiente
                        BigDecimal costeImputacion = persona.getCosteHora().multiply(BigDecimal.valueOf(imputacion.getHorasImputadas()));

                        // Si el proyecto no está en el mapa, lo añadimos con el coste calculado
                        costesPorProyecto.merge(imputacion.getNombreProyecto(), costeImputacion, BigDecimal::add);
                    }
                }
            }

            // Devolvemos el mapa con los costes por proyecto
            return costesPorProyecto;
        }

//       private static Map<String, BigDecimal> calculaCosteProyectos(List<Persona> personaList, List<Clarity> clarityList){
//
//           Map<String, BigDecimal> calculos = new HashMap<>();
//           BigDecimal coste = new BigDecimal(0);
//           BigDecimal acumulado = new BigDecimal(0);
//
//           for (Persona persona: personaList){
//               for (Clarity imputar: clarityList){
//                    if (persona.getId().equals(imputar.getIdPersona())){
//                        coste = persona.getCosteHora().multiply(BigDecimal.valueOf(imputar.getHorasImputadas()));
//                        if (!calculos.containsKey(imputar.getNombreProyecto())){
//                            calculos.put(imputar.getNombreProyecto(),coste);
//                        }else {
//                            acumulado = calculos.get(imputar.getNombreProyecto());
//                            calculos.put(imputar.getNombreProyecto(), acumulado.add(coste));
//                        }
//
//                    }
//               }
//           }
//
//            return calculos;
//       }

       private static Map<Area, BigDecimal> costePorArea(List<Persona> personas, List<Clarity> imputaciones){

           Map<Area, BigDecimal> calculos = new HashMap<>();
                 // Iteramos sobre cada persona
            for (Persona persona : personas) {

                // Iteramos sobre cada clarity (registro de imputación de horas)
                for (Clarity imputacion : imputaciones) {

                    // Comprobamos si la persona coincide con el ID de la clarity (registro)
                    if (persona.getId().equals(imputacion.getIdPersona())) {

                        // Calculamos el coste para la persona en el proyecto correspondiente
                        BigDecimal costeImputacion = persona.getCosteHora().multiply(BigDecimal.valueOf(imputacion.getHorasImputadas()));

                        // Si el proyecto no está en el mapa, lo añadimos con el coste calculado
                        calculos.merge(persona.getArea(), costeImputacion, BigDecimal::add);
                    }
                }
            }

            // Devolvemos el mapa con los costes por proyecto
            return calculos;
       }

       public Map<String, Double> getHorasImputadasProyectos(List<Clarity> listaImputaciones){
               Map<String, Double> horasImputadasProyectos = new HashMap<>();
               for (Clarity imputacion: listaImputaciones){
                   if (!horasImputadasProyectos.containsKey(imputacion.getNombreProyecto())){
                       horasImputadasProyectos.put(imputacion.getNombreProyecto(), imputacion.getHorasImputadas());
                   }else {
                       horasImputadasProyectos.put(imputacion.getNombreProyecto(), horasImputadasProyectos.get(imputacion.getNombreProyecto()) + imputacion.getHorasImputadas());
                   }
               }
               return horasImputadasProyectos;
       }
}
