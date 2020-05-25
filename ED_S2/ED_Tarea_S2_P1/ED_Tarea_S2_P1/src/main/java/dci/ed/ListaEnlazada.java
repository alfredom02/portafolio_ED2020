package dci.ed;

public class ListaEnlazada {

    Nodo cabeza = null;
    Nodo cola = null;

    /*
     *  Método que permite si un valor particular
     *  existe en la Lista Enlazada
     */
    public boolean contiene(int valor){
        // implementar
        Nodo actual=cabeza;
        while (actual!=null){
            if (actual.valor==valor) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    /*
     *  Método que permite obtener un valor determinado
     *  en una posición específica de una la Lista Enlazada
     */
    public int getPorIndice(int index){
        // implementar
        if (index<0) throw new IndexOutOfBoundsException();
        else if (cabeza==null) throw new NullPointerException();
        else{
            Nodo actual = cabeza;
            for (int i = 0; i < index; i++) {
                if (actual!=null) actual = actual.siguiente;
                else throw new IndexOutOfBoundsException();
            }
            return actual.valor;
        }
    }

    /*
     *  Método que permite remover un valor
     *  desde el frente de una la Lista Enlazada
     */
    public void removerDesdeFrente(){
        // implementar
        if(cabeza==null) throw new NullPointerException();
        else cabeza = cabeza.siguiente;
        if(cabeza==null) cola = null;
    }

    /*
     *  Método que permite remover un valor
     *  desde la rear una la Lista Enlazada
     */
    public void removerDesdeCola(){
        // implementar
        if(cabeza==null) throw new NullPointerException();
        else if (cabeza.equals(cola)){
            cabeza = null;
            cola = null;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente!=cola) actual=actual.siguiente;
            cola = actual;
            actual.siguiente = null;
        }
    }

    /*
     *  Método que permite remover un valor determinado
     *  en una posición específica de una la Lista Enlazada
     */
    public void removerEnIndice(int index){
        // implementar
        if (index<0) throw new IndexOutOfBoundsException();
        else if(index==0) removerDesdeFrente();
        else {
            Nodo actual = cabeza;
            for (int i = 0; i < index-1; i++) {
                if (actual==null) throw  new NullPointerException();
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
            if (actual.siguiente==null) cola = actual;
        }
    }

    /*
     *  Método que permite agregar un elemento
     *  al frente de la Lista Enlazada
     */
    public void agregarFrente(int valor){
        // implementar
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        if (nuevo.siguiente==null) cola = nuevo;

    }

    /*
     *  Método que permite agregar un elemento
     *  al final la Lista Enlazada
     */
    public void agregarFinal(int valor){
        // implementar
        Nodo nuevo = new Nodo(valor);
        if(cabeza==null) cabeza = nuevo;
        else cola.siguiente = nuevo;
        cola = nuevo;
    }

    /*
     *  Método que permite agregar un elemento
     *  en un índice específico de la Lista Enlazada
     */
    public void agregarEnIndice(int index, int valor){
        // implementar
        if (index<0) throw new IndexOutOfBoundsException();
        else if(index==0) agregarFrente(valor);
        else {
            Nodo nuevo = new Nodo(valor);
            Nodo actual = cabeza;
            for (int i = 0; i < index - 1; i++) {
                if(actual!=null) actual = actual.siguiente;
                else throw new IndexOutOfBoundsException();
            }
            if (actual==cola) agregarFinal(valor);
            else {
                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;
            }
        }
    }

    /*
     *  Método que permite imprimir los elementos
     *  de la Lista Enlazada
     */
    public void imprimirLista(ListaEnlazada nombreLista){
        // implementar
        Nodo actual = nombreLista.cabeza;
        System.out.print("[");
        if (nombreLista.cabeza!=null) {
            while (actual != null) {
                if (actual!=cola) System.out.print(actual.valor + ",");
                else System.out.print(actual.valor);
                actual = actual.siguiente;
            }
        }
        System.out.print("]");
    }

}
