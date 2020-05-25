package dci.ed;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ColaTest {

    Cola cola;
    Cola colaVacia;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void prepare(){
        cola = new Cola();
        colaVacia = new Cola();
        cola.agregarEnCola(25);
        cola.agregarEnCola(15);
        cola.agregarEnCola(5);
        // 25, 15, 5
    }

    @Test
    public void agregarEnCola() {
        cola.agregarEnCola(15);
        assertEquals(15,cola.rear.valor);
        colaVacia.agregarEnCola(15);
        assertEquals(15,colaVacia.front.valor);
        assertEquals(15,colaVacia.rear.valor);
    }

    @Test
    public void removerDesdeFrente() {
        cola.removerDesdeFrente();
        assertEquals(15,cola.front.valor);
        cola.removerDesdeFrente();
        assertEquals(5,cola.front.valor);
    }

    @Test
    public void removerDesdeFrenteVacia() {
        exceptionRule.expect(NullPointerException.class);
        colaVacia.removerDesdeFrente();
    }
}