package ar.edu.ub.testing.guerreros.control.asignacion;

import java.util.Map;

import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class AsignacionPuntosDefensa extends AsignacionPuntos{

	public AsignacionPuntosDefensa(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		super(menus,guerrero);
	}

	@Override
	public boolean ejecutar() {
		int puntosDefensa = pedirAsignacion(getGuerrero());
		getGuerrero().setPuntos(getGuerrero().getPuntos() - puntosDefensa);
		getGuerrero().getAtributos().setDefensa(getGuerrero().getAtributos().getDefensa() + puntosDefensa);
		return true;
	}

}
