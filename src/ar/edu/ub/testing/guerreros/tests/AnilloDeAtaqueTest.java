package ar.edu.ub.testing.guerreros.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.items.AnilloDeAtaque;

 

public class AnilloDeAtaqueTest {

	@Test
	public void testAnilloDeAtaque() {
		Guerrero guerrero = new GuerreroJugador();
		guerrero.setAtributosSimple(18, 1, 1, 1, 1);
		AnilloDeAtaque anillo = new AnilloDeAtaque(guerrero);
		assertEquals(19,(guerrero.getAtributos().getAtaque() + anillo.calcularAumento(guerrero.getAtributos().getAtaque(), 5)));
	}
	
}
