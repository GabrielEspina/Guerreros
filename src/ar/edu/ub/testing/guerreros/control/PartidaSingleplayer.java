package ar.edu.ub.testing.guerreros.control;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import ar.edu.ub.testing.guerreros.control.records.Records;
import ar.edu.ub.testing.guerreros.excepciones.EntidadesNoEncontradasException;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerreros.vista.UtilidadesConsola;
import ar.edu.ub.testing.guerreros.vista.VistaCombateSingleplayer;


public class PartidaSingleplayer extends Partida{
	
	static Random  rand = new Random();
	private int turnoEnemigo = 0;
	private int turnoJugadorOEnemigo = 1;
	private VistaCombateSingleplayer vista;
	private boolean jugando = true;
	private boolean continuar = true;

	public PartidaSingleplayer(EntidadesJuego entidadesExternas) throws ClassNotFoundException, IOException {

		super(entidadesExternas);
		vista = new VistaCombateSingleplayer(entidadesExternas);
		jugar();

	}

	@Override
	public void checkearCondicionesDeVictoria() {
		if(this.getEntidades().checkJugadorUnoMuerto()) {
			jugando = false;
			continuar = false;
		}
		if(this.getEntidades().checkEnemigosMuertos()) {
			jugando = false;
			continuar = true;
		}
		print();	
	}

	@Override
	public void victoriaJugadorUno() throws ClassNotFoundException, IOException {
		desactivarPasivos();
		vista.mostrarMensajeEnConsola(" Ganador: " + this.getEntidades().getJugador().getAtributos().getNombre());
		vista.mostrarMensajeEnConsola(" Comenzando nivel: " + (this.getEntidades().getRound() + 1));
		print();
		wait(3);
		entidades.siguienteRound();
		vista = new VistaCombateSingleplayer(entidades);
		turnoEnemigo = 0;
		checkearCondicionesDeVictoria();
		entidades.getJugador().setPuntos(entidades.getJugador().getPuntos() + 3);
		jugar();
	}

	@Override
	public void victoriaJugadorDos() {
	}

	@Override
	public void victoriaEnemigos() throws ClassNotFoundException, IOException {
		vista.mostrarMensajeEnConsola(" Jugador derrotado por generacion #" + this.getEntidades().getRound());
		print();
		wait(5);
		Consola.limpiarConsola();
		getEntidades().resetVidas();
		Records.guardarSP(getEntidades());
		new Juego().ejecutar();

	}
	@Override
	public void jugar() throws ClassNotFoundException, IOException {
		jugando = true;
		setTurnoJugadorOEnemigo(1);
		this.tienda(entidades.getJugador());
		activarPasivos();
		print();
		while(jugando) {
			if (getTurnoJugadorOEnemigo() == 2) {
				turnoEnemigo();
				print();
				setTurnoJugadorOEnemigo(1);
			}else {
				turnoJugador();
				print();
				setTurnoJugadorOEnemigo(2);
			}
			checkearCondicionesDeVictoria();
		}
		if (continuar) {
			victoriaJugadorUno();
		}else {
			victoriaEnemigos();
		}
	}

	@Override
	public void turnoJugador() {
		new ControladorHumano(entidades.getJugador(), entidades, vista);
		print();
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
	
	public void print() {
		
		vista.print(entidades);
	}
	
	private int buscarSiguienteEnemigoNoMuerto(int turno) {
		if (turno > 3) {
			turno = 0;
		}
		int siguienteTurno = turno;
			while (entidades.getGuerrerosEnemigos()[siguienteTurno].murio()) {

				if (siguienteTurno == 3) {
					siguienteTurno = 0;
					
				}else {
					
					siguienteTurno++;
					
				}
			}
		return siguienteTurno;
	}
	
	public void atacar(Guerrero atacante, Guerrero atacado){
		vista.mostrarMensajeEnConsola(atacante.atacar(atacado));
		print();
		
	}
	

	@Override
	public void terminarPartida() {
		
	}

	@Override
	public void record() {
		
	}
	
	public void wait(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
		atacar(guerrero, getEntidades().getJugador());
		
	}
	
}


