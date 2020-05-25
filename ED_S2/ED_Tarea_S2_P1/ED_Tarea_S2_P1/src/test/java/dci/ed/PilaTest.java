package dci.ed;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PilaTest {

    Pila pila;
    Pila pilaVacia;
    @Before
    public void prepare(){
        pila = new Pila();
        pilaVacia = new Pila();
        pila.push(25);
        pila.push(15);
        pila.push(5);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void push() {
        pila.push(0);
        assertEquals(0,pila.top.valor);
        assertEquals(5,pila.top.siguiente.valor);
        pilaVacia.push(10);
        assertEquals(10,pilaVacia.top.valor);
    }

    @Test
    public void pop() {
        pila.pop();
        assertEquals(15,pila.top.valor);
        assertEquals(25,pila.top.siguiente.valor);
    }

    @Test
    public void popPilaVacia() {
        exceptionRule.expect(NullPointerException.class);
        pilaVacia.pop();
    }
}