/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.prueba;


import co.edu.umanizales.listase.modelo.ListaSE;
import co.edu.umanizales.listase.modelo.Perro;
/**
 *
 * @author Nicolas Trujillo
 */
public class ProbarListaSE {
    public static void main(String... args)
    {
        //Instanciar una lista se
        ListaSE listaPerros= new ListaSE();
        
        Perro lulu = new Perro("Lulú",(byte) 1, (byte)9, "Femenino");
        listaPerros.adicionarNodo(lulu);
        
        Perro firulais = new Perro("Firulais", (byte)2, (byte)4, "Masculino");
        listaPerros.adicionarNodo(firulais);
        
        Perro pastor = new Perro("Tobby", (byte)3, (byte)6, "\"Masculino\"");
        listaPerros.adicionarNodo(pastor);
        
        System.out.println("finalizao");
    }
}
