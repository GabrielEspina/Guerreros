package ar.edu.ub.testing.guerreros.excepciones;

public class JugadorNoEncontradoException extends NullPointerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public JugadorNoEncontradoException() {
		super("Jugador no encontrado");
	}
	
}
