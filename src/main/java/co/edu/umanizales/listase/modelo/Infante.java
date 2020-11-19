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
public class Infante implements Serializable{
    
    private String nombre;
    private boolean genero;
    private byte identificador;

    public Infante(String nombre, boolean genero, byte identificador) {
        this.nombre = nombre;
        this.genero = genero;
        this.identificador = identificador;
    }

    public Infante() {
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getGenero() {
        return genero;
    }

    public void setGenero(Boolean genero) {
        this.genero = genero;
    }

    public byte getIdentificador() {
        return identificador;
    }

    public void setIdentificador(byte identificador) {
        this.identificador = identificador;
    }
    
    
    
}
