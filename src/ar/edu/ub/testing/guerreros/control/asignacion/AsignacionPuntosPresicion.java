package ar.edu.ub.testing.guerreros.control.asignacion;

import java.util.Map;

import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class AsignacionPuntosPresicion extends AsignacionPuntos {

	public AsignacionPuntosPresicion(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		super(menus,guerrero);
	}

	@Override
	public boolean ejecutar() {
		int puntosPresicion = pedirAsignacion(getGuerrero());
		getGuerrero().setPuntos(getGuerrero().getPuntos() - puntosPresicion);
		getGuerrero().getAtributos().setPresicion(getGuerrero().getAtributos().getPresicion() + puntosPresicion);
		return true;
	}

}
