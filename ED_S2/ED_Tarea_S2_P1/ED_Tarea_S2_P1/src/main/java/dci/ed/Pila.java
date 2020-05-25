package dci.ed;

public class Pila {
    // agregar los elementos que permiten implementar una Pila
    Nodo top = null;
    /*
     *  Método que permite agregar un elemento desde el frente de la pila
     */
    public void push(int valor){
        // implementar
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = top;
        top = nuevo;
    }

    /*
     *  Método que permite eliminar un elemento desde el frente de la pila
     */
    public void pop(){
        // implementar
        if(top==null) throw new NullPointerException();
        else top = top.siguiente;
    }
}
