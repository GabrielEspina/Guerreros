package ar.edu.ub.testing.guerreros.control;

import java.io.IOException;

public interface IPartida {
	
	public void checkearCondicionesDeVictoria();
	public void victoriaJugadorUno() throws ClassNotFoundException, IOException;
	public void victoriaJugadorDos();
	public void victoriaEnemigos() throws ClassNotFoundException, IOException;
	public void jugar() throws ClassNotFoundException, IOException;
	public void turnoJugador();
	public void turnoEnemigo();
	public void terminarPartida();
	public void record();
	

}
