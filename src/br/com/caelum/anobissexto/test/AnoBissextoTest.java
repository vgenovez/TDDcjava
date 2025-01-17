package br.com.caelum.anobissexto.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import br.com.caelum.anobissexto.AnoBissexto;

public class AnoBissextoTest {
	
	@Test
	public void deveRetornarAnoBissexto() {        
	    AnoBissexto anoBissexto = new AnoBissexto();

	    assertEquals(true, anoBissexto.isAnoBissexto(2016));
	    assertEquals(true, anoBissexto.isAnoBissexto(2012));
	}

	@Test
	public void naoDeveRetornarAnoBissexto() {        
	    AnoBissexto anoBissexto = new AnoBissexto();        

	    assertEquals(false, anoBissexto.isAnoBissexto(2015));
	    assertEquals(false, anoBissexto.isAnoBissexto(2011));
	}
}
