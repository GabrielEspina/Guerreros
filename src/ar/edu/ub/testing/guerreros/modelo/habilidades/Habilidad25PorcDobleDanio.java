package ar.edu.ub.testing.guerreros.modelo.habilidades;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public class Habilidad25PorcDobleDanio extends HabilidadPasiva{

	
	
	public Habilidad25PorcDobleDanio() {
		super();

	}

	@Override
	public void ejecutar(Guerrero jugador, Guerrero enemigo) {
		jugador.atacar(enemigo);
	}

	@Override
	public String descripcion() {
		
		return "20% de realizar un critico";
	}

	@Override
	public boolean probar() {
		return probar(4,1);
	}

	@Override
	public String nombre() {
		return "Golpe critico";
	}

}
