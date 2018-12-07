/**
 * TECNICATURA SUPERIOR EN PROGRAMACION DE COMPUTADORAS - UNIVERSIDAD DE BELGRANO
 * TESTING Y DESARROLLO DE SOFTWARE
 * PROYECTO GUERREROS - TPI
 * 
 * ALUMNOS: 
 * 		GABRIEL ESPINA
 * 		PEDRO RODRIGUEZ
 * 
 * PROFESOR:
 * 		DIDIER RENARD
 */


import java.io.IOException;

import ar.edu.ub.testing.guerreros.control.Juego;



public class Aplication {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		//Se crea una nueva instancia de Juego, y se llama al metodo ejecutar, para dar comienzo al mismo
		new Juego().ejecutar();
	}
	


}
