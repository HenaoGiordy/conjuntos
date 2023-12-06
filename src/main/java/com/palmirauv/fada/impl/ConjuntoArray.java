/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palmirauv.fada.impl;

/**
 *
 * @author giord
 */
public class ConjuntoArray {

    private int[] elementos;

    //Conjunto definiendo solo su tamaño sin elementos
    public ConjuntoArray(int tamano) {
        this.elementos = new int[tamano + 1];
    }

    public ConjuntoArray() {
    }

    public int[] getElementos() {

        return elementos;
    }

    public void setLength(int x) {
        this.elementos = new int[x + 1];
    }

    public int getSize() {

        if (this.elementos == null) {
            return 0;
        }
        int tamano = this.elementos.length;

        int size = 0;
        for (int i = 0; i < tamano; i++) {
            if (this.elementos[i] == 1) {
                size++;
            }
        }
        return size;
    }

    public void setElementos(int[] elementos) {
        this.elementos = elementos;
    }

    public void add(int x) throws Exception {
        if (x > this.elementos.length - 1) {
            throw new Exception("Número muy grande");
        }
        this.elementos[x] = 1;
    }

    public void remove(int x) {
        this.elementos[x] = 0;
    }

    public int getValue(int x) {
        return this.elementos[x];
    }

    @Override
    public String toString() {

        String valor = "";
        if (this.getSize() == 0) {
            return "{ }";
        }
        for (int i = 0; i < this.elementos.length; i++) {

            if (this.elementos[i] == 1) {
                valor += i + ", ";
            }

        }

        return "{ " + valor.substring(0, valor.length() - 2) + " }";
    }

//    método para unión de conjuntos
    public ConjuntoArray union(ConjuntoArray conjuntoB) {
        int lengthConjuntoA = this.elementos.length;
        int lengthConjuntoB = conjuntoB.getElementos().length;
        int maxLength = Math.max(lengthConjuntoA, lengthConjuntoB);

        ConjuntoArray resultado = new ConjuntoArray(maxLength);

        for (int i = 0; i < maxLength; i++) {
            int elementoConjuntoA;
            int elementoConjuntoB;

            if (i < lengthConjuntoA) {
                elementoConjuntoA = this.elementos[i];
            } else {
                elementoConjuntoA = 0;
            }

            if (i < lengthConjuntoB) {
                elementoConjuntoB = conjuntoB.getElementos()[i];
            } else {
                elementoConjuntoB = 0;
            }

            if (elementoConjuntoA == 1 || elementoConjuntoB == 1) {
                resultado.getElementos()[i] = 1;
            } else {
                resultado.getElementos()[i] = 0;
            }
        }

        return resultado;
    }

    public ConjuntoArray interseccion(ConjuntoArray conjuntoB) {
        int lengthConjuntoA = this.elementos.length;
        int lengthConjuntoB = conjuntoB.getElementos().length;
        int maxLength = Math.min(lengthConjuntoA, lengthConjuntoB);

        ConjuntoArray resultado = new ConjuntoArray(maxLength);

        for (int i = 0; i < maxLength; i++) {
            if (this.elementos[i] == 1 && conjuntoB.getElementos()[i] == 1) {
                resultado.getElementos()[i] = 1;
            } else {
                resultado.getElementos()[i] = 0;
            }
        }

        return resultado;
    }

    public ConjuntoArray diferencia(ConjuntoArray conjuntoB) {
        int lengthConjuntoA = this.elementos.length;
        int lengthConjuntoB = conjuntoB.getElementos().length;
        int maxLength = Math.max(lengthConjuntoA, lengthConjuntoB);

        ConjuntoArray resultado = new ConjuntoArray(maxLength);

        for (int i = 0; i < maxLength; i++) {
            int elementoConjuntoA;
            int elementoConjuntoB;
            
            if (i < lengthConjuntoA) {
                elementoConjuntoA = this.elementos[i];
            } else {
                elementoConjuntoA = 0;
            }

            if (i < lengthConjuntoB) {
                elementoConjuntoB = conjuntoB.getElementos()[i];
            } else {
                elementoConjuntoB = 0;
            }

            if (elementoConjuntoA == 1 && elementoConjuntoB == 0) {
                resultado.getElementos()[i] = 1;
            }
        }

        return resultado;
    }

    public ConjuntoArray complemento(ConjuntoArray universal) {
        int maxLength = Math.max(this.elementos.length, universal.getElementos().length);
        ConjuntoArray resultado = new ConjuntoArray(maxLength);

        for (int i = 0; i < maxLength; i++) {
            if (i < this.elementos.length && this.elementos[i] == 0 && universal.getElementos()[i] == 1) {
                resultado.getElementos()[i] = 1;
            } else if (i >= this.elementos.length) {
                resultado.getElementos()[i] = 1;
            }
        }

        return resultado;
    }

}
