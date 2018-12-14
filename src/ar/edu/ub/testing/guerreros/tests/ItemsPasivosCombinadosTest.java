package ar.edu.ub.testing.guerreros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.items.AnilloDeAtaque;
import ar.edu.ub.testing.guerreros.modelo.items.AnilloDeDefensa;
import ar.edu.ub.testing.guerreros.modelo.items.AnilloDeEnergia;
import ar.edu.ub.testing.guerreros.modelo.items.AnilloDePresicion;

class ItemsPasivosCombinadosTest {

	@Test
	void testDosAnillos1() {
		Guerrero guerrero = new GuerreroJugador();
		guerrero.setAtributosSimple(18, 18, 1, 1, 1);
		AnilloDeAtaque anillo = new AnilloDeAtaque(guerrero);
		AnilloDeDefensa anillo2 = new AnilloDeDefensa(guerrero);
		guerrero.getItems()[0] = anillo;
		guerrero.getItems()[1] = anillo2;
		guerrero.activarItemsPasivos();
		assertEquals(19,(guerrero.getAtributos().getAtaque()));
		assertEquals(19,(guerrero.getAtributos().getDefensa()));
		guerrero.desactivarItemsPasivos();
		assertEquals(18,(guerrero.getAtributos().getAtaque()));
		assertEquals(18,(guerrero.getAtributos().getDefensa()));
	}
	
	@Test
	void testDosAnillos2() {
		Guerrero guerrero = new GuerreroJugador();
		guerrero.setAtributosSimple(1, 1, 18, 18, 1);
		AnilloDeEnergia anillo = new AnilloDeEnergia(guerrero);
		AnilloDePresicion anillo2 = new AnilloDePresicion(guerrero);
		guerrero.getItems()[0] = anillo;
		guerrero.getItems()[1] = anillo2;
		guerrero.activarItemsPasivos();
		assertEquals(20,(guerrero.getAtributos().getEnergia()));
		assertEquals(20,(guerrero.getAtributos().getPresicion()));
		guerrero.desactivarItemsPasivos();
		assertEquals(18,(guerrero.getAtributos().getEnergia()));
		assertEquals(18,(guerrero.getAtributos().getPresicion()));
	}

}
