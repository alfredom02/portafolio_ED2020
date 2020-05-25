package ed.dci;

public class ListaEnlazada {
    // variables miembro de la clase Lista Enlazada
    Nodo cabeza = null;
    Nodo cola = null;

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
     *  Formato de salida: [1,2,3] o []
     */
    public void imprimirLista(ListaEnlazada nombreLista){
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

    public static void main(String[] args) {
    }
}
