package ar.edu.ub.testing.guerreros.control.interfaces;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.habilidades.IHabilidad;
import ar.edu.ub.testing.guerreros.modelo.items.Item;

public interface IMenuController {
	
	public void menuPrincipal();
	
	public void menuSeleccion();
	
	public void menuCreacionDePersonaje();
	
	public void menuTienda(GuerreroJugador guerrero, EntidadesJuego entidades);
	
	public void menuItems(GuerreroJugador guerrero);
	
	public void menuItemsActivos(GuerreroJugador guerrero);
	
	public void menuItemsPasivos(GuerreroJugador guerrero);
	
	public void menuHabilidades(GuerreroJugador guerrero);
	
	public void menuHabilidadesActivas(GuerreroJugador guerrero);
	
	public void menuHabilidadesPasivas(GuerreroJugador guerrero);
	
	public void menuAsignacion(GuerreroJugador guerrero);
	
	public void menuCompraItem(Item item);
	
	public void menuCompraHabilidad(IHabilidad habilidad);
	
	public void menuSeleccionSlot(Item item, GuerreroJugador guerrero);

}
