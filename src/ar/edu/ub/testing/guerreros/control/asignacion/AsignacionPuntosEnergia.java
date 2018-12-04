package ar.edu.ub.testing.guerreros.control.asignacion;

import java.util.Map;

import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class AsignacionPuntosEnergia extends AsignacionPuntos{

	public AsignacionPuntosEnergia(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		super(menus,guerrero);
	}

	@Override
	public boolean ejecutar() {
		int puntosEnergia = pedirAsignacion(getGuerrero());
		getGuerrero().setPuntos(getGuerrero().getPuntos() - puntosEnergia);
		getGuerrero().getAtributos().setEnergia(getGuerrero().getAtributos().getEnergia() + puntosEnergia);
		return true;
	}

}
