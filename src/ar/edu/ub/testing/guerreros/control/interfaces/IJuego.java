package ar.edu.ub.testing.guerreros.control.interfaces;

import java.io.IOException;

public interface IJuego {
	
	public static final int MENU_PRINCIPAL = 1;
	public static final int MENU_SELECCION_JUEGO = 1;
	public static final int MENU_RECORDS = 2;
	public static final int MENU_TUTORIAL = 3;
	public static final int SALIR = 4;
	
	public void ejecutar() throws ClassNotFoundException, IOException;

}
