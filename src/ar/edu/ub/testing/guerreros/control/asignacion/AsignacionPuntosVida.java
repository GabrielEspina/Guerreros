package ar.edu.ub.testing.guerreros.control.asignacion;

import java.util.Map;

import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class AsignacionPuntosVida extends AsignacionPuntos{

	public AsignacionPuntosVida(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		super(menus,guerrero);
	}

	@Override
	public boolean ejecutar() {
		int puntosVida = pedirAsignacion(getGuerrero());
		getGuerrero().setPuntos(getGuerrero().getPuntos() - puntosVida);
		getGuerrero().getAtributos().setVida(getGuerrero().getAtributos().getVida() + puntosVida);
		
		return true;
	}

}
