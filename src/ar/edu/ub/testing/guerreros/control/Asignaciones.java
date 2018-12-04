package ar.edu.ub.testing.guerreros.control;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosAtaque;
import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosDefensa;
import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosEnergia;
import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosPresicion;
import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosVida;
import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosException;
import ar.edu.ub.testing.guerreros.control.interfaces.IAsignacionPuntos;
import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class Asignaciones {
	
	private Map<Integer,IAsignacionPuntos> asignaciones;
	
	public Asignaciones(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		
		setAsignaciones( new HashMap<>() );
		generarAsignaciones(menus,guerrero);
		
	}

	private void generarAsignaciones(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		
		getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosAtaque(menus,guerrero));
		getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosDefensa(menus,guerrero));
		getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosPresicion(menus,guerrero));
		getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosVida(menus,guerrero));
		getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosEnergia(menus,guerrero));
		getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosException(menus,guerrero));

	}

	public Map<Integer,IAsignacionPuntos> getAsignaciones() {
		return asignaciones;
	}

	private void setAsignaciones(Map<Integer,IAsignacionPuntos> asignaciones) {
		this.asignaciones = asignaciones;
	}

}
