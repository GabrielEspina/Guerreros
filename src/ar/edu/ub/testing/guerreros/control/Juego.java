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
	/*private Map<Integer,IHabilidadActiva> habildadesActivas;
	private Map<Integer,IHabilidadPasiva> habildadesPasivas;*/
	
	public Juego() {
		setEntidades(new EntidadesJuego());
		setModoJuego(new HashMap<>());
		
		crearModos();
		
		//setHabildadesActivas(new HashMap<>());
		
		//setHabildadesPasivas(new HashMap<>());
			
		//crearHabilidades();
		
		//crearPartidas();
		crearMenus();
		menuPrincipal();
		
	}
	
	
	/*private void crearHabilidades() {
		//Se indican las habilidades activas que puede elegir el usuario
		getHabildadesActivas().put(1, new HabilidadEnemigosPierdenTurno());
		getHabildadesActivas().put(2, new HabilidadEnemigoFallaAtaque());
		getHabildadesActivas().put(3, new HabilidadDaniarEnemigos());
		getHabildadesActivas().put(4, new HabilidadDaniarEnemigoCincoTurnos());
		
		//Se indican las habilidades pasivas que puede elegir el usuario
		getHabildadesPasivas().put(5, new Habilidad25PorcDobleDanio());
		getHabildadesPasivas().put(6, new Habilidad20PorcEvadirAtaque());
		getHabildadesPasivas().put(7, new Habilidad15PorcParalizarDosTurnos());
	}

*/
	private void crearModos() {
		getModoJuego().put(Modo_Juego.UN_JUGADOR.key(), Modo_Juego.UN_JUGADOR);
		getModoJuego().put(Modo_Juego.MULTI_COOP.key(), Modo_Juego.MULTI_COOP);
		getModoJuego().put(Modo_Juego.MULTI_VS.key(), Modo_Juego.MULTI_VS);
	}


	/*private void crearPartidas() {
		getPartidas().put(1,new PartidaSingleplayer(getEntidades()));
		getPartidas().put(2,new PartidaMultiplayerCoop(getEntidades()));
		getPartidas().put(3,new PartidaMultiplayerVersus(getEntidades()));
	}*/
	
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
			break;
		}
		menuPrincipal();
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


	/*public Map<Integer,IHabilidadActiva> getHabildadesActivas() {
		return habildadesActivas;
	}


	public void setHabildadesActivas(Map<Integer,IHabilidadActiva> habildadesActivas) {
		this.habildadesActivas = habildadesActivas;
	}


	public Map<Integer,IHabilidadPasiva> getHabildadesPasivas() {
		return habildadesPasivas;
	}


	public void setHabildadesPasivas(Map<Integer,IHabilidadPasiva> habildadesPasivas) {
		this.habildadesPasivas = habildadesPasivas;
	}*/


 


 
	

}