package ar.edu.ub.testing.guerreros.modelo.habilidades;

import java.util.Random;

public abstract class HabilidadActiva implements IHabilidadActiva{
	private Random  rand;
	
	public HabilidadActiva() {
		this.setRand(new Random());
	}
	
	public Integer enemigoRandom(Integer max ) {
		return  getRand().nextInt((max - 1) + 1);
	}
 

	private Random getRand() {
		return rand;
	}

	private void setRand(Random rand) {
		this.rand = rand;
	}
	
	public abstract String getMensaje();
}
