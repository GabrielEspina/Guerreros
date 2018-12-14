package ar.edu.ub.testing.guerreros.modelo.habilidades;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;

public class HabilidadDaniarEnemigos extends HabilidadActiva{

	@Override
	public int consumeEnergia() {
		return 6;
	}

	@Override
	public void ejecutar(Guerrero jugador, GuerreroEnemigo[] enemigos) {
		for(GuerreroEnemigo enemigo: enemigos)
			enemigo.getAtributos().setVida(enemigo.getAtributos().getVida()-3);
	}

	@Override
	public String descripcion() {
		return "3 de daño a todos los enemigos";
	}

	@Override
	public String nombre() {
		return "Onda expansiva";
	}

	@Override
	public String getMensaje() {
		return " Una onda expansiva daña por 3 a todos los enemigos";
	}

}
