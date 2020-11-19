/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo;

/**
 *
 * @author Nicolas Trujillo
 */
public class ListaDE {

    private NodoDE cabeza;
    //Otros metodos

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
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
    public void adicionarNodo(Perro dato) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            //PArado en el ultimo
            temp.setSiguiente(new NodoDE(dato));
            temp.getSiguiente().setAnterior(temp);
        } else {
            cabeza = new NodoDE(dato);
        }
    }

    public boolean adicionarAlFinalNodoDE(Perro dato) {
        if (dato == null) {
            return false;
        }
        if (cabeza == null) {
            cabeza.setDato(dato);
            return true;
        }
        NodoDE temp = obtenerUltimo();
        NodoDE newNode = new NodoDE();
        newNode.setDato(dato);
        newNode.setAnterior(temp);
        temp.setSiguiente(newNode);
        return true;
    }

    public boolean adicionarAlInicio(Perro dato) {
        if (dato == null) {
            return false;
        }
        NodoDE newNode = new NodoDE();
        if (cabeza == null) {
            newNode = cabeza;
            return true;
        }
        newNode.setSiguiente(cabeza);
        cabeza.setAnterior(newNode);
        cabeza = newNode;
        return true;
    }

    public int contarNodos() //cabeza
    {
        if (cabeza != null) {
            NodoDE temp = cabeza;
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

    /**
     * Método que adiciona un nodo al inicio
     *
     * @param dato Dato a agregar *
     */
    public void adicionarAlInicioDE(Perro dato) {
        if (cabeza != null) {
            //Si ya hay datos
            NodoDE temp = new NodoDE(dato);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza = temp;
        } else {
            cabeza = new NodoDE(dato);
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
                NodoDE temp = cabeza;
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

    public void eliminar(Perro dato) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp.getDato().getNumero() != dato.getNumero()) {
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

    public NodoDE encontrarxPosicionDE(int posicion) {
        NodoDE temp = null;
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
        NodoDE temp = null;
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

    public NodoDE obtenerUltimo() {

        NodoDE temp = cabeza;
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        /// Parado en el último nodo
        return temp;
    }

    public void intercambiarExtremos() {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            /// Parado en el último nodo
            Perro perrotemp = cabeza.getDato();
            cabeza.setDato(temp.getDato());
            temp.setDato(perrotemp);
        }
    }

        public void invertir() {
        if (cabeza != null) {
            ListaDE listaTemporal = new ListaDE();
            NodoDE temp = cabeza;
            while (temp != null)//Recorre de principio a fin
            {
                listaTemporal.adicionarAlInicioDE(temp.getDato());
                temp = temp.getSiguiente();//Ayudante pase al siguiente perro
            }
            cabeza = listaTemporal.getCabeza();
        }
    }
}
