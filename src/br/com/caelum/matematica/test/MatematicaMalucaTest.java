package br.com.caelum.matematica.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.metematica.MatematicaMaluca;

public class MatematicaMalucaTest {

    @Test
    public void deveMultiplicarNumerosMaioresQue30() {
        MatematicaMaluca matematica = new MatematicaMaluca();
        assertEquals(50*4, matematica.contaMaluca(50));
    }

    @Test
    public void deveMultiplicarNumerosMaioresQue10EMenoresQue30() {
        MatematicaMaluca matematica = new MatematicaMaluca();
        assertEquals(20*3, matematica.contaMaluca(20));
    }

    @Test
    public void deveMultiplicarNumerosMenoresQue10() {
        MatematicaMaluca matematica = new MatematicaMaluca();
        assertEquals(5*2, matematica.contaMaluca(5));
    }
}