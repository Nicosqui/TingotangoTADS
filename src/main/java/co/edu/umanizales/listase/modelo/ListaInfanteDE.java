/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.umanizales.listase.modelo;
import co.edu.umanizales.listase.excepciones.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Nicolas Trujillo
 */
public class ListaInfanteDE {
    
    private NodoInfanteDE cabeza;
    //Otros metodos

    public NodoInfanteDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoInfanteDE cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Método para adicionar un nodo
     *
     * - Si tiene perros llamar a un ayudante recorrer todos los perros ,
     * mirando si tienen otro ammarrado cuando llegue al perro libre (No
     * ammarrado a otro) amarra el nuevo perro
     *
     * si no tiene perros El perro entrante Es la cabeza
     */
    public void adicionarNodo(Infante dato) {
        if (cabeza != null) {
            NodoInfanteDE temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            //PArado en el ultimo
            temp.setSiguiente(new NodoInfanteDE(dato));
            temp.getSiguiente().setAnterior(temp);
        } else {
            cabeza = new NodoInfanteDE(dato);
        }
    }

    public boolean adicionarAlFinalNodoInfanteDE(Infante dato) {
        if (dato == null) {
            return false;
        }
        if (cabeza == null) {
            cabeza.setDato(dato);
            return true;
        }
        NodoInfanteDE temp = obtenerUltimo();
        NodoInfanteDE newNode = new NodoInfanteDE();
        newNode.setDato(dato);
        newNode.setAnterior(temp);
        temp.setSiguiente(newNode);
        return true;
    }

    public boolean adicionarAlInicio(Infante dato) {
        if (dato == null) {
            return false;
        }
        NodoInfanteDE newNode = new NodoInfanteDE();
        if (cabeza == null) {
            newNode = cabeza;
            return true;
        }
        newNode.setSiguiente(cabeza);
        cabeza.setAnterior(newNode);
        cabeza = newNode;
        return true;
    }
    
    public String obtenerListadoInfantes() {

        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        return listarInfantes("");
    }

    public String listarInfantes(String listado) {
        if (cabeza != null) {
            NodoInfanteDE temp = cabeza;
            while (temp != null) {
                listado += temp.getDato() + "\n";
                temp = temp.getSiguiente();

            }
            return listado;
        }
        return "No hay infantes";
    }

    public List obtenerListaInfantes() {
        List<Infante> listado = new ArrayList<>();
        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        listarInfantes(listado);
        return listado;
    }

    public void listarInfantes(List listado) {
        if (cabeza != null) {
            NodoInfanteDE temp = cabeza;
            while (temp != null) {
                //listado += temp.getDato()+"\n";
                listado.add(temp.getDato());
                temp = temp.getSiguiente();
            }
        }

    }
    
    public int contarNodos() //cabeza
    {
        if (cabeza != null) {
            NodoInfanteDE temp = cabeza;
            int cont = 1;
            while (temp.getSiguiente() != null) //Mientras el lazo este lleno
            {
                temp = temp.getSiguiente(); // Ayudante pase al siguiente perro
                cont++;
            }
            return cont;
        } else {
            return 0;
        }
    }
    
    public void invertirLista() {
        if (cabeza != null) {
            //Crear una lista temporal la cabeza de la lista temporal está vacía
            ListaInfanteDE listaTemporal = new ListaInfanteDE();
            // Llamo un ayudante
            NodoInfanteDE temp = cabeza;
            //Recorro la lista de principio a fin
            while (temp != null) {
                //Parado en cada nodo , se extrae la información y se
                // envía a la otra lista al inicio
                listaTemporal.adicionarAlInicio(temp.getDato());
                temp = temp.getSiguiente();
            }
            //Igualo la cabeza de mi lista principal a la cabeza de la lista temporal
            cabeza = listaTemporal.getCabeza();
        }
    }

    /**
     * Método que adiciona un nodo al inicio
     *
     * @param dato Dato a agregar *
     */
    public void adicionarAlInicioDE(Infante dato) {
        if (cabeza != null) {
            //Si ya hay datos
            NodoInfanteDE temp = new NodoInfanteDE(dato);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza = temp;
        } else {
            cabeza = new NodoInfanteDE(dato);
        }
    }

