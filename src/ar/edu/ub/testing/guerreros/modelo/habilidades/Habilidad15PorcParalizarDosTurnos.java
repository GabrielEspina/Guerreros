package ar.edu.ub.testing.guerreros.modelo.habilidades;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public class Habilidad15PorcParalizarDosTurnos extends HabilidadPasiva{

	@Override
	public boolean probar() {
		return probar(20,1) || probar(20,2) || probar(20,3);
	}

	@Override
	public void ejecutar(Guerrero jugador, Guerrero enemigo) {
		// TODO Auto-generated method stub
		
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

}
