package ar.edu.ub.testing.guerreros.modelo.habilidades;

import java.util.Random;

import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public abstract class HabilidadPasiva implements IHabilidadPasiva{
	
 
	private Random  rand;
	
	public HabilidadPasiva( ){
 
		this.setRand(new Random());
	}
	
	public boolean probar(Integer max , Integer numEsperado) {
		return numEsperado == getRand().nextInt((max - 1) + 1);
	}
 

	private Random getRand() {
		return rand;
	}

	private void setRand(Random rand) {
		this.rand = rand;
	}
	
	public abstract void desactivarPasivo(GuerreroJugador guerrero);
	
}
