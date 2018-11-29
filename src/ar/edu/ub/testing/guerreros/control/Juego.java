package ar.edu.ub.testing.guerreros.control;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class Juego {
	
	private static Juego juego;
	private Map<Integer,GuerreroJugador> jugadores;
	
	private Juego() {
		
	}
	
	public Juego getInstance() {
		if(juego != null) {
			return juego;
		}else {
			return new Juego();
		}
	}

	public Map<Integer,GuerreroJugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Map<Integer,GuerreroJugador> jugadores) {
		this.jugadores = jugadores;
	}

}
