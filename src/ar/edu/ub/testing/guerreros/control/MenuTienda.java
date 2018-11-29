package ar.edu.ub.testing.guerreros.control;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class MenuTienda extends MenuRaiz{

	private Map<Integer,IControlDeFlujo> tiendas = new HashMap<>();
	
	public MenuTienda(EntidadesJuego entidades) {
		super(entidades);
		
	}

	@Override
	public void ir() {
		MENU.menuTienda(getTiendas(),this.getGuerrero(), this.getEntidades());
		
	}

	public Map<Integer,IControlDeFlujo> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Map<Integer,IControlDeFlujo> tiendas) {
		this.tiendas = tiendas;
	}
	
	@Override
	public void ir(GuerreroJugador guerrero) {
		this.setGuerrero(guerrero);
		getTiendas().put(1, new MenuItems(guerrero,getEntidades()));
		getTiendas().put(2, new MenuAsignacion(guerrero,getEntidades()));
		getTiendas().put(3, new MenuHabilidades(guerrero,getEntidades()));
		this.ir();
	}

}
