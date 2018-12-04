package ar.edu.ub.testing.guerreros.modelo.habilidades;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;

public class HabilidadDaniarEnemigoCincoTurnos extends HabilidadActiva{
	
	public static Integer ENEMIGO_RANDOM;
	
	@SuppressWarnings("static-access")
	public HabilidadDaniarEnemigoCincoTurnos() {
		this.ENEMIGO_RANDOM = enemigoRandom(4)-1;
	}

	@Override
	public Integer consumeEnergia() {
		return 8;
	}

	@Override
	public void ejecutar(Guerrero jugador, GuerreroEnemigo[] enemigos) {
		enemigos[ENEMIGO_RANDOM].getAtributos().setVida(enemigos[ENEMIGO_RANDOM].getAtributos().getVida()-1);
	}

	@Override
	public String descripcion() {
		return "Hace da�o al enemigo por 5 turnos";
	}

	@Override
	public String nombre() {
		return "Herida sangrante";
	}

}
