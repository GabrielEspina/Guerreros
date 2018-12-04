package ar.edu.ub.testing.guerreros.control;


import ar.edu.ub.testing.guerreros.control.interfaces.IMenu;
import ar.edu.ub.testing.guerreros.control.interfaces.IMenuController;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.habilidades.IHabilidad;
import ar.edu.ub.testing.guerreros.modelo.items.Item;
import ar.edu.ub.testing.guerreros.vista.MenuConsola;

public class MenuController implements IMenuController {
	
	private IMenu menu;
	
	public MenuController() {
		this.setMenu(new MenuConsola());
	}
	
	
	
	@Override
	public void menuPrincipal() {
		getMenu().mostrarMenuPrincipal();
	}

	
	
	@Override
	public void menuSeleccion() {
		Consola.limpiarConsola();
		getMenu().mostrarMenuSeleccion();
		
	}

	
	
	@Override
	public void menuCreacionDePersonaje() {
		Consola.limpiarConsola();
		getMenu().mostrarMenuCreacionPersonaje();
		
	}

	
	
	
	@Override
	public void menuTienda(GuerreroJugador guerrero, EntidadesJuego entidades) {
		Consola.limpiarConsola();
		getMenu().mostrarMenuTienda(guerrero, entidades);
		
	}

	
	
	@Override
	public void menuItems(GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		getMenu().mostrarMenuTiendaItem(guerrero);
	}

	
	
	@Override
	public void menuHabilidadesActivas(GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		getMenu().mostrarMenuTiendaHabilidadesActivas(guerrero);
		
	}

	
	
	@Override
	public void menuAsignacion(GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		getMenu().mostrarMenuAsignacionDePuntos(guerrero);
		
	}

	
	public IMenu getMenu() {
		return menu;
	}

	public void setMenu(IMenu menu) {
		this.menu = menu;
	}



	@Override
	public void menuHabilidadesPasivas(GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		getMenu().mostrarMenuTiendaHabilidadesPasivas(guerrero);
		
	}



	@Override
	public void menuItemsActivos(GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		getMenu().mostrarMenuTiendaItemsActivos(guerrero);
		
	}



	@Override
	public void menuItemsPasivos(GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		getMenu().mostrarMenuTiendaItemsPasivos(guerrero);
		
	}



	@Override
	public void menuHabilidades(GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		getMenu().mostrarMenuTiendaHabilidades(guerrero);
		
	}



	@Override
	public void menuCompraItem(Item item) {
		Consola.limpiarConsola();
		getMenu().mostrarMenuCompraItem(item);
		
	}



	@Override
	public void menuCompraHabilidad(IHabilidad habilidad) {
		getMenu().mostrarMenuCompraHabilidad(habilidad);
		
	}

}
