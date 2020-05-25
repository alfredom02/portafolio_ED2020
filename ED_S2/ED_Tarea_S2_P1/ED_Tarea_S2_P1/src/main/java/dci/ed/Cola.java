package dci.ed;

public class Cola {
    
    // agregar los elementos que permiten implementar una Cola
    Nodo front = null;
    Nodo rear = null;
    /*
     *  Método que permite agregar al final de la rear
     */
    public void agregarEnCola(int valor){
        // implementar
        Nodo nuevo = new Nodo(valor);
        if(front==null) front = nuevo;
        else rear.siguiente = nuevo;
        rear = nuevo;
    }

    /*
     *  Método que permite remover desde el frente de la rear
     */
    public void removerDesdeFrente(){
        // implementar
        if(front==null) throw new NullPointerException();
        else front = front.siguiente;
        if(front==null) rear = null;
    }

}
