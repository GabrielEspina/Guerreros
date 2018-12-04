package ar.edu.ub.testing.guerreros.modelo.items;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public class AnilloDeDefensa extends ItemPasivo{
	
	private Guerrero jugador;
	
	public AnilloDeDefensa(Guerrero jugador) {
		this.setNombre("Anillo de Defensa");
		this.setDescripcion("Aumenta la defensa en 5%");
		this.setPrecio(10);
		this.jugador = jugador;
		
	}

	@Override
	public void ejecutarAccionPasiva() {
		this.setAtributoOriginal(jugador.getAtributos().getDefensa());
		this.jugador.getAtributos().setDefensa(this.jugador.getAtributos().getDefensa() + this.calcularAumento(jugador.getAtributos().getDefensa(), 5));
	}

	@Override
	public void desactivarAccion() {
		jugador.getAtributos().setDefensa(this.getAtributoOriginal());
		
	}
	
}
