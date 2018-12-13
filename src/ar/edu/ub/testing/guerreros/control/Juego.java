package ar.edu.ub.testing.guerreros.control;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.control.interfaces.IJuego;
import ar.edu.ub.testing.guerreros.control.records.Records;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerreros.vista.MenuRecords;
import ar.edu.ub.testing.guerreros.vista.MenuTutorial;


public class Juego implements IJuego{

	
	
	private EntidadesJuego entidades;
	private Partida partida;
	private Map<Integer, IControlDeFlujo> menus = new HashMap<>(); 
	private Map<Integer,Modo_Juego> modoJuego;

	
	public Juego() {
		setEntidades(new EntidadesJuego());
		setModoJuego(new HashMap<>());
	}
	
	@Override
	public void ejecutar() throws ClassNotFoundException, IOException {
		/*Se crean los modos de juego y los menus por donde el juego seguira su flujo
		 *Se continua al menu principal*/
		crearModos();
		crearMenus();
		menuPrincipal();
	}

	private void salida() {
		Consola.imprimirMensaje(">> Fin del juego <<");
	}

	private void crearModos() {
		/*Mediante un mapa de modos de juego se inicializan mediante un enum, los tipos
		 * de juego que existiran en los guerreros*/
		getModoJuego().put(Modo_Juego.UN_JUGADOR.key(), Modo_Juego.UN_JUGADOR);
		getModoJuego().put(Modo_Juego.MULTI_COOP.key(), Modo_Juego.MULTI_COOP);
	}


	private void crearMenus() {
		/*Por el momento solo se instancian en el mapa el menu principal
		 * y un menu de seleccion*/
		getMenus().put(MENU_PRINCIPAL, new MenuPrincipal());
		getMenus().put(MENU_SELECCION, new MenuSeleccion());
	}


	public void newSinglePlayer() throws ClassNotFoundException, IOException {
		//Se instancia la clase para single player enviando las entidades a intervenir
		this.setPartida(new PartidaSingleplayer(getEntidades()));
	}
	
	public void newMultiCoop() throws ClassNotFoundException, IOException {
		//Se instancia la clase para multi player cooperativo enviando las entidades a intervenir
		this.setPartida(new PartidaMultiplayerCoop(getEntidades()));
	}
	
	public void printEntidades() {
		/*Se piden las entidades del juego para ser mostradas durante el juego
		 * y mediante un foreach se muestran los guerreros enemigos*/
		getEntidades().getJugador().printAtributos();
		System.out.println("Guerreros Enemigos: ");
		for (GuerreroEnemigo g : getEntidades().getGuerrerosEnemigos()) {
			g.printAtributos();
		}
	}
	
	public void menuPrincipal() throws ClassNotFoundException, IOException {
		/*Al iniciar el menu principal se llama al mapa de menu para mostrar el menu guardado con el key 1
		 * luego se solicita al usuario un numero de opciones del mismo menu, y mediante un switch case
		 * se continua por las demas opciones*/
		 
		Consola.limpiarConsola();
		getMenus().get( MENU_PRINCIPAL ).ir();
		Integer eleccionMenu = Consola.pedirNumero(MP_MIN, MP_MAX);
		
		switch( eleccionMenu ) {
		
			case MENU_SELECCION_JUEGO :
				Consola.limpiarConsola();
				menuSeleccionJuego();
				break;
				
			case MENU_RECORDS:
				Consola.limpiarConsola();
				menuRecords();
				break;
				
			case MENU_TUTORIAL:
				menuTutorial();
				menuPrincipal();
				break;
				
			case SALIR:
				salida();
				break;
		}
	}
	
	public void menuRecords() throws ClassNotFoundException, IOException {
		Consola.limpiarConsola();
		MenuRecords menu = new MenuRecords();
		menu.mostrarMenuRecords();
		int eleccionMenu = Consola.pedirNumero(MR_MIN, MR_MAX);
		
		switch(eleccionMenu) {
		
			case MENU_RECORDS_SINGLEPLAYER:
				Consola.limpiarConsola();
				menu.mostrarRecordSingleplayer(Records.cargarSP("recordSP.txt"));
				Consola.apretarEnterParaContinuar();
				menuRecords();
				break;
				
			case MENU_RECORDS_MULTIPLAYER:
				Consola.limpiarConsola();
				menu.mostrarRecordMultiplayer(Records.cargarMP("recordMP.txt"));
				Consola.apretarEnterParaContinuar();
				menuRecords();
				break;
				
			case MENU_RECORDS_VOLVER:
				Consola.limpiarConsola();
				menuPrincipal();
				break;
		}
	}
	
	public void menuSeleccionJuego() throws ClassNotFoundException, IOException {
		/*Se le envia un key al mapa para devolver un determinado menu e ir hasta el mismo
		 * se le pide al usuario que elija una de las opciones (ENTRE 1 Y 4), y mediante un switch case
		 * se determina el tipo de juego elegido*/
		getMenus().get(MENU_SELECCION).ir();
		int eleccionPartida = Consola.pedirNumero(MS_MIN, MS_MAX);
		switch(eleccionPartida) {
			case MENU_SELECCION_SINGLEPLAYER:
				setEntidades(getModoJuego().get(eleccionPartida).generarEntidades(getEntidades()));
				newSinglePlayer();
				Consola.limpiarConsola();
				break;
			case MENU_SELECCION_MULTIPLAYER:
				setEntidades(getModoJuego().get(eleccionPartida).generarEntidades(getEntidades()));
				newMultiCoop();
				Consola.limpiarConsola();
				break;
			case MENU_SELECCION_VOLVER:
				Consola.limpiarConsola();
				menuPrincipal();
				break;
			}
	}
	
	public void menuTutorial() {
		MenuTutorial menu = new MenuTutorial();
		
		Consola.limpiarConsola();
		menu.printPagina1();
		Consola.pedirNumero(MT_MIN,MT_MAX);
		
		Consola.limpiarConsola();
		menu.printPagina2();
		Consola.pedirNumero(MT_MIN,MT_MAX);
		
		Consola.limpiarConsola();
		menu.printPagina3();
		Consola.pedirNumero(MT_MIN,MT_MAX);
	}

	//---GETTERS Y SETTERS PROPIOS DE LA CLASE---//
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