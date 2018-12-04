package ar.edu.ub.testing.guerreros.modelo;

import java.util.Stack;

import ar.edu.ub.testing.guerreros.control.LaboratorioGuerreros;


public class EntidadesJuego {
	
	private int               round;
	//private Ai                inteligenciaBot;
	private GuerreroEnemigo[] guerrerosEnemigos;
	private GuerreroJugador   jugador1;
	private GuerreroJugador   jugador2;
	private Stack<GuerreroEnemigo>           enemigosACruzar;

	public EntidadesJuego() {
		this.round = 1;
		this.enemigosACruzar = new Stack<>();
	}
	public GuerreroEnemigo[] getGuerrerosEnemigos() {
		return guerrerosEnemigos;
	}
	
	public void setGuerrerosEnemigos(GuerreroEnemigo[] guerrerosEnemigos) {
		this.guerrerosEnemigos = guerrerosEnemigos;
	}
	
	public GuerreroJugador getJugador() {
		return jugador1;
	}
	
	public void setJugador(GuerreroJugador jugador) {
		this.jugador1 = jugador;
	}

	public Guerrero getJugador2() {
		return jugador2;
	}

	public void setJugador2(GuerreroJugador jugador2) {
		this.jugador2 = jugador2;
	}
	
	public boolean checkJugadorUnoMuerto() {
		return jugador1.murio();
	}
	
	public boolean checkJugadorDosMuerto() {
		return jugador2.murio();
	}
	public boolean checkEnemigosMuertos() {
		
		boolean resultado = true;
		
		for(GuerreroEnemigo g : this.getGuerrerosEnemigos()) {
			if(!g.murio()) {
				resultado = false;
			}else {
				if(!enemigosACruzar.contains(g)) {
				this.enemigosACruzar.push(g);
				}
			}
		}
		
		return resultado;
	}

	/*public Ai getInteligenciaBot() {
		return inteligenciaBot;
	}

	public void setInteligenciaBot(Ai inteligenciaBot) {
		this.inteligenciaBot = inteligenciaBot;
	}*/
	public int getRound() {
		return round;
	}

	public void siguienteRound() {
		resetVidas();
		this.round ++;
		cruzarEnemigos();
		MutarEnemigos();
		//secretBonus();
	}
	
	public void cruzarEnemigos() {
		GuerreroEnemigo padre = this.enemigosACruzar.pop();
		GuerreroEnemigo madre = this.enemigosACruzar.pop();
		for(int i = 0; i < this.getGuerrerosEnemigos().length; i++) {
			String nombre = "Enemigo " + (i + 1);
			this.getGuerrerosEnemigos()[i] = LaboratorioGuerreros.cruzarGuerreros(padre, madre, nombre);
		}
		this.enemigosACruzar.clear();
	}
	
	public void MutarEnemigos() {
		for (GuerreroEnemigo g : this.getGuerrerosEnemigos()) {
			LaboratorioGuerreros.mutarGuerrero(2, g);
		}
	}
	
	public void resetVidas() {
		
		this.getJugador().getAtributos().resetVida();
		
		if(this.getJugador2() != null) {
			this.getJugador2().getAtributos().resetVida();
		}
		for (GuerreroEnemigo g : this.getGuerrerosEnemigos()) {
			g.getAtributos().resetVida();
		}
	}
}
