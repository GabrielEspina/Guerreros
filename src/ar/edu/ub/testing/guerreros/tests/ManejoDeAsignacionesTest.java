package ar.edu.ub.testing.guerreros.tests;

import static org.junit.Assume.assumeNoException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

import ar.edu.ub.testing.guerreros.control.Asignaciones;
import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

class ManejoDeAsignacionesTest {
//new GuerreroJugador()
	@Test
	void guerreroNuloTest() {
		Asignaciones asig = new Asignaciones( new HashMap<Integer,IControlDeFlujo>()  , null);
		//
	}
	
	@Test
	void menusoNulosTest() {
		Asignaciones asig = new Asignaciones(null , new GuerreroJugador());
		//
	}
	
	@Test
	void asignacionesNulasTest() {
		Asignaciones asig = new Asignaciones( new HashMap<Integer,IControlDeFlujo>() , new GuerreroJugador() );
		
		asig.traer(20);
		//
	}

}
