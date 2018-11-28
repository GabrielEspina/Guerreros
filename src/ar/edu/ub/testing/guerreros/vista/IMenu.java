package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public interface IMenu {
	
	public void mostrarMenuPrincipal();
	
	public void mostrarMenuSeleccion();
	
	public void mostrarMenuTienda(GuerreroJugador guerrero, EntidadesJuego entidades);
	
	public void mostrarMenuTiendaItem(GuerreroJugador guerrero);
	
	public void mostrarMenuTiendaHabilidades(GuerreroJugador guerrero);
	
	public void mostrarMenuTiendaHabilidadesActivas(GuerreroJugador guerrero);
	
	public void mostrarMenuTiendaHabilidadesPasivas(GuerreroJugador guerrero);
	
	public void mostrarMenuTiendaItemsActivos(GuerreroJugador guerrero);
	
	public void mostrarMenuTiendaItemsPasivos(GuerreroJugador guerrero);
	
	public void mostrarMenuAsignacionDePuntos(GuerreroJugador guerrero);

}
