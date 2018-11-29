import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.testing.guerreros.control.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.control.MenuAsignacion;
import ar.edu.ub.testing.guerreros.control.MenuPrincipal;
import ar.edu.ub.testing.guerreros.control.MenuSeleccion;
import ar.edu.ub.testing.guerreros.control.MenuTienda;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class Aplication {

	public static void main(String[] args) {
		
		GuerreroJugador guerrero = new GuerreroJugador();
		GuerreroJugador guerrero2= new GuerreroJugador();
		EntidadesJuego entidades = new EntidadesJuego();
		
		guerrero.setAtributosSimple(10, 10, 10, 10, 10);
		guerrero2.setAtributosSimple(20, 20, 20, 20, 20);
		
		guerrero.getAtributos().setNombre("Pepe");
		guerrero2.getAtributos().setNombre("Monica");
		
		
		Map<Integer, IControlDeFlujo> menus = new HashMap<>(); 
		
		menus.put(1, new MenuPrincipal());
		menus.put(2, new MenuTienda(entidades));
	
		menus.get(2).ir(guerrero);
		menus.get(2).ir(guerrero2);

	}

}
