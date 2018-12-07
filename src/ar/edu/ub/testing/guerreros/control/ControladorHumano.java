package ar.edu.ub.testing.guerreros.control;

import java.util.ArrayList;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.items.ItemActivo;
import ar.edu.ub.testing.guerreros.vista.OpcionesHumano;
import ar.edu.ub.testing.guerreros.vista.Vista;



public class ControladorHumano {
	
	private Guerrero humano;
	private EntidadesJuego entidades;
	private Vista vista;
	private OpcionesHumano opciones;
	
	public ControladorHumano(Guerrero jugador,EntidadesJuego entidades, Vista vista) {
		this.humano = jugador;
		this.entidades = entidades;
		this.vista = vista;
		this.opciones = new OpcionesHumano(jugador);
		this.humano.setDenfendiendo(false);
		menuPrincipal();
	}

	public void menuPrincipal() {
		vista.print(entidades);
		opciones.printOpcionesHumano();
		int eleccion = Consola.pedirNumero(1, 5);
		switch(eleccion) {
		case 1:
			vista.print(entidades);
			if (checkEnergiaSuficiente(humano, 2)) {
				menuAtacar(this.humano,entidades.getGuerrerosEnemigos());
			}else {
				vista.print(entidades);
				opciones.printErrorEnergiaInsuficiente();
				menuPrincipal();
			}
			break;
		case 2:
			vista.print(entidades);
			if (checkEnergiaSuficiente(humano, 3)) {
				humano.setDenfendiendo(true);
				vista.mostrarMensajeEnConsola(" " + humano.getAtributos().getNombre() + " se posicona defensivamente");
				vista.print(entidades);
				menuPrincipal();
			}else {
				vista.print(entidades);
				opciones.printErrorEnergiaInsuficiente();
				menuPrincipal();
			}
			 break;
		case 3:
			break;
		case 4:
			vista.print(entidades);
			menuUsarItems(humano,entidades);
			menuPrincipal();
			break;
		case 5:
			descansar();
			break;
		}
	}
	public void menuAtacar(Guerrero jugador, GuerreroEnemigo[] enemigos) {
		opciones.printPanelAtacar();
		int eleccion = Consola.pedirNumero(1, enemigos.length);
		atacar(jugador, enemigos[eleccion - 1]);
	}
	
	public void menuUsarItems(Guerrero jugador, EntidadesJuego entidades) {
		ArrayList<ItemActivo> items = jugador.getItemsActivos();
		opciones.printPanelItems(items);
		if(items.isEmpty()) {
			vista.print(entidades);
			menuPrincipal();
		}else {
			int eleccion = Consola.pedirNumero(1, items.size());
			if (checkEnergiaSuficiente(humano,items.get(eleccion-1).getEnergiaNecesaria())) {
			vista.print(entidades);
			opciones.printPanelAtacar();
			int eleccionObjectivo = Consola.pedirNumero(1, entidades.getGuerrerosEnemigos().length);
			vista.mostrarMensajeEnConsola(items.get(eleccion-1).ejecutarAccionActiva(entidades, eleccionObjectivo-1));
			}else {
				vista.print(entidades);
				opciones.printErrorEnergiaInsuficiente();
				menuPrincipal();
			}
		}
	}
	
	public void atacar(Guerrero atacante, Guerrero atacado){
		int daño = atacante.getAtributos().getAtaque() - (atacado.getAtributos().getDefensa()/2);
		if (daño < 0) {
			daño = 0;
		}
		vista.mostrarMensajeEnConsola(atacante.atacar(atacado));
		
	}
	
	public void menuUsarHabilidad(GuerreroJugador guerrero, EntidadesJuego entidades) {
		opciones.printPanelHabilidad(guerrero);
		int limite = entidades.getGuerrerosEnemigos().length + 1;
		int eleccion = Consola.pedirNumero(1,limite);
		if (eleccion == limite) {
			vista.print(entidades);
			menuPrincipal();
		}else {
		}
	}
	
	public boolean checkEnergiaSuficiente(Guerrero guerrero, int energiaAGastar) {
		if ((guerrero.getAtributos().getEnergia() - energiaAGastar) < 0) {
			return false;
		}else {
			guerrero.getAtributos().setEnergia(guerrero.getAtributos().getEnergia()- energiaAGastar);
			return true;
		}
	}
	
	public void descansar() {
		if(humano.getAtributos().getEnergiaAux()<(humano.getAtributos().getEnergia() + 4)) {
			humano.getAtributos().setEnergia(humano.getAtributos().getEnergiaAux());
		}else {
		humano.getAtributos().setEnergia(humano.getAtributos().getEnergia() + 4);
		}
		vista.mostrarMensajeEnConsola( " " + humano.getAtributos().getNombre() + " descansa y recupera 4 puntos de energia" );
		vista.print(entidades);
	}
	
}
