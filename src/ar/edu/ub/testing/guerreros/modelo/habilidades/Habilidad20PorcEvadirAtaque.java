package ar.edu.ub.testing.guerreros.modelo.habilidades;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public class Habilidad20PorcEvadirAtaque extends HabilidadPasiva{
	
	@Override
	public String descripcion() {
		
		return "20% de evadir un ataque";
	}
	
	@Override
	public void ejecutar(Guerrero jugador, Guerrero enemigo) {
		
		jugador.getAtributos().setVida( jugador.getAtributos().getVida() +  enemigo.getAtributos().getAtaque() );
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

}
