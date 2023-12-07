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
    public void pruebaAnadir() throws Exception {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(100000);

        for (int i = 1; i <= 100000; i++) {
            conjuntoA.add(i);
        }

        assertEquals("{ " + getConjuntoString(1, 100000) + " }", conjuntoA.toString());
    }
    
    @Test
    public void pruebaUnionIgual() throws Exception {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(100000);
        ConjuntoBinario conjuntoB = new ConjuntoBinario(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoBinario conjuntoC = conjuntoA.union(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 99999, 2) + " }", conjuntoC.toString());
    }

    @Test
    public void pruebaInterseccionIgual() throws Exception {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(100000);
        ConjuntoBinario conjuntoB = new ConjuntoBinario(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoBinario conjuntoC = conjuntoA.interseccion(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 99999, 2) + " }", conjuntoC.toString());
    }

    @Test
    public void pruebaDiferenciaIgual() throws Exception {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(100000);
        ConjuntoBinario conjuntoB = new ConjuntoBinario(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoBinario conjuntoC = conjuntoA.diferencia(conjuntoB);

        assertEquals("{ }", conjuntoC.toString());
    }

    @Test
    public void pruebaUnionDiferente() throws Exception {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(100000);
        ConjuntoBinario conjuntoB = new ConjuntoBinario(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 2; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoBinario conjuntoC = conjuntoA.union(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 100000, 1) + " }", conjuntoC.toString());
    }

    @Test
    public void pruebaInterseccionDiferente() throws Exception {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(100000);
        ConjuntoBinario conjuntoB = new ConjuntoBinario(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 2; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoBinario conjuntoC = conjuntoA.interseccion(conjuntoB);

        assertEquals("{ }", conjuntoC.toString());
    }

    @Test
    public void pruebaDiferenciaDiferente() throws Exception {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(100000);
        ConjuntoBinario conjuntoB = new ConjuntoBinario(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 2; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoBinario conjuntoC = conjuntoA.diferencia(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 99999, 2) + " }", conjuntoC.toString());
    }

    @Test
    public void pruebaComplemento() throws Exception {
        ConjuntoBinario conjuntoA = new ConjuntoBinario(100000);
        ConjuntoBinario conjuntoUniversal = new ConjuntoBinario(100000);

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i++) {
            conjuntoUniversal.add(i);
        }

        ConjuntoBinario conjuntoC = conjuntoA.complemento(conjuntoUniversal);

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
