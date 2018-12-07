package ar.edu.ub.testing.guerreros.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.ub.testing.guerreros.control.Modo_Juego;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class CreacionDeEntidadesTest {
	
	@Test
	public void crearGuerreroJugadorTest() {
		GuerreroJugador guerrero = new GuerreroJugador();
		
		assertNull( guerrero.getAtributos().getNombre() );
		assertEquals( 0, guerrero.getPuntos() );
		
		guerrero.setAtributosSimple(10, 10, 10, 10, 10);
		assertEquals(10, guerrero.getAtributos().getAtaque());
		
	}
	
	@Test
	public void crearEntidadesTest() {
		
		EntidadesJuego entidades = new EntidadesJuego();
		Modo_Juego.UN_JUGADOR.generarEntidades ( entidades );
		
		assertNotNull( entidades.getJugador() );
		assertEquals(4, entidades.getGuerrerosEnemigos().length);
		assertEquals(1, entidades.getJugador().getAtributos().getAtaque());
		assertEquals(false, entidades.checkEnemigosMuertos());
		assertEquals(1, entidades.getRound());
	}


	

}
