package ar.edu.ub.testing.guerreros.control;

public interface IPartida {
	
	public boolean checkearCondicionesDeVictoria();
	public void victoriaJugadorUno();
	public void victoriaJugadorDos();
	public void victoriaEnemigos();
	public void Jugar();
	public void turnoJugador();
	public void turnoEnemigo();
	public void terminarPartida();
	public void record();
	

}
