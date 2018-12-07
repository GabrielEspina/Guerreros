package ar.edu.ub.testing.guerreros.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.Mutador;
 

public class MutadorTest {
	
	Guerrero guerrero = new GuerreroJugador();

	@Test
	public void testMutarAtaque() {
		guerrero.getAtributos().setAtaque(5);
		Mutador.MUTAR_ATAQUE.asignarPunto(guerrero);
		assertEquals(6,guerrero.getAtributos().getAtaque());
	}
	
	@Test
	public void testMutarDefensa() {
		guerrero.getAtributos().setDefensa(5);
		Mutador.MUTAR_DEFENSA.asignarPunto(guerrero);
		assertEquals(6,guerrero.getAtributos().getDefensa());
	}
	
	@Test
	public void testMutarEnergia() {
		guerrero.getAtributos().setEnergia(5);
		Mutador.MUTAR_ENERGIA.asignarPunto(guerrero);
		assertEquals(6,guerrero.getAtributos().getEnergia());
	}
	
	@Test
	public void testMutarPresicion() {
		guerrero.getAtributos().setPresicion(5);
		Mutador.MUTAR_PRESICION.asignarPunto(guerrero);
		assertEquals(6,guerrero.getAtributos().getPresicion());
	}
	
	@Test
	public void testMutarVida() {
		guerrero.getAtributos().setVida(5);
		Mutador.MUTAR_VIDA.asignarPunto(guerrero);
		assertEquals(6,guerrero.getAtributos().getVida());
		assertEquals(6,guerrero.getAtributos().getVidaAux());
	}
}
