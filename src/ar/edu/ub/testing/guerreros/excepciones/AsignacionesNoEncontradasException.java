package ar.edu.ub.testing.guerreros.excepciones;

public class AsignacionesNoEncontradasException extends NullPointerException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public AsignacionesNoEncontradasException() {
		super(" Asignaciones no encontradas ");
	}
}
