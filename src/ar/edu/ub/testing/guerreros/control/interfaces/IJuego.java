package ar.edu.ub.testing.guerreros.control.interfaces;

import java.io.IOException;

public interface IJuego {
	
	/*--Variables estaticas para parametrizar el menu principal--*/
	public static final int MP_MIN = 1;
	public static final int MP_MAX = 4;
	public static final int MENU_PRINCIPAL = 1;
	public static final int MENU_SELECCION_JUEGO = 1;
	public static final int MENU_RECORDS = 2;
	public static final int MENU_TUTORIAL = 3;
	public static final int SALIR = 4;
	
	/*--Variables estaticas para parametrizar el menu records--*/
	public static final int MR_MIN = 1;
	public static final int MR_MAX = 3;
	public static final int MENU_RECORDS_SINGLEPLAYER = 1;
	public static final int MENU_RECORDS_MULTIPLAYER = 2;
	public static final int MENU_RECORDS_VOLVER = 3;
	
	/*--Variables estaticas para parametrizar el menu seleccion juego--*/
	public static final int MS_MIN = 1;
	public static final int MS_MAX = 3;
	public static final int MENU_SELECCION = 2;
	public static final int MENU_SELECCION_SINGLEPLAYER = 1;
	public static final int MENU_SELECCION_MULTIPLAYER = 2;
	public static final int MENU_SELECCION_VOLVER = 3;
	
	//Parametrizacion del menu tutorial
	public static final int MT_MIN = 1;
	public static final int MT_MAX = 1;
	
	
	public void ejecutar() throws ClassNotFoundException, IOException;

}
