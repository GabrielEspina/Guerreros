package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.excepciones.MenuNoEncontradoException;

public class MenuError implements IControlDeFlujo {

	@Override
	public void ir() {
		try {
			throw new MenuNoEncontradoException();
		} catch (MenuNoEncontradoException e) { 
			System.out.println(e.getMessage());
		}

	}

}
