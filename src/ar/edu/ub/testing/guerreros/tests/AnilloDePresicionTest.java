package ar.edu.ub.testing.guerreros.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.items.AnilloDePresicion;
 

public class AnilloDePresicionTest {

	@Test
	public void testAnilloDePresicion() {
		Guerrero guerrero = new GuerreroJugador();
		guerrero.setAtributosSimple(1, 1, 1, 18, 1);
		AnilloDePresicion anillo = new AnilloDePresicion(guerrero);
		assertEquals(19,(guerrero.getAtributos().getPresicion() + anillo.calcularAumento(guerrero.getAtributos().getPresicion(), 5)));
	}

}
