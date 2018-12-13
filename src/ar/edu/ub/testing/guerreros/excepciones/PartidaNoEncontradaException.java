package ar.edu.ub.testing.guerreros.excepciones;

public class PartidaNoEncontradaException extends NullPointerException{

	private static final long serialVersionUID = 1L;
	
	public PartidaNoEncontradaException() {
		super("Partida no encontrada");
	}

}
