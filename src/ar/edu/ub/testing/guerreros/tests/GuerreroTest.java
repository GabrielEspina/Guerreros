package ar.edu.ub.testing.guerreros.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

class GuerreroTest {
	

	@Test
	void testConstructorGuerrero() {
		GuerreroJugador guerreroDePrueba = new GuerreroJugador();
		assertEquals(1,guerreroDePrueba.getAtributos().getAtaque());
		assertEquals(1,guerreroDePrueba.getAtributos().getDefensa());
		assertEquals(1,guerreroDePrueba.getAtributos().getPresicion());
		assertEquals(1,guerreroDePrueba.getAtributos().getVida());
		assertEquals(1,guerreroDePrueba.getAtributos().getEnergia());
		assertNull(guerreroDePrueba.getAtributos().getNombre());
		assertEquals(2,guerreroDePrueba.getItems().length);
		
	}
	
	@Test
	
	void testGuerreroAtaque() {
		GuerreroJugador guerreroDePrueba1 = new GuerreroJugador();
		GuerreroJugador guerreroDePrueba2 = new GuerreroJugador();
		guerreroDePrueba1.getAtributos().setVida(5);
		guerreroDePrueba2.getAtributos().setAtaque(5);
		guerreroDePrueba2.atacar(guerreroDePrueba1);
		assertEquals(0,guerreroDePrueba1.getAtributos().getVida());
	}
	
	@Test
	void testGuerreroFallaAtaque() {
		GuerreroJugador guerreroDePrueba1 = new GuerreroJugador();
		GuerreroJugador guerreroDePrueba2 = new GuerreroJugador();
		guerreroDePrueba1.getAtributos().setVida(5);
		guerreroDePrueba2.setFallaAtaque(true);
		guerreroDePrueba2.getAtributos().setAtaque(5);
		guerreroDePrueba2.atacar(guerreroDePrueba1);
		assertEquals(5,guerreroDePrueba1.getAtributos().getVida());
	}
	
	@Test
	void testGuerreroChanceDeEvadir() {
		GuerreroJugador guerreroDePrueba1 = new GuerreroJugador();
		GuerreroJugador guerreroDePrueba2 = new GuerreroJugador();
		guerreroDePrueba2.setChanceEvadir(true);
		guerreroDePrueba1.getAtributos().setAtaque(5);
		
		boolean evadio = false;
		for (int i = 1; i <= 100; i++) {
			
			guerreroDePrueba2.getAtributos().setVida(5);
			guerreroDePrueba1.atacar(guerreroDePrueba2);
			if(guerreroDePrueba2.getAtributos().getVida() == 5) {
				evadio = true;
				i = 99;
			}
		}
		
		assertTrue(evadio);
		
	}
	
	@Test
	void testGuerreroAtaqueCritico() {
		GuerreroJugador guerreroDePrueba1 = new GuerreroJugador();
		GuerreroJugador guerreroDePrueba2 = new GuerreroJugador();
		guerreroDePrueba1.getAtributos().setAtaque(5);
		guerreroDePrueba1.getAtributos().setPresicion(100);
		guerreroDePrueba2.getAtributos().setVida(15);
		guerreroDePrueba1.atacar(guerreroDePrueba2);
		assertEquals(5,guerreroDePrueba2.getAtributos().getVida());
	}
	
	@Test
	void testGuerreroAtacaDefensa() {
		GuerreroJugador guerreroDePrueba1 = new GuerreroJugador();
		GuerreroJugador guerreroDePrueba2 = new GuerreroJugador();
		guerreroDePrueba1.getAtributos().setAtaque(25);
		guerreroDePrueba2.getAtributos().setVida(15);
		guerreroDePrueba2.getAtributos().setDefensa(30);
		guerreroDePrueba2.setDenfendiendo(true);
		guerreroDePrueba1.atacar(guerreroDePrueba2);
		assertEquals(5,guerreroDePrueba2.getAtributos().getVida());
	}
	
	@Test
	void testGuerreroResetVida() {
		
		GuerreroJugador guerreroDePrueba1 = new GuerreroJugador();
		GuerreroJugador guerreroDePrueba2 = new GuerreroJugador();
		guerreroDePrueba1.getAtributos().setAtaque(10);
		guerreroDePrueba2.getAtributos().setVida(15);
		guerreroDePrueba1.atacar(guerreroDePrueba2);
		assertEquals(5,guerreroDePrueba2.getAtributos().getVida());
		guerreroDePrueba2.getAtributos().resetVida();
		assertEquals(15,guerreroDePrueba2.getAtributos().getVida());
	}
	
	@Test
	void testGuerreroAtacaMientrasDefiende() {
		GuerreroJugador guerreroDePrueba1 = new GuerreroJugador();
		GuerreroJugador guerreroDePrueba2 = new GuerreroJugador();
		guerreroDePrueba2.setDenfendiendo(true);
		guerreroDePrueba2.getAtributos().setAtaque(9);
		guerreroDePrueba1.getAtributos().setVida(10);
		guerreroDePrueba2.atacar(guerreroDePrueba1);
		assertEquals(4,guerreroDePrueba1.getAtributos().getVida());
	}
	
	@Test
	void testGuerreroChanceDeParalizar() {
		GuerreroJugador guerreroDePrueba1 = new GuerreroJugador();
		GuerreroJugador guerreroDePrueba2 = new GuerreroJugador();
		guerreroDePrueba2.setChanceParalizar(true);
		guerreroDePrueba1.getAtributos().setVida(100);
		
		boolean paralizo = false;
		for (int i = 1; i <= 100; i++) {
			guerreroDePrueba2.atacar(guerreroDePrueba1);
			if(guerreroDePrueba1.isTurnoPausado()) {
				paralizo = true;
				i = 100;
			}
		}
		
		assertTrue(paralizo);
		
	}
	

}
