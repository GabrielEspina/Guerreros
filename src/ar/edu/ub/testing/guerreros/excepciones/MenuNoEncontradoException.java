package ar.edu.ub.testing.guerreros.excepciones;

public class MenuNoEncontradoException extends NullPointerException{

	 
	private static final long serialVersionUID = 1L;
	
	public MenuNoEncontradoException() {
		super("Menu no encontrado");
	}

}
