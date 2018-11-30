package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public abstract class MenuRaiz implements IControlDeFlujo {
	
	private GuerreroJugador guerrero;
	private EntidadesJuego entidades;
	
	public MenuRaiz() {
		
	}
	
	public MenuRaiz(GuerreroJugador guerrero, EntidadesJuego entidades) {
		setGuerrero(guerrero);
		setEntidades(entidades);
	}
	
	

	public GuerreroJugador getGuerrero() {
		return guerrero;
	}

	public void setGuerrero(GuerreroJugador guerrero) {
		this.guerrero = guerrero;
	}

	public EntidadesJuego getEntidades() {
		return entidades;
	}

	public void setEntidades(EntidadesJuego entidades) {
		this.entidades = entidades;
	}

}
