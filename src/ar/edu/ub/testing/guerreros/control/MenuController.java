package ar.edu.ub.testing.guerreros.control;

import java.util.Map;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.vista.IMenu;
import ar.edu.ub.testing.guerreros.vista.MenuConsola;

public class MenuController implements IMenuController {
	
	private IMenu menu;
	
	
	
	public MenuController() {
		this.setMenu(new MenuConsola());
	}
	
	
	
	@Override
	public void menuPrincipal() {
		Consola.limpiarConsola();
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
	public void menuTienda(Map<Integer,IControlDeFlujo> tiendas,GuerreroJugador guerrero, EntidadesJuego entidades) {
		//Consola.limpiarConsola();
		getMenu().mostrarMenuTienda(guerrero, entidades);
		Integer opcion = Consola.pedirNumero(1,3);
		tiendas.get(opcion).ir();
		
	}

	
	
	@Override
	public void menuItems(GuerreroJugador guerrero) {
		//Consola.limpiarConsola();
		getMenu().mostrarMenuTiendaItem(guerrero);
		
		
	}

	
	
	@Override
	public void menuHabilidades(GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		getMenu().mostrarMenuTiendaHabilidades(guerrero);
		
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

}
