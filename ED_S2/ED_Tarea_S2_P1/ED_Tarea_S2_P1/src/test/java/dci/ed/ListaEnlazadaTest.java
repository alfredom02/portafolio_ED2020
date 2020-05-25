package dci.ed;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ListaEnlazadaTest {

    private ListaEnlazada listaEnlazada;
    private ListaEnlazada listaEnlazadaVacia;

    @Before
    public void prepare(){
        listaEnlazadaVacia = new ListaEnlazada();
        listaEnlazada = new ListaEnlazada();
        listaEnlazada.agregarFrente(10);
        listaEnlazada.agregarFrente(15);
        listaEnlazada.agregarFrente(12);
        //lista [12,15,10]
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void contiene() {
        assertEquals(true,listaEnlazada.contiene(15));
        assertEquals(false,listaEnlazada.contiene(40));
        assertEquals(false, listaEnlazadaVacia.contiene(15));
    }

    @Test
    public void getPorIndice() {
        assertEquals(12,listaEnlazada.getPorIndice(0));
        assertEquals(10,listaEnlazada.getPorIndice(2));
    }

    @Test
    public void getPorIndiceIndexOutOfBounce() {
        exceptionRule.expect(IndexOutOfBoundsException.class);
        listaEnlazada.getPorIndice(12);
        listaEnlazadaVacia.getPorIndice(100);
        listaEnlazadaVacia.getPorIndice(-10);
    }

    @Test
    public void getPorIndiceNullPointerException(){
        exceptionRule.expect(NullPointerException.class);
        listaEnlazadaVacia.getPorIndice(12);
    }

    @Test
    public void removerDesdeFrente() {
        listaEnlazada.removerDesdeFrente();
        assertEquals(15,listaEnlazada.getPorIndice(0));
        listaEnlazada.removerDesdeFrente();
        assertEquals(10,listaEnlazada.getPorIndice(0));
    }

    @Test
    public void removerDesdeFrenteListaVacia() {
       exceptionRule.expect(NullPointerException.class);
       listaEnlazadaVacia.removerDesdeFrente();
    }

    @Test
    public void removerDesdeCola() {
        listaEnlazada.removerDesdeCola();
        assertEquals(15,listaEnlazada.getPorIndice(1));
        listaEnlazada.removerDesdeCola();
        assertEquals(12,listaEnlazada.getPorIndice(0));
    }

    @Test
    public void removerDesdeColaListaVacia() {
        exceptionRule.expect(NullPointerException.class);
        listaEnlazadaVacia.removerDesdeCola();
    }

    @Test
    public void removerEnIndice() {
        listaEnlazada.removerEnIndice(1);
        assertEquals(10,listaEnlazada.getPorIndice(1));
        listaEnlazada.removerEnIndice(1);
        assertEquals(12,listaEnlazada.getPorIndice(0));
        listaEnlazada.removerEnIndice(0);
    }

    @Test
    public void removerEnIndiceListaOutOfBounce() {
        exceptionRule.expect(IndexOutOfBoundsException.class);
        listaEnlazadaVacia.removerEnIndice(-1);
        listaEnlazada.removerEnIndice(12);
    }

    @Test
    public void removerEnIndiceListaVacia() {
        exceptionRule.expect(NullPointerException.class);
        listaEnlazadaVacia.removerEnIndice(10);
    }


}