package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;

public abstract class Partida implements IPartida {
	
	EntidadesJuego entidades;
	
	public Partida(EntidadesJuego entidadesExternas) {
		
		this.entidades = entidadesExternas;
		
	}
	
	public void activarPasivos() {
		if (entidades.getJugador() != null)
		//entidades.getJugador().activarItemsPasivos();
		if (entidades.getJugador2() != null) {}
		//entidades.getJugador2().activarItemsPasivos();
	}
	
	public void desactivarPasivos() {
		if (entidades.getJugador() != null)
		//entidades.getJugador().desactivarItemsPasivos();
		if (entidades.getJugador2() != null) {}
		//entidades.getJugador2().desactivarItemsPasivos();
	}
	
	public EntidadesJuego getEntidades() {
		return this.entidades;
	}
	
	
}
