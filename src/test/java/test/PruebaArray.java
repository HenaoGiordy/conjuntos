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
    public void pruebaAnadir() {
        ConjuntoArray conjuntoA = new ConjuntoArray(8);

        //Contando de 0 a 8 da 9
        assertEquals(9, conjuntoA.getElementos().length);
    }

    @Test
    public void pruebaUnion() {
        ConjuntoArray conjuntoA = new ConjuntoArray(5);
        ConjuntoArray conjuntoB = new ConjuntoArray(6);

        try {
            conjuntoA.add(1);
            conjuntoA.add(3);
            conjuntoA.add(5);

            conjuntoB.add(2);
            conjuntoB.add(4);
            conjuntoB.add(5);

        } catch (Exception exc) {
            fail("Error durante la prueba: " + exc.getMessage());
        }

        ConjuntoArray conjuntoC = conjuntoA.union(conjuntoB);

        assertTrue(conjuntoC.getValue(1) == 1);
        assertTrue(conjuntoC.getValue(2) == 1);
        assertTrue(conjuntoC.getValue(3) == 1);
        assertTrue(conjuntoC.getValue(4) == 1);
        assertTrue(conjuntoC.getValue(5) == 1);
    }

    @Test
    public void pruebaInterseccion() {
        ConjuntoArray conjuntoA = new ConjuntoArray(8);
        ConjuntoArray conjuntoB = new ConjuntoArray(8);

        try {
            conjuntoA.add(1);
            conjuntoA.add(3);
            conjuntoA.add(5);

            conjuntoB.add(2);
            conjuntoB.add(3);
            conjuntoB.add(6);

        } catch (Exception exc) {
            fail("Error durante la prueba: " + exc.getMessage());
        }

        ConjuntoArray conjuntoC = conjuntoA.interseccion(conjuntoB);

        assertTrue(conjuntoC.getValue(1) == 0);
        assertTrue(conjuntoC.getValue(2) == 0);
        assertTrue(conjuntoC.getValue(3) == 1);
        assertTrue(conjuntoC.getValue(4) == 0);
        assertTrue(conjuntoC.getValue(5) == 0);
        assertTrue(conjuntoC.getValue(6) == 0);
    }

    @Test
    public void pruebaDiferencia() {
        ConjuntoArray conjuntoA = new ConjuntoArray(8);
        ConjuntoArray conjuntoB = new ConjuntoArray(8);

        try {
            conjuntoA.add(1);
            conjuntoA.add(3);
            conjuntoA.add(5);

            conjuntoB.add(2);
            conjuntoB.add(3);
            conjuntoB.add(6);

        } catch (Exception exc) {
            fail("Error durante la prueba: " + exc.getMessage());
        }

        ConjuntoArray conjuntoC = conjuntoA.diferencia(conjuntoB);

        assertTrue(conjuntoC.getValue(1) == 1);
        assertTrue(conjuntoC.getValue(2) == 0);
        assertTrue(conjuntoC.getValue(3) == 0);
        assertTrue(conjuntoC.getValue(4) == 0);
        assertTrue(conjuntoC.getValue(5) == 1);
        assertTrue(conjuntoC.getValue(6) == 0);
    }

    @Test
    public void pruebaComplemento() {
        ConjuntoArray conjuntoA = new ConjuntoArray(8);
        ConjuntoArray conjuntoUniversal = new ConjuntoArray(8);

        try {
            conjuntoA.add(1);
            conjuntoA.add(3);
            conjuntoA.add(5);

            conjuntoUniversal.add(0);
            conjuntoUniversal.add(1);
            conjuntoUniversal.add(2);
            conjuntoUniversal.add(3);
            conjuntoUniversal.add(4);
            conjuntoUniversal.add(5);
            conjuntoUniversal.add(6);
            conjuntoUniversal.add(7);
            conjuntoUniversal.add(8);

        } catch (Exception exc) {
            fail("Error durante la prueba: " + exc.getMessage());
        }

        ConjuntoArray conjuntoC = conjuntoA.complemento(conjuntoUniversal);

        assertTrue(conjuntoC.getValue(0) == 1);
        assertTrue(conjuntoC.getValue(1) == 0);
        assertTrue(conjuntoC.getValue(2) == 1);
        assertTrue(conjuntoC.getValue(3) == 0);
        assertTrue(conjuntoC.getValue(4) == 1);
        assertTrue(conjuntoC.getValue(5) == 0);
        assertTrue(conjuntoC.getValue(6) == 1);
        assertTrue(conjuntoC.getValue(7) == 1);
        assertTrue(conjuntoC.getValue(8) == 1);
    }
}
