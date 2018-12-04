package ar.edu.ub.testing.guerreros.modelo.items;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public class AnilloDePresicion extends ItemPasivo{
	
	private Guerrero jugador;
	
	public AnilloDePresicion(Guerrero jugador) {
		this.setNombre("Anillo de Presicion");
		this.setDescripcion("Aumenta la presicion en 10%");
		this.setPrecio(10);
		this.jugador = jugador;
		
	}

	@Override
	public void ejecutarAccionPasiva() {
		this.setAtributoOriginal(jugador.getAtributos().getPresicion());
		this.jugador.getAtributos().setPresicion(this.jugador.getAtributos().getPresicion() + this.calcularAumento(jugador.getAtributos().getPresicion(), 10));
	}

	@Override
	public void desactivarAccion() {
		jugador.getAtributos().setPresicion(this.getAtributoOriginal());
		
	}
	
}
