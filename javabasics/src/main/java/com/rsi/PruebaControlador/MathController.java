package com.rsi.PruebaControlador;

import com.rsi.Main;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MathController {

    @PostMapping("/solveQuadratic")
    public double solveQuadratic(@RequestBody Coefficients coefficients) {
        return Main.raizCuadradaSegundoGrado(coefficients.getA(), coefficients.getB(), coefficients.getC());
    }

    public static class Coefficients {
        private double a;
        private double b;
        private double c;

        public double getA() {
            return a;
        }

        public void setA(double a) {
            this.a = a;
        }

        public double getB() {
            return b;
        }

        public void setB(double b) {
            this.b = b;
        }

        public double getC() {
            return c;
        }

        public void setC(double c) {
            this.c = c;
        }
    }
}