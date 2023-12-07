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

        for (int i = 1; i <= 1000000; i++) {
            conjuntoA.add(i);
        }

        assertEquals("{ " + getConjuntoString(1, 100000) + " }", conjuntoA.toString());
    }

    @Test
    public void pruebaUnionDiferente() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 2; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoListaE conjuntoC = conjuntoA.union(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 100000, 2) + getConjuntoString(2, 100000, 2) + " }", conjuntoC.toString());
    }
    
        @Test
    public void pruebaUnionIgual() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoListaE conjuntoC = conjuntoA.union(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 99999, 2) + " }", conjuntoC.toString());
    }

    @Test
    public void pruebaInterseccionDiferente() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 2; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoListaE conjuntoC = conjuntoA.interseccion(conjuntoB);

        assertEquals("{ }", conjuntoC.toString());
    }
    
        @Test
    public void pruebaInterseccionIgual() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoListaE conjuntoC = conjuntoA.interseccion(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 99999, 2) + " }", conjuntoC.toString());
    }

    @Test
    public void pruebaDiferenciaDiferente() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 2; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoListaE conjuntoC = conjuntoA.diferencia(conjuntoB);

        assertEquals("{ " + getConjuntoString(1, 99999, 2) + " }", conjuntoC.toString());
    }
    
        @Test
    public void pruebaDiferenciaIgual() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoB.add(i);
        }

        ConjuntoListaE conjuntoC = conjuntoA.diferencia(conjuntoB);

        assertEquals("{ }", conjuntoC.toString());
    }

    @Test
    public void pruebaComplemento() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoUniversal = new ConjuntoListaE();

        for (int i = 1; i <= 100000; i += 2) {
            conjuntoA.add(i);
        }

        for (int i = 1; i <= 100000; i++) {
            conjuntoUniversal.add(i);
        }

        ConjuntoListaE conjuntoC = conjuntoA.complemento(conjuntoUniversal);

        assertEquals("{ " + getConjuntoString(2, 100000, 2) + " }", conjuntoC.toString());
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
