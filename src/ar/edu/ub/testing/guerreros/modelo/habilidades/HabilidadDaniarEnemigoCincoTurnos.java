package ar.edu.ub.testing.guerreros.modelo.habilidades;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;

public class HabilidadDaniarEnemigoCincoTurnos extends HabilidadActiva{
	
	private String msg = "";

	@Override
	public Integer consumeEnergia() {
		return 8;
	}

	@Override
	public void ejecutar(Guerrero jugador, GuerreroEnemigo[] enemigos) {
		int objetivo = enemigoRandom(enemigos.length);
		enemigos[objetivo].HeridaSangrante(5);
		msg = " " + enemigos[objetivo].getAtributos().getNombre() + " sufre una herida sangrante";
	}

	@Override
	public String descripcion() {
		return "1 de daño por 5 turnos";
	}

	@Override
	public String nombre() {
		return "Herida sangrante";
	}

	@Override
	public String getMensaje() {
		return msg;
	}

}