    public void eliminarPorPosicion(int posicion) {
        if (cabeza != null) {
            if (posicion == 1) {
                cabeza = cabeza.getSiguiente();
                if (cabeza != null) {
                    cabeza.setAnterior(null);
                }
            } else {
                NodoInfanteDE temp = cabeza;
                int contador = 1;
                while (contador != posicion - 1) {
                    temp = temp.getSiguiente();
                    contador++;
                }
                //Estoy parado en ela anterior del que hay que eliminar
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                if (temp.getSiguiente() != null) {
                    temp.getSiguiente().setAnterior(temp);
                }
            }
        }
    }

    public void eliminarInfante(short codigo) throws InfanteExcepcion {
        if (cabeza != null) {
            if (cabeza.getDato().getIdentificador() == codigo) {
                cabeza = cabeza.getSiguiente();
                cabeza.setAnterior(null);
                return;
            } else {
                NodoInfanteDE temp = cabeza;
                while (temp.getSiguiente() != null) {
                    if (temp.getSiguiente().getDato().getIdentificador() == codigo) {
                        //el que sigue es el que hay que eliminar
                        temp.setSiguiente(temp.getSiguiente().getSiguiente());
                        if (temp.getSiguiente() != null) {
                            temp.getSiguiente().setAnterior(temp);
                        }
                        return;
                    }
                    temp = temp.getSiguiente();
                }

                throw new InfanteExcepcion("El código " + codigo + " no existe en la lista");
            }
        }
        throw new InfanteExcepcion("La lista de infantes está vacía");
    }
    public void eliminar(Infante dato) {
        if (cabeza != null) {
            NodoInfanteDE temp = cabeza;
            while (temp.getDato().getIdentificador() != dato.getIdentificador()) {
                temp = temp.getSiguiente();
            }
            if (temp == cabeza) {
                cabeza = cabeza.getSiguiente();
                if (cabeza != null) {
                    cabeza.setAnterior(null);
                } else {
                    temp.getAnterior().setSiguiente(temp.getSiguiente());
                    if (temp.getSiguiente() != null) {
                        temp.getSiguiente().setAnterior(temp.getAnterior());
                    }
                }
            }
        }
    }
    
     public Infante obtenerInfante(short codigo) throws InfanteExcepcion {
        if (cabeza != null) {
            if (cabeza.getDato().getIdentificador() == codigo) {
                return cabeza.getDato();
            } else {
                NodoInfanteDE temp = cabeza;
                while (temp != null) {
                    if (temp.getDato().getIdentificador() == codigo) {
                        return temp.getDato();
                    }
                    temp = temp.getSiguiente();
                }

                throw new InfanteExcepcion("El código " + codigo + " no existe en la lista");
            }
        }
        throw new InfanteExcepcion("La lista de infantes está vacía");
    }

    public NodoInfanteDE encontrarxPosicionDE(int posicion) {
        NodoInfanteDE temp = null;
        int count = 0;
        if (!(cabeza == null)) {
            if (posicion < tamaño()) {
                temp = this.cabeza;
                while ((count < posicion)) {
                    temp = temp.getSiguiente();
                }
            }
        }
        return temp;
    }

    //Método para obtener el tamaño de la lista
    public int tamaño() {
        NodoInfanteDE temp = null;
        int cont = 0;
        if (cabeza != null) {
            temp = this.cabeza;
            while (temp.getSiguiente() != null) {
                cont++;
                temp = temp.getSiguiente();
            }
        }
        return cont;
    }

    public NodoInfanteDE obtenerUltimo() {

        NodoInfanteDE temp = cabeza;
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        /// Parado en el último nodo
        return temp;
    }
    
    public int obtenerPosicionInfante(short codigo) throws InfanteExcepcion {
        if (cabeza != null) {
            int cont = 1;
            NodoInfanteDE temp = cabeza;
            while (temp != null) {
                if (temp.getDato().getIdentificador()== codigo) {
                    return cont;
                }
                temp = temp.getSiguiente();
                cont++;
            }
            throw new InfanteExcepcion("El código ingresado no ");

        }
        throw new InfanteExcepcion("La lista de infantes está vacía");
    }

    public void intercambiarExtremos() {
        if (cabeza != null) {
            NodoInfanteDE temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            /// Parado en el último nodo
            Infante perrotemp = cabeza.getDato();
            cabeza.setDato(temp.getDato());
            temp.setDato(perrotemp);
        }
    }
   
}
