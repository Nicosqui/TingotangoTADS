/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo;

import java.io.Serializable;

/**
 *
 * @author Nicolas Trujillo
 */
public class NodoInfanteDE implements Serializable{
    
    private Infante dato;
    private NodoInfanteDE siguiente;
    private NodoInfanteDE anterior;

    public NodoInfanteDE(Infante dato) {
        this.dato = dato;
    }

    public NodoInfanteDE() {
    }
       

    public Infante getDato() {
        return dato;
    }

    public void setDato(Infante dato) {
        this.dato = dato;
    }

    public NodoInfanteDE getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoInfanteDE siguiente) {
        this.siguiente = siguiente;
    } 

    public NodoInfanteDE getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoInfanteDE anterior) {
        this.anterior = anterior;
    }
    
    
}
