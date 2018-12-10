package ar.edu.ub.testing.guerreros.modelo.habilidades;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;

public class HabilidadEnemigoFallaAtaque extends HabilidadActiva{
	
	private String msg = "";
	
	@Override
	public Integer consumeEnergia() {
		return 3;
	}

	@Override
	public void ejecutar(Guerrero jugador, GuerreroEnemigo[] enemigos) {
		int objetivo = enemigoRandom(enemigos.length);
		enemigos[objetivo].setFallaAtaque(true);
		msg = " Una cortina de humo envuelve a " + enemigos[objetivo].getAtributos().getNombre();
	}

	@Override
	public String descripcion() {
		return "Enemigo Aleatorio Falla Ataque! ";
	}

	@Override
	public String nombre() {
		return "Cortina de humo";
	}

	@Override
	public String getMensaje() {
		return msg;
	}

}
