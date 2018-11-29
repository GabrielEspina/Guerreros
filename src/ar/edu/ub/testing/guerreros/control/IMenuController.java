package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public interface IMenuController {
	
	public void menuPrincipal();
	
	public void menuSeleccion();
	
	public void menuCreacionDePersonaje(GuerreroJugador guerrero);
	
	public void menuTienda(GuerreroJugador guerrero, EntidadesJuego entidades);
	
	public void menuItems(GuerreroJugador guerrero);
	
	public void menuHabilidades(GuerreroJugador guerrero);
	
	public void menuAsignacion(GuerreroJugador guerrero);

}
