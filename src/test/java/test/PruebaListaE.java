/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.palmirauv.fada.impl.ConjuntoListaE;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Laura Zamora
 */
public class PruebaListaE {

    @Test
    public void pruebaAnadir() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();

        for (int j = 10000; j <= 100000; j += 10000) {
            long inicio = System.currentTimeMillis();

            for (int i = 1; i <= j; i++) {
                conjuntoA.add(i);
            }

            long fin = System.currentTimeMillis();
            long tiempoEjecucion = fin - inicio;
            System.out.println("Tiempo de ejecucion para j=" + j + ": " + tiempoEjecucion + " milisegundos");

            assertEquals("{ " + getConjuntoString(1, j) + " }", conjuntoA.toString());
        }
    }

    @Test
    public void pruebaUnionDiferente() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int j = 10000; j <= 100000; j += 10000) {
            long inicio = System.currentTimeMillis();

            for (int i = 1; i <= j; i += 2) {
                conjuntoA.add(i);
            }

            for (int i = 2; i <= j; i += 2) {
                conjuntoB.add(i);
            }

            ConjuntoListaE conjuntoC = conjuntoA.union(conjuntoB);

            long fin = System.currentTimeMillis();
            long tiempoEjecucion = fin - inicio;
            System.out.println("Tiempo de ejecucion para j=" + j + ": " + tiempoEjecucion + " milisegundos");

            assertEquals("{ " + getConjuntoString(1, j, 2) + getConjuntoString(2, j, 2) + " }", conjuntoC.toString());
        }
    }

    @Test
    public void pruebaUnionIgual() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int j = 10000; j <= 100000; j += 10000) {
            long inicio = System.currentTimeMillis();

            for (int i = 1; i <= j; i += 2) {
                conjuntoA.add(i);
            }

            for (int i = 1; i <= j; i += 2) {
                conjuntoB.add(i);
            }

            ConjuntoListaE conjuntoC = conjuntoA.union(conjuntoB);

            long fin = System.currentTimeMillis();
            long tiempoEjecucion = fin - inicio;
            System.out.println("Tiempo de ejecucion para j=" + j + ": " + tiempoEjecucion + " milisegundos");

            assertEquals("{ " + getConjuntoString(1, j - 1, 2) + " }", conjuntoC.toString());
        }
    }

    @Test
    public void pruebaInterseccionDiferente() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int j = 10000; j <= 100000; j += 10000) {
            long inicio = System.currentTimeMillis();

            for (int i = 1; i <= j; i += 2) {
                conjuntoA.add(i);
            }

            for (int i = 2; i <= j; i += 2) {
                conjuntoB.add(i);
            }

            ConjuntoListaE conjuntoC = conjuntoA.interseccion(conjuntoB);

            long fin = System.currentTimeMillis();
            long tiempoEjecucion = fin - inicio;
            System.out.println("Tiempo de ejecucion para j=" + j + ": " + tiempoEjecucion + " milisegundos");

            assertEquals("{ }", conjuntoC.toString());
        }
    }

    @Test
    public void pruebaInterseccionIgual() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int j = 10000; j <= 100000; j += 10000) {
            long inicio = System.currentTimeMillis();

            for (int i = 1; i <= j; i += 2) {
                conjuntoA.add(i);
            }

            for (int i = 1; i <= j; i += 2) {
                conjuntoB.add(i);
            }

            ConjuntoListaE conjuntoC = conjuntoA.interseccion(conjuntoB);

            long fin = System.currentTimeMillis();
            long tiempoEjecucion = fin - inicio;
            System.out.println("Tiempo de ejecucion para j=" + j + ": " + tiempoEjecucion + " milisegundos");

            assertEquals("{ " + getConjuntoString(1, j - 1, 2) + " }", conjuntoC.toString());
        }
    }

    @Test
    public void pruebaDiferenciaDiferente() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int j = 10000; j <= 100000; j += 10000) {
            long inicio = System.currentTimeMillis();

            for (int i = 1; i <= j; i += 2) {
                conjuntoA.add(i);
            }

            for (int i = 2; i <= j; i += 2) {
                conjuntoB.add(i);
            }

            ConjuntoListaE conjuntoC = conjuntoA.diferencia(conjuntoB);

            long fin = System.currentTimeMillis();
            long tiempoEjecucion = fin - inicio;
            System.out.println("Tiempo de ejecucion para j=" + j + ": " + tiempoEjecucion + " milisegundos");

            assertEquals("{ " + getConjuntoString(1, j-1, 2) + " }", conjuntoC.toString());
        }
    }

    @Test
    public void pruebaDiferenciaIgual() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int j = 10000; j <= 100000; j += 10000) {
            long inicio = System.currentTimeMillis();

            for (int i = 1; i <= j; i += 2) {
                conjuntoA.add(i);
            }

            for (int i = 1; i <= j; i += 2) {
                conjuntoB.add(i);
            }

            ConjuntoListaE conjuntoC = conjuntoA.diferencia(conjuntoB);

            long fin = System.currentTimeMillis();
            long tiempoEjecucion = fin - inicio;
            System.out.println("Tiempo de ejecucion para j=" + j + ": " + tiempoEjecucion + " milisegundos");

            assertEquals("{ }", conjuntoC.toString());
        }
    }

    @Test
    public void pruebaComplemento() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoUniversal = new ConjuntoListaE();

        for (int j = 10000; j <= 100000; j += 10000) {
            long inicio = System.currentTimeMillis();

            for (int i = 1; i <= j; i += 2) {
                conjuntoA.add(i);
            }

            for (int i = 1; i <= j; i++) {
                conjuntoUniversal.add(i);
            }

            ConjuntoListaE conjuntoC = conjuntoA.complemento(conjuntoUniversal);

            long fin = System.currentTimeMillis();
            long tiempoEjecucion = fin - inicio;
            System.out.println("Tiempo de ejecucion para j=" + j + ": " + tiempoEjecucion + " milisegundos");

            assertEquals("{ " + getConjuntoString(2, j, 2) + " }", conjuntoC.toString());
        }
    }

// Método para obtener la representación de un conjunto como una cadena
    private String getConjuntoString(int inicio, int fin) {
        StringBuilder conjuntoString = new StringBuilder();
        for (int i = inicio; i <= fin; i++) {
            conjuntoString.append(i);
            if (i < fin) {
                conjuntoString.append(", ");
            }
        }
        return conjuntoString.toString();
    }

    // Método para obtener la representación de un conjunto como una cadena con un paso
    private String getConjuntoString(int inicio, int fin, int paso) {
        StringBuilder conjuntoString = new StringBuilder();
        for (int i = inicio; i <= fin; i += paso) {
            conjuntoString.append(i);
            if (i < fin) {
                conjuntoString.append(", ");
            }
        }
        return conjuntoString.toString();
    }
}