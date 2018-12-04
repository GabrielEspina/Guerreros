package ar.edu.ub.testing.guerreros.control.asignacion;

import java.util.Map;

import ar.edu.ub.testing.guerreros.control.interfaces.IAsignacionPuntos;
import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class AsignacionPuntosException implements IAsignacionPuntos {

	public AsignacionPuntosException(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ejecutar() {
		// TODO Auto-generated method stub
		return false;
	}

}
