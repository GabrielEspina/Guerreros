package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class MenuAsignacion extends MenuRaiz {

	public MenuAsignacion(GuerreroJugador guerrero, EntidadesJuego entidades) {
		super(guerrero, entidades);
	}

	@Override
	public void ir() {
		MENU.menuAsignacion(this.getGuerrero());
	}

}
