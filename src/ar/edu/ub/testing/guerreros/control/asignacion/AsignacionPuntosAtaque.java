package ar.edu.ub.testing.guerreros.control.asignacion;

import java.util.Map;

import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class AsignacionPuntosAtaque extends AsignacionPuntos {


	
	public AsignacionPuntosAtaque(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		super(menus,guerrero);
	}

	@Override
	public boolean ejecutar() {
		 int puntosAtaque = pedirAsignacion(getGuerrero());
		 getGuerrero().setPuntos(getGuerrero().getPuntos() - puntosAtaque);
		 getGuerrero().getAtributos().setAtaque(getGuerrero().getAtributos().getAtaque() + puntosAtaque);
		 return true; 
	}


}
