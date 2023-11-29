/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palmirauv.fada.impl;

import java.util.LinkedList;

/**
 *
 * @author Laura Zamora
 */
public class ConjuntoListaE {

    private LinkedList<Integer> elementos;

    public ConjuntoListaE() {
        this.elementos = new LinkedList<>();
    }

    public LinkedList<Integer> getElementos() {
        return elementos;
    }

    public int getSize() {
        return this.elementos.size();
    }

    public void add(int x) {
        if (!this.elementos.contains(x)) {
            this.elementos.add(x);
        }
    }

    public void remove(int x) {
        this.elementos.remove(Integer.valueOf(x));
    }

    public boolean contains(int x) {
        return this.elementos.contains(x);
    }

    public ConjuntoListaE(LinkedList<Integer> elementos) {
        this.elementos = elementos;
    }

    public void setElementos(LinkedList<Integer> elementos) {
        this.elementos = elementos;
    }

    @Override
    public String toString() {
        if (this.elementos.isEmpty()) {
            return "{ }";
        }

        StringBuilder str = new StringBuilder();
        for (Integer elemento : this.elementos) {
            str.append(elemento).append(", ");
        }

        str.setLength(str.length() - 2);

        return "{ " + str.toString() + " }";
    }

    //Método para eliminar el elemento repetido en la unión
    private LinkedList<Integer> eliminarNumero(LinkedList<Integer> lista) {
        LinkedList<Integer> resultado = new LinkedList<>();
        for (Integer elemento : lista) {
            if (!resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    public ConjuntoListaE union(ConjuntoListaE conjuntoB) {
        ConjuntoListaE resultado = new ConjuntoListaE();
        resultado.getElementos().addAll(this.elementos);
        resultado.getElementos().addAll(conjuntoB.getElementos());

        //Eliminar el numero repetido
        resultado.elementos = eliminarNumero(resultado.elementos);

        return resultado;
    }

    public ConjuntoListaE interseccion(ConjuntoListaE conjuntoB) {
        ConjuntoListaE resultado = new ConjuntoListaE();

        for (int elemento : this.elementos) {
            if (conjuntoB.contains(elemento)) {
                resultado.add(elemento);
            }
        }

        return resultado;
    }

    public ConjuntoListaE diferencia(ConjuntoListaE conjuntoB) {
        ConjuntoListaE resultado = new ConjuntoListaE();
        for (int elemento : this.elementos) {
            if (!conjuntoB.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    public ConjuntoListaE complemento(ConjuntoListaE universal) {
        ConjuntoListaE resultado = new ConjuntoListaE();

        for (int elemento : universal.getElementos()) {
            if (!this.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

}
