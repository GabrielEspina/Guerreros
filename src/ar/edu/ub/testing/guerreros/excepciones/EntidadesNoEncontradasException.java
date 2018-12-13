package ar.edu.ub.testing.guerreros.excepciones;

public class EntidadesNoEncontradasException extends NullPointerException {

	private static final long serialVersionUID = 1L;
	
	public EntidadesNoEncontradasException() {
		super("Entidades no encontradas");
	}

}
