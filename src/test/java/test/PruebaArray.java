/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import com.palmirauv.fada.impl.ConjuntoArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pavel
 */
public class PruebaArray {

    @Test
    public void pruebaAnadir() throws Exception {
        ConjuntoArray conjuntoA = new ConjuntoArray(100000);

        for (int i = 1; i <= 1000000; i++) {
            conjuntoA.add(i);
        }

        assertEquals("{ " + getConjuntoString(1, 100000) + " }", conjuntoA.toString());
    }
    
        @Test
    public void pruebaUnionIgual() throws Exception {
        ConjuntoArray conjuntoA = new ConjuntoArray(100000);
        ConjuntoArray conjuntoB = new ConjuntoArray(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoArray conjuntoC = conjuntoA.union(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 99999, 2) + " }", conjuntoC.toString());
    }

    @Test
    public void pruebaInterseccionIgual() throws Exception {
        ConjuntoArray conjuntoA = new ConjuntoArray(100000);
        ConjuntoArray conjuntoB = new ConjuntoArray(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoArray conjuntoC = conjuntoA.interseccion(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 99999, 2) + " }", conjuntoC.toString());
    }

    @Test
    public void pruebaDiferenciaIgual() throws Exception {
        ConjuntoArray conjuntoA = new ConjuntoArray(100000);
        ConjuntoArray conjuntoB = new ConjuntoArray(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoArray conjuntoC = conjuntoA.diferencia(conjuntoB);

        assertEquals("{ }", conjuntoC.toString());
    }

    @Test
    public void pruebaUnionDiferente() throws Exception {
        ConjuntoArray conjuntoA = new ConjuntoArray(100000);
        ConjuntoArray conjuntoB = new ConjuntoArray(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 2; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoArray conjuntoC = conjuntoA.union(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 100000, 1) + " }", conjuntoC.toString());
    }

    @Test
    public void pruebaInterseccionDiferente() throws Exception {
        ConjuntoArray conjuntoA = new ConjuntoArray(100000);
        ConjuntoArray conjuntoB = new ConjuntoArray(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 2; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoArray conjuntoC = conjuntoA.interseccion(conjuntoB);

        assertEquals("{ }", conjuntoC.toString());
    }

    @Test
    public void pruebaDiferenciaDiferente() throws Exception {
        ConjuntoArray conjuntoA = new ConjuntoArray(100000);
        ConjuntoArray conjuntoB = new ConjuntoArray(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 2; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoArray conjuntoC = conjuntoA.diferencia(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 99999, 2) + " }", conjuntoC.toString());
    }

    @Test
    public void pruebaComplemento() throws Exception {
        ConjuntoArray conjuntoA = new ConjuntoArray(100000);
        ConjuntoArray conjuntoUniversal = new ConjuntoArray(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i++) {
            conjuntoUniversal.add(i);
        }

        ConjuntoArray conjuntoC = conjuntoA.complemento(conjuntoUniversal);

        assertEquals("{ " + getConjuntoString(2, 100000, 2) + " }", conjuntoC.toString());
    }

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
