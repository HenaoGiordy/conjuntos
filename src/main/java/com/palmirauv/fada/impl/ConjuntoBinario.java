/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palmirauv.fada.impl;

/**
 *
 * @author jberm
 */
public class ConjuntoBinario {

    private byte[] elementos;

    public ConjuntoBinario(int tamano) {
        this.elementos = new byte[(int) Math.floor((double) tamano / 8) + 1];
    }

    public byte[] getElementos() {
        return elementos;
    }

    public void setLength(int x) {
        this.elementos = new byte[(int) Math.floor((double) x / 8) + 1];
    }

    public int getSize() {
        int size = 0;
        for (int i = 0; i < elementos.length; i++) {
            if ((elementos[i] & 1) == 1) {
                size++;
            }
        }
        return size;
    }

    public void add(int x) {
        int indiceByte = (int) Math.floor((double) x / 8);
        int bit = x % 8;
        elementos[indiceByte] |= (1 << bit);
    }

    public void remove(int x) {
        int indiceByte = (int) Math.floor((double) x / 8);
        int bit = x % 8;
        elementos[indiceByte] &= ~(1 << bit);

    }

    public int getValue(int x) {
        int indiceByte = (int) Math.floor((double) x / 8);
        int bit = x % 8;
        return (elementos[indiceByte] >> bit) & 1;
    }

    @Override
    public String toString() {
        StringBuilder valor = new StringBuilder();
        if (getSize() == 0) {
            return "{ }";
        }
        for (int i = 0; i < elementos.length * 8; i++) {
            if (getValue(i + 1) == 1) {
                valor.append(i).append(" ,");
            }
        }
        return "{ " + valor.substring(0, valor.length() - 1) + " }";
    }

    // Método para la unión de dos conjuntos
    public ConjuntoBinario union(ConjuntoBinario conjuntoB) {
        int lengthConjuntoA = this.elementos.length;
        int lengthConjuntoB = conjuntoB.getElementos().length;
        int lengthResultado = Math.max(lengthConjuntoA, lengthConjuntoB);

        ConjuntoBinario resultado = new ConjuntoBinario(lengthResultado);

        for (int i = 0; i < lengthResultado; i++) {
            byte byteA;
            if (i < lengthConjuntoA) {
                byteA = this.elementos[i];
            } else {
                byteA = 0;
            }

            byte byteB;
            if (i < lengthConjuntoB) {
                byteB = conjuntoB.getElementos()[i];
            } else {
                byteB = 0;
            }

            resultado.getElementos()[i] = (byte) (byteA | byteB);
        }

        return resultado;
    }

    // Método para la intersección de dos conjuntos
    public ConjuntoBinario interseccion(ConjuntoBinario conjuntoB) {
        int lengthConjuntoA = this.elementos.length;
        int lengthConjuntoB = conjuntoB.getElementos().length;
        int lengthResultado = Math.min(lengthConjuntoA, lengthConjuntoB);

        ConjuntoBinario resultado = new ConjuntoBinario(lengthResultado);

        for (int i = 0; i < lengthResultado; i++) {
            byte byteA;
            if (i < lengthConjuntoA) {
                byteA = this.elementos[i];
            } else {
                byteA = 0;
            }

            byte byteB;
            if (i < lengthConjuntoB) {
                byteB = conjuntoB.getElementos()[i];
            } else {
                byteB = 0;
            }

            resultado.getElementos()[i] = (byte) (byteA & byteB);
        }

        return resultado;
    }

    // Método para la diferencia de dos conjuntos
    public ConjuntoBinario diferencia(ConjuntoBinario conjuntoB) {
        int lengthConjuntoA = this.elementos.length;
        int lengthConjuntoB = conjuntoB.getElementos().length;
        int lengthResultado = Math.max(lengthConjuntoA, lengthConjuntoB);

        ConjuntoBinario resultado = new ConjuntoBinario(lengthResultado);

        for (int i = 0; i < lengthResultado; i++) {
            byte byteA;
            if (i < lengthConjuntoA) {
                byteA = this.elementos[i];
            } else {
                byteA = 0;
            }

            byte byteB;
            if (i < lengthConjuntoB) {
                byteB = conjuntoB.getElementos()[i];
            } else {
                byteB = 0;
            }

            resultado.getElementos()[i] = (byte) (byteA & ~byteB);
        }

        return resultado;
    }

    // Método para el complemento de un conjunto en relación con el conjunto universal
    public ConjuntoBinario complemento(ConjuntoBinario conjuntoUniversal) {
        int lengthConjunto = this.elementos.length;
        int lengthUniversal = conjuntoUniversal.getElementos().length;
        int lengthResultado = Math.max(lengthConjunto, lengthUniversal);

        ConjuntoBinario resultado = new ConjuntoBinario(lengthResultado);

        for (int i = 0; i < lengthResultado; i++) {
            byte byteConjunto;
            byte byteUniversal;
            
            if (i < lengthConjunto) {
                byteConjunto = this.elementos[i];
            } else {
                byteConjunto = 0;
            }
            
            byteUniversal = conjuntoUniversal.getElementos()[i];
 
            resultado.getElementos()[i] = (byte) (~byteConjunto & byteUniversal);
        }

        return resultado;
    }

}
