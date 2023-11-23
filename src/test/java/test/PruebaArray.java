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
    
    public PruebaArray() {
    }

    @Test
    public void prueba(){
        ConjuntoArray conjunto = new ConjuntoArray(5);
        
        
        
        conjunto.add(1);
        conjunto.add(2);
        assertEquals(1, conjunto.getElementos()[1]);
    }
}
