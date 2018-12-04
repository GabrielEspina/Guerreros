package ar.edu.ub.testing.guerreros.modelo.habilidades;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;

public class HabilidadEnemigoFallaAtaque extends HabilidadActiva{

	@Override
	public Integer consumeEnergia() {
		return 3;
	}

	@Override
	public void ejecutar(Guerrero jugador, GuerreroEnemigo[] enemigos) {
		
	}

	@Override
	public String descripcion() {
		return "Enemigo Falla Ataque! ";
	}

	@Override
	public String nombre() {
		return "Cortina de humo";
	}

}
