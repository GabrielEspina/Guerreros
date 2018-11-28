import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.vista.IMenu;
import ar.edu.ub.testing.guerreros.vista.MenuConsola;

public class Aplication {

	public static void main(String[] args) {
		
		GuerreroJugador guerrero = new GuerreroJugador();
		
		guerrero.setAtributosSimple(10, 10, 10, 10, 10);
		
		guerrero.getAtributos().setNombre("Pepe");
		
		
		IMenu menu = new MenuConsola();
		
		menu.mostrarMenuPrincipal();
		menu.mostrarMenuSeleccion();
		menu.mostrarMenuTiendaItem(guerrero);
		menu.mostrarMenuTiendaItemsActivos(guerrero);
		menu.mostrarMenuTiendaItemsPasivos(guerrero);
		menu.mostrarMenuTiendaHabilidades(guerrero);
		menu.mostrarMenuTiendaHabilidadesActivas(guerrero);
		menu.mostrarMenuTiendaHabilidadesPasivas(guerrero);
		menu.mostrarMenuAsignacionDePuntos(guerrero);
	}

}
