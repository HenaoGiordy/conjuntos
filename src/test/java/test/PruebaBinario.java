/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.palmirauv.fada.impl.ConjuntoBinario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jaider Bermudez
 */
public class PruebaBinario {

    @Test
    public void pruebaAnadir() {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(8);

        assertEquals(8, ((conjuntoA.getLengt() - 1) * 8) + conjuntoA.getMaxbit());

    }

    @Test
    public void pruebaUnion() {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(5);
        ConjuntoBinario conjuntoB = new ConjuntoBinario(6);

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

        ConjuntoBinario conjuntoC = conjuntoA.union(conjuntoB);

        assertTrue(conjuntoC.getValue(1) == 1);
        assertTrue(conjuntoC.getValue(2) == 1);
        assertTrue(conjuntoC.getValue(3) == 1);
        assertTrue(conjuntoC.getValue(4) == 1);
        assertTrue(conjuntoC.getValue(5) == 1);

    }

    @Test
    public void pruebaInterseccion() {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(8);
        ConjuntoBinario conjuntoB = new ConjuntoBinario(8);

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

        ConjuntoBinario conjuntoC = conjuntoA.interseccion(conjuntoB);

        assertTrue(conjuntoC.getValue(1) == 0);
        assertTrue(conjuntoC.getValue(2) == 0);
        assertTrue(conjuntoC.getValue(3) == 1);
        assertTrue(conjuntoC.getValue(4) == 0);
        assertTrue(conjuntoC.getValue(5) == 0);
        assertTrue(conjuntoC.getValue(6) == 0);
    }

    @Test
    public void pruebaDiferencia() {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(8);
        ConjuntoBinario conjuntoB = new ConjuntoBinario(8);

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

        ConjuntoBinario conjuntoC = conjuntoA.diferencia(conjuntoB);

        assertTrue(conjuntoC.getValue(1) == 1);
        assertTrue(conjuntoC.getValue(2) == 0);
        assertTrue(conjuntoC.getValue(3) == 0);
        assertTrue(conjuntoC.getValue(4) == 0);
        assertTrue(conjuntoC.getValue(5) == 1);
        assertTrue(conjuntoC.getValue(6) == 0);
    }

    @Test
    public void pruebaComplemento() {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(8);
        ConjuntoBinario conjuntoUniversal = new ConjuntoBinario(8);

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

        ConjuntoBinario conjuntoC = conjuntoA.complemento(conjuntoUniversal);

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
