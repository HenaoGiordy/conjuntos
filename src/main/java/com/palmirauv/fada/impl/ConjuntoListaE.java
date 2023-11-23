/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palmirauv.fada.impl;

import java.util.LinkedList;

/**
 *
 * @author giord
 */
public class ConjuntoListaE {

    private LinkedList<Integer> listaEnlazada;

    public ConjuntoListaE() {
        this.listaEnlazada = new LinkedList<>();
    }

    public LinkedList<Integer> getListaEnlazada() {
        return listaEnlazada;
    }

    public void add(Integer x) {
        this.listaEnlazada.add(x);
    }

    public void remove(Integer x) {
        this.listaEnlazada.add(x);
    }

    @Override
    public String toString() {

        String str = "";

        for (Integer elemento : this.listaEnlazada) {

            str += elemento + " ,";
        }

        return "{ " + str.substring(0, str.length() - 1) + " }";
    }

    public ConjuntoListaE union(ConjuntoListaE conjuntoB) {
        ConjuntoListaE resultado = new ConjuntoListaE();

        return resultado;
    }

    public ConjuntoListaE interseccion(ConjuntoListaE conjuntoB) {
        ConjuntoListaE resultado = new ConjuntoListaE();

        return resultado;
    }

    public ConjuntoListaE diferencia(ConjuntoListaE conjuntoB) {
        ConjuntoListaE resultado = new ConjuntoListaE();

        return resultado;
    }

    public ConjuntoListaE complemento(ConjuntoListaE conjuntoB) {
        ConjuntoListaE resultado = new ConjuntoListaE();

        return resultado;
    }

}
