package ar.edu.ub.testing.guerreros.modelo.habilidades;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class Habilidad15PorcParalizarDosTurnos extends HabilidadPasiva{

	@Override
	public boolean probar() {
		return probar(20,1) || probar(20,2) || probar(20,3);
	}

	@Override
	public void ejecutar(Guerrero jugador) {
		jugador.setChanceParalizar(true);
		
	}

	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return "15% de paralizar un enemigo";
	}

	@Override
	public String nombre() {
		return "Golpe paralizador";
	}

	@Override
	public void desactivarPasivo(GuerreroJugador guerrero) {
		guerrero.setChanceParalizar(false);
		
	}

	@Override
	public int consumeEnergia() {
		return 0;
	}

}
