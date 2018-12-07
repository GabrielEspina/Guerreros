package ar.edu.ub.testing.guerreros.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.items.AnilloDeEnergia;
 
public class AnilloDeEnergiaTest {

	@Test
	public void testAnilloDeDefensa() {
		Guerrero guerrero = new GuerreroJugador();
		guerrero.setAtributosSimple(1, 1, 18, 1, 1);
		AnilloDeEnergia anillo = new AnilloDeEnergia(guerrero);
		assertEquals(19,(guerrero.getAtributos().getEnergia() + anillo.calcularAumento(guerrero.getAtributos().getEnergia(), 5)));
	}

}
