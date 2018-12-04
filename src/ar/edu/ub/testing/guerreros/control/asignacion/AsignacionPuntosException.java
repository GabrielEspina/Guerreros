package ar.edu.ub.testing.guerreros.control.asignacion;

import java.util.Map;

import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class AsignacionPuntosException extends AsignacionPuntos {

	public AsignacionPuntosException(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		super(menus,guerrero);
	}

	@Override
	public boolean ejecutar() {
		//HACER UNA EXCEPTION QUE DEVUELVA FALSE PARA QUE NO QUEDE TAN VACIO EL METODO
		return false;
	}

}
