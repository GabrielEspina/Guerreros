package ar.edu.ub.testing.guerreros.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.edu.ub.testing.guerreros.control.MenuAsignacion;
import ar.edu.ub.testing.guerreros.control.MenuController;
import ar.edu.ub.testing.guerreros.control.MenuCreacion;
import ar.edu.ub.testing.guerreros.control.MenuError;
import ar.edu.ub.testing.guerreros.control.MenuHabilidades;
import ar.edu.ub.testing.guerreros.control.MenuItems;
import ar.edu.ub.testing.guerreros.control.MenuPrincipal;
import ar.edu.ub.testing.guerreros.control.MenuSeleccion;
import ar.edu.ub.testing.guerreros.control.MenuTienda;
import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class FlujoDeMenuTest {
	
	Map<Integer, IControlDeFlujo> menus;
	GuerreroJugador guerrero ;
	EntidadesJuego entidades ;
	
	@Before
	public void antes() {
		guerrero = new GuerreroJugador();
		entidades = new EntidadesJuego();
		
		guerrero.setAtributosSimple(10, 10, 10, 10, 10);
		guerrero.getAtributos().setNombre("Pepe");
		
		menus = new HashMap<>(); 
		System.out.println("atributos creados");
	}
	
	@After
	public void despues() {
		menus.clear();
		System.out.println("menu vaciado");
	}

	
	
	@Test
	public void flujoDeMenu() {
		
		menus.put(1, new MenuPrincipal());
		menus.put(2, new MenuAsignacion(guerrero, entidades));
		menus.put(3, new MenuSeleccion(guerrero, entidades));
		menus.put(4, new MenuHabilidades(guerrero,entidades));
		menus.put(5, new MenuTienda(guerrero, entidades));
		menus.put(6, new MenuItems(guerrero, entidades));
		menus.put(7, new MenuCreacion(guerrero, entidades));
		menus.put(-1,new MenuError());
	 
		for(int i =1; i < menus.size();i++)
			menus.get(i).ir();
		 
		menus.get(-1).ir();
		
	}

	
	

}
