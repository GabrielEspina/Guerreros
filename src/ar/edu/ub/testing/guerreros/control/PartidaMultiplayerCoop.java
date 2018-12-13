package ar.edu.ub.testing.guerreros.control;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import ar.edu.ub.testing.guerreros.vista.UtilidadesConsola;
import ar.edu.ub.testing.guerreros.vista.VistaCombateMultiplayerCoop;
import ar.edu.ub.testing.guerreros.control.records.Records;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class PartidaMultiplayerCoop extends Partida {
	
	static Random  rand = new Random();
	private int turnoEnemigo = 0;
	private int turnoJugadorOEnemigo = 1;
	private int turnoJugador = 1;
	private VistaCombateMultiplayerCoop vista;
	private boolean jugando = true;
	private boolean continuar = true;

	public PartidaMultiplayerCoop(EntidadesJuego entidadesExternas) throws ClassNotFoundException, IOException {
		super(entidadesExternas);
		vista = new VistaCombateMultiplayerCoop(entidades);
		jugar();
	}

	@Override
	public void checkearCondicionesDeVictoria() {
		if(this.getEntidades().checkJugadorUnoMuerto() && this.getEntidades().checkJugadorDosMuerto()) {
			jugando = false;
			continuar = false;
		}
		if(this.getEntidades().checkEnemigosMuertos()) {
			jugando = false;
			continuar = true;
		}
		print();	
	}
	
	public void victoriaJugadores() throws ClassNotFoundException, IOException {
		desactivarPasivos();
		vista.mostrarMensajeEnConsola(" Ganadores: " + this.getEntidades().getJugador().getAtributos().getNombre() + " y " + this.getEntidades().getJugador2().getAtributos().getNombre());
		vista.mostrarMensajeEnConsola(" Comenzando nivel: " + (this.getEntidades().getRound() + 1));
		print();
		wait(5);
		entidades.siguienteRound();
		vista = new VistaCombateMultiplayerCoop(entidades);
		turnoEnemigo = 0;
		turnoJugadorOEnemigo = 1;
		turnoJugador = 1;
		checkearCondicionesDeVictoria();
		entidades.getJugador().setPuntos(entidades.getJugador().getPuntos() + 3);
		((GuerreroJugador) entidades.getJugador2()).setPuntos(((GuerreroJugador) entidades.getJugador2()).getPuntos() + 3);
		jugar();
	}

	@Override
	public void victoriaJugadorUno() {
	}

	@Override
	public void victoriaJugadorDos() {	
	}

	@Override
	public void victoriaEnemigos() throws ClassNotFoundException, IOException {
		vista.mostrarMensajeEnConsola(" Jugadores derrotados por generacion #" + this.getEntidades().getRound());
		print();
		wait(5);
		Consola.limpiarConsola();
		getEntidades().resetVidas();
		Records.guardarMP(getEntidades());
		new Juego().ejecutar();
	}

	@Override
	public void jugar() throws ClassNotFoundException, IOException {
		setTurnoJugadorOEnemigo(1);
		turnoJugador = 1;
		jugando = true;
		this.tienda(entidades.getJugador());
		this.tienda((GuerreroJugador)entidades.getJugador2());
		activarPasivos();
		print();
		while(jugando) {
			
			if (getTurnoJugadorOEnemigo() == 2) {
				turnoEnemigo();
				setTurnoJugadorOEnemigo(1);
			}
			if (getTurnoJugadorOEnemigo() == 1) {
				turnoJugador();
				setTurnoJugadorOEnemigo(2);
			}
			checkearCondicionesDeVictoria();
		}
		if (continuar) {
			victoriaJugadores();
		}else {
			victoriaEnemigos();
		}
	}

	@Override
	public void turnoJugador() {
		
		if(turnoJugador == 2 ) {
			if(!entidades.getJugador2().murio()) {
				new ControladorHumano(entidades.getJugador2(), entidades, vista);
				print();
				turnoJugador = 1;
			}
		}else {
			if(!entidades.getJugador().murio()) {
				new ControladorHumano(entidades.getJugador(), entidades, vista);
				print();
				turnoJugador = 2;
			}
		}
	}

	@Override
	public void turnoEnemigo() {
		wait(1);
		turnoEnemigo =  buscarSiguienteEnemigoNoMuerto(turnoEnemigo);
		if(entidades.getGuerrerosEnemigos()[turnoEnemigo].checkheridaSangrante()) {
			entidades.getGuerrerosEnemigos()[turnoEnemigo].getAtributos().setVida(entidades.getGuerrerosEnemigos()[turnoEnemigo].getAtributos().getVida() - 1);
			vista.mostrarMensajeEnConsola(" " + entidades.getGuerrerosEnemigos()[turnoEnemigo].getAtributos().getNombre() + " sangra por 1 de daño( turnos restantes: " + entidades.getGuerrerosEnemigos()[turnoEnemigo].getContHeridaSangrante() + " )");
			wait(1);
			print();
		}
		if(entidades.getGuerrerosEnemigos()[turnoEnemigo].checkNocked() && !entidades.getGuerrerosEnemigos()[turnoEnemigo].murio() ) {
			vista.mostrarMensajeEnConsola(" " + entidades.getGuerrerosEnemigos()[turnoEnemigo].getAtributos().getNombre() + " se encuentra incapacitado( turnos restantes: " + entidades.getGuerrerosEnemigos()[turnoEnemigo].getContTurnosPausados() + " )");
		}else {
		controladorEnemigo(entidades.getGuerrerosEnemigos()[turnoEnemigo]);
		}
		turnoEnemigo ++;
		wait(1);
		print();
	}

	@Override
	public void terminarPartida() {

		
	}

	@Override
	public void record() {
		
	}
	
	private int buscarSiguienteEnemigoNoMuerto(int turno) {
		if (turno > 7) {
			turno = 0;
		}
		int siguienteTurno = turno;
		while (entidades.getGuerrerosEnemigos()[siguienteTurno].murio()) {

			if (siguienteTurno == 7) {
				siguienteTurno = 0;
				
			}else {
				
				siguienteTurno++;
				
			}
		}
		return siguienteTurno;
	}

	public void print() {
		vista.print(entidades);
	}
	
	public void wait(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void atacar(Guerrero atacante, Guerrero atacado){
		vista.mostrarMensajeEnConsola(atacante.atacar(atacado));
		print();
		
	}
	public void verAtributos() {
		entidades.getJugador().printAtributos();
		System.out.println("Guerreros Enemigos: ");
		for (GuerreroEnemigo g : entidades.getGuerrerosEnemigos()) {
			g.printAtributos();
		}
		UtilidadesConsola.apretarEnterParaContinuar();
		turnoJugador();
	}

	public int getTurnoJugadorOEnemigo() {
		return turnoJugadorOEnemigo;
	}

	public void setTurnoJugadorOEnemigo(int turnoJugadorOEnemigo) {
		this.turnoJugadorOEnemigo = turnoJugadorOEnemigo;
	}
	
	public void controladorEnemigo(GuerreroEnemigo guerrero) {
		guerrero.setDenfendiendo(false);
		int defiende = 1 + rand.nextInt((3 - 1) + 1);
		if(defiende == 1) {
			guerrero.setDenfendiendo(true);
			vista.mostrarMensajeEnConsola(" " + guerrero.getAtributos().getNombre() + " se posicona defensivamente");
		}
		atacar(guerrero, getObjetivoEnemigo());
		
	}
	
	public Guerrero getObjetivoEnemigo() {
		int objetivo = 1 + rand.nextInt((2 - 1) + 1);
		if(objetivo == 1) {
			if(!getEntidades().getJugador().murio()) {
				return getEntidades().getJugador();
			}else {
				return getEntidades().getJugador2();
			}
		}else {
			if(!getEntidades().getJugador2().murio()) {
				return getEntidades().getJugador2();
			}else {
				return getEntidades().getJugador();
			}
		}
	}
	

}
