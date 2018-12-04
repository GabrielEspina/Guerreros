package ar.edu.ub.testing.guerreros.control;


import java.util.HashMap;
import java.util.Map;
import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;


public class Juego {

	private EntidadesJuego entidades;
	private Partida partida;
	private Map<Integer, IControlDeFlujo> menus = new HashMap<>(); 
	private Map<Integer,Modo_Juego> modoJuego;

	
	public void ejecutar() {
		setEntidades(new EntidadesJuego());
		setModoJuego(new HashMap<>());
		
		crearModos();
		crearMenus();
		menuPrincipal();
	}
	
	

	private void crearModos() {
		getModoJuego().put(Modo_Juego.UN_JUGADOR.key(), Modo_Juego.UN_JUGADOR);
		getModoJuego().put(Modo_Juego.MULTI_COOP.key(), Modo_Juego.MULTI_COOP);
		getModoJuego().put(Modo_Juego.MULTI_VS.key(), Modo_Juego.MULTI_VS);
	}


	private void crearMenus() {
		getMenus().put(1, new MenuPrincipal());
		getMenus().put(2, new MenuSeleccion());
	}


	//AL SELECCIONAR UN NUEVO JUEGO
	public void newSinglePlayer() {
		this.setPartida(new PartidaSingleplayer(getEntidades()));
	}
	
	public void newMultiCoop() {
		this.setPartida(new PartidaMultiplayerCoop(getEntidades()));
	}
	
	public void newMultiVersus() {
		this.setPartida(new PartidaMultiplayerVersus(getEntidades()));
	}
	
	public void printEntidades() {
		getEntidades().getJugador().printAtributos();
		System.out.println("Guerreros Enemigos: ");
		for (GuerreroEnemigo g : getEntidades().getGuerrerosEnemigos()) {
			g.printAtributos();
		}
	}
	
	public void menuPrincipal() {
		getMenus().get(1).ir();
		int eleccionMenu = Consola.pedirNumero(1, 4);
		switch(eleccionMenu) {
		case 1:
			Consola.limpiarConsola();
			menuSeleccionJuego();
			break;
		case 2:
			System.out.println("A implementar");
			break;
		case 3:
			System.out.println("A implementar");
			break;
		case 4:
			break;
		}
	}
	
	public void menuSeleccionJuego() {
		getMenus().get(2).ir();
		int eleccionPartida = Consola.pedirNumero(1, 4);
		switch(eleccionPartida) {
		case 1:
			setEntidades(getModoJuego().get(eleccionPartida).generarEntidades(getEntidades()));
			newSinglePlayer();
			Consola.limpiarConsola();
			break;
		case 2:
			newMultiCoop();
			Consola.limpiarConsola();
			break;
		case 3:
			newMultiVersus();
			Consola.limpiarConsola();
			break;
		case 4:
			Consola.limpiarConsola();
			menuPrincipal();
			break;
		}
	}


	public Partida getPartida() {
		return partida;
	}


	public void setPartida(Partida partida) {
		this.partida = partida;
	}


	public Map<Integer, IControlDeFlujo> getMenus() {
		return menus;
	}


	public void setMenus(Map<Integer, IControlDeFlujo> menus) {
		this.menus = menus;
	}



	public Map<Integer,Modo_Juego> getModoJuego() {
		return modoJuego;
	}


	public void setModoJuego(Map<Integer,Modo_Juego> modoJuego) {
		this.modoJuego = modoJuego;
	}


	public EntidadesJuego getEntidades() {
		return entidades;
	}


	public void setEntidades(EntidadesJuego entidades) {
		this.entidades = entidades;
	}

}