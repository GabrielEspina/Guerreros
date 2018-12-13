package ar.edu.ub.testing.guerreros.control.asignacion;

import java.util.Map;

import ar.edu.ub.testing.guerreros.control.Consola;
import ar.edu.ub.testing.guerreros.control.interfaces.IAsignacionPuntos;
import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public abstract class AsignacionPuntos implements IAsignacionPuntos{
	
	private Map<Integer, IControlDeFlujo> menus;
	private GuerreroJugador getGuerrero;
	
	public AsignacionPuntos(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		setMenus(menus);
		setGuerrero(guerrero);
	}

	protected int pedirAsignacion(GuerreroJugador guerrero) {
		int puntos = Consola.pedirNumero();
		if(puntos >= 0) {
			if (verificarAsignacion(guerrero.getPuntos(), puntos)) {
				return puntos;
			}else {
				System.out.println("Puntos insuficientes");
				return pedirAsignacion(guerrero);
			}
		}else {
			System.out.println("Ingrese valores postivos");
			return pedirAsignacion(guerrero);
		}
	
	}
	
	private boolean verificarAsignacion(int puntos, int puntosAsignados) {
		return puntos >= puntosAsignados;
	}

	public Map<Integer, IControlDeFlujo> getMenus() {
		return menus;
	}

	public void setMenus(Map<Integer, IControlDeFlujo> menus) {
		this.menus = menus;
	}

	public GuerreroJugador getGuerrero() {
		return getGuerrero;
	}

	public void setGuerrero(GuerreroJugador guerrero) {
		this.getGuerrero = guerrero;
	}
	
	
}
