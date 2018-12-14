package ar.edu.ub.testing.guerreros.modelo.habilidades;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class Habilidad20PorcEvadirAtaque extends HabilidadPasiva{
	
	@Override
	public String descripcion() {
		
		return "20% de evadir un ataque";
	}
	
	@Override
	public void ejecutar(Guerrero jugador) {
		jugador.setChanceEvadir(true);
	}
	
	
	@Override
	public boolean probar() {
		return probar(5,1);
	}
	public Habilidad20PorcEvadirAtaque() {
		super();
	}

	@Override
	public String nombre() {
		return "Movimiento agil";
	}

	@Override
	public void desactivarPasivo(GuerreroJugador guerrero) {
		guerrero.setChanceEvadir(false);
	}

	@Override
	public int consumeEnergia() {
		return 0;
	}

}
