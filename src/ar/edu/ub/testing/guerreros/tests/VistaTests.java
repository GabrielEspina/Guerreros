package ar.edu.ub.testing.guerreros.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import ar.edu.ub.testing.guerreros.excepciones.EntidadesNoEncontradasException;
import ar.edu.ub.testing.guerreros.vista.VistaCombateSingleplayer;

class VistaTests {
	
	 @Test
	    public void testCrearVistaSingleplayerConNull() {
	         
	        assertThrows(NullPointerException.class, new Executable() {
	             
	            public void execute() throws EntidadesNoEncontradasException {
	            	VistaCombateSingleplayer vista = new VistaCombateSingleplayer(null);
	            }
	        });
	    }
}
