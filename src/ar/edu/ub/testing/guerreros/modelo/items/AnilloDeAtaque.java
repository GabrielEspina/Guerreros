package ar.edu.ub.testing.guerreros.modelo.items;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public class AnilloDeAtaque extends ItemPasivo{
	
	private Guerrero jugador;
	
	public AnilloDeAtaque(Guerrero jugador) {
		this.setNombre("Anillo de Ataque");
		this.setDescripcion("Aumenta el ataque en 5%");
		this.setPrecio(10);
		this.jugador = jugador;
		
	}

	@Override
	public void ejecutarAccionPasiva() {
		this.setAtributoOriginal(jugador.getAtributos().getAtaque());
		this.jugador.getAtributos().setAtaque(this.jugador.getAtributos().getAtaque() + this.calcularAumento(jugador.getAtributos().getAtaque(), 5));
	}

	@Override
	public void desactivarAccion() {
		jugador.getAtributos().setAtaque(this.getAtributoOriginal());
		
	}

}
