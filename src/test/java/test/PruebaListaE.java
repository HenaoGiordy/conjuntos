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
    public void pruebaUnion() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        conjuntoA.add(1);
        conjuntoA.add(3);
        conjuntoA.add(5);

        conjuntoB.add(2);
        conjuntoB.add(4);
        conjuntoB.add(6);

        ConjuntoListaE conjuntoC = conjuntoA.union(conjuntoB);

        assertTrue(conjuntoC.toString().equals("{1, 3, 5, 2, 4, 6}"));
    }

    @Test
    public void pruebaInterseccion() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        conjuntoA.add(1);
        conjuntoA.add(3);
        conjuntoA.add(5);

        conjuntoB.add(2);
        conjuntoB.add(3);
        conjuntoB.add(6);

        ConjuntoListaE conjuntoC = conjuntoA.interseccion(conjuntoB);

        assertTrue(conjuntoC.toString().equals("{3}"));
    }

    @Test
    public void pruebaDiferencia() {
        ConjuntoListaE conjuntoA = new ConjuntoListaE();
        ConjuntoListaE conjuntoB = new ConjuntoListaE();

        conjuntoA.add(1);
        conjuntoA.add(3);
        conjuntoA.add(5);

        conjuntoB.add(2);
        conjuntoB.add(3);
        conjuntoB.add(6);

        ConjuntoListaE conjuntoC = conjuntoA.diferencia(conjuntoB);

        assertTrue(conjuntoC.toString().equals("{1, 5}"));
    }
}