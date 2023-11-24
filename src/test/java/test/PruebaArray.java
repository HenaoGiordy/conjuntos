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
    public void unionIgualTamaño(){
        
        ConjuntoArray conjuntoA = new ConjuntoArray();
        ConjuntoArray conjuntoB = new ConjuntoArray();
        
        ConjuntoArray conjuntoC = new ConjuntoArray();
        
        ConjuntoArray conjuntoD = new ConjuntoArray();
        
        //DEFINIR TAMAÑO
        
        conjuntoA.setLength(5);
        conjuntoB.setLength(5);
        
        conjuntoD.setLength(5);
        
        try{
            conjuntoA.add(1);
            conjuntoA.add(2);
            conjuntoA.add(3);
            
            conjuntoB.add(4);
            conjuntoB.add(5);
            conjuntoB.add(1);
            
            //CONJUNTO DE PRUEBA
            conjuntoD.add(1);
            conjuntoD.add(2);
            conjuntoD.add(3);
            conjuntoD.add(4);
            conjuntoD.add(5);
        
        }catch(Exception exc){
        }
        
        conjuntoC = conjuntoA.union(conjuntoB);
        
        assertEquals(conjuntoC.toString(), conjuntoD.toString());
        
    }
    
    @Test
    public void unionDifTamaño(){
        
        ConjuntoArray conjuntoA = new ConjuntoArray();
        ConjuntoArray conjuntoB = new ConjuntoArray();
        
        ConjuntoArray conjuntoC = new ConjuntoArray();
        
        ConjuntoArray conjuntoD = new ConjuntoArray();
        
        //DEFINIR TAMAÑO
        
        conjuntoA.setLength(6);
        conjuntoB.setLength(5);
        
        conjuntoD.setLength(6);
        
        try{
            conjuntoA.add(1);
            conjuntoA.add(2);
            conjuntoA.add(3);
            
            conjuntoB.add(4);
            conjuntoA.add(6);
            conjuntoB.add(1);
            
            //CONJUNTO DE PRUEBA
            conjuntoD.add(1);
            conjuntoD.add(2);
            conjuntoD.add(3);
            conjuntoD.add(4);
            conjuntoD.add(6);
            
        
        }catch(Exception exc){
        }
        
        conjuntoC = conjuntoA.union(conjuntoB);
        
        assertEquals(conjuntoC.toString(), conjuntoD.toString());
        
    }
    
    @Test
   public void diferencia(){
       ConjuntoArray conjuntoA = new ConjuntoArray(6);
       ConjuntoArray conjuntoB = new ConjuntoArray(5);
       
       ConjuntoArray conjuntoC = new ConjuntoArray(6);
       ConjuntoArray conjuntoD = new ConjuntoArray();
       
       try{
            conjuntoA.add(1);
            conjuntoA.add(2);
            conjuntoA.add(3);
            
            conjuntoB.add(2);
            
            conjuntoB.add(1);
            
            //CONJUNTO DE PRUEBA
            conjuntoC.add(3);
            
        
        }catch(Exception exc){
        }
       
       conjuntoD =  conjuntoA.diferencia(conjuntoB);
       
        assertEquals(conjuntoD.toString(), conjuntoC.toString());
       
   }
}
