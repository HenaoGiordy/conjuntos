/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palmirauv.fada.impl;

/**
 *
 * @author Jaider Bermudez
 */
public class ConjuntoBinario {

    private byte[] elementos;
    private int maxbit;

    public ConjuntoBinario(int tamano) {
        this.elementos = new byte[(int) Math.floor((double) tamano / 8) + 1];
        this.maxbit = tamano % 8;
    }

    public ConjuntoBinario() {

    }

    public byte[] getElementos() {
        return elementos;
    }

    public int getMaxbit() {
        return maxbit;
    }

    public void setElementos(byte[] elementos) {
        this.elementos = elementos;
    }

    public void setMaxbit(int maxbit) {
        this.maxbit = maxbit;
    }

    public int getLengt() {
        return this.elementos.length;
    }

    public void setLength(int x) {
        this.elementos = new byte[(int) Math.floor((double) x / 8) + 1];
        this.maxbit = x % 8;
    }

    public int getSize() {
        int size = 0;
        for (byte elemento : elementos) {
            size += Integer.bitCount(elemento & 0xFF);
        }
        return size;
    }

    public void add(int x) throws Exception {

        int indiceByte = (int) Math.floor((double) x / 8);
        int bit = x % 8;
        if (bit > maxbit && indiceByte == elementos.length - 1) {
            throw new Exception("Numero muy grande");
        } else {
            elementos[indiceByte] |= (1 << bit);
        }
    }

    public void remove(int x) throws Exception {
        int indiceByte = (int) Math.floor((double) x / 8);
        int bit = x % 8;
        if (x >= 0 && bit <= this.maxbit) {
            elementos[indiceByte] &= ~(1 << bit);
        } else {
            throw new Exception("Numero muy grande remove");
        }
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
            if (getValue(i) == 1) {
                valor.append(i).append(", ");
            }
        }

        return "{ " + valor.substring(0, valor.length() - 2) + " }";
    }

    // Método para la unión de dos conjuntos
    public ConjuntoBinario union(ConjuntoBinario conjuntoB) {
        int lengthConjuntoA = this.elementos.length;
        int lengthConjuntoB = conjuntoB.getElementos().length;
        int maxBitA = this.maxbit;
        int maxBitB = conjuntoB.getMaxbit();

        int lengthResultado = Math.max(lengthConjuntoA, lengthConjuntoB);
        int maxBitResultado = Math.max(maxBitA, maxBitB);

        ConjuntoBinario resultado = new ConjuntoBinario(lengthResultado * 8);
        resultado.setMaxbit(maxBitResultado);

        for (int i = 0; i < resultado.getElementos().length; i++) {
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
        int maxBitA = this.maxbit;
        int maxBitB = conjuntoB.getMaxbit();

        int lengthResultado = Math.max(lengthConjuntoA, lengthConjuntoB);
        int maxBitResultado = Math.max(maxBitA, maxBitB);

        ConjuntoBinario resultado = new ConjuntoBinario(lengthResultado * 8);
        resultado.setMaxbit(maxBitResultado);

        for (int i = 0; i < resultado.getElementos().length; i++) {
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
        int maxBitA = this.maxbit;
        int maxBitB = conjuntoB.getMaxbit();

        int lengthResultado = Math.max(lengthConjuntoA, lengthConjuntoB);
        int maxBitResultado = Math.max(maxBitA, maxBitB);

        ConjuntoBinario resultado = new ConjuntoBinario(lengthResultado * 8);
        resultado.setMaxbit(maxBitResultado);

        for (int i = 0; i < resultado.getElementos().length; i++) {
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
        int maxBitA = conjuntoUniversal.getMaxbit();

        int lengthResultado = Math.min(lengthConjunto, lengthUniversal);

        ConjuntoBinario resultado = new ConjuntoBinario(lengthResultado * 8);
        resultado.setMaxbit(maxBitA);

        for (int i = 0; i < lengthResultado; i++) {
            int byteConjunto;

            if (i < lengthConjunto) {
                byteConjunto = this.elementos[i];
            } else {
                byteConjunto = 0;
            }
            byte byteUniversal = conjuntoUniversal.getElementos()[i];

            resultado.getElementos()[i] = (byte) (~byteConjunto & byteUniversal);
        }

        return resultado;
    }

}
