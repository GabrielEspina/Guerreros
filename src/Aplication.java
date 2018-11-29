import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.testing.guerreros.control.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.control.MenuAsignacion;
import ar.edu.ub.testing.guerreros.control.MenuPrincipal;
import ar.edu.ub.testing.guerreros.control.MenuSeleccion;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class Aplication {

	public static void main(String[] args) {
		
		GuerreroJugador guerrero = new GuerreroJugador();
		EntidadesJuego entidades = new EntidadesJuego();
		
		guerrero.setAtributosSimple(10, 10, 10, 10, 10);
		
		guerrero.getAtributos().setNombre("Pepe");
		
		Map<Integer, IControlDeFlujo> menus = new HashMap<>(); 
		menus.put(1, new MenuPrincipal());
		menus.put(2, new MenuAsignacion(guerrero, entidades));
		menus.put(3, new MenuSeleccion(guerrero, entidades));
		
		menus.get(1).ir();
		menus.get(2).ir();
		menus.get(3).ir();
	}

}
