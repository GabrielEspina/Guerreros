package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class MenuHabilidadesActivas extends MenuRaiz{

	public MenuHabilidadesActivas(GuerreroJugador guerrero, EntidadesJuego entidades) {
		super(guerrero, entidades);
	}

	@Override
	public void ir() {
		MENU.menuHabilidadesActivas(this.getGuerrero());
	}

}
