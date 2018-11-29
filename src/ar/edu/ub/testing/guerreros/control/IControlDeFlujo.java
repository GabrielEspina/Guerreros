package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public interface IControlDeFlujo {
	
	public static IMenuController MENU = new MenuController();
	public void ir();
	public void ir(GuerreroJugador guerrero);

}
