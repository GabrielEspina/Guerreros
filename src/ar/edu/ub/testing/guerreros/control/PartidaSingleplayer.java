package ar.edu.ub.testing.guerreros.control;

import java.util.concurrent.TimeUnit;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerreros.vista.UtilidadesConsola;
import ar.edu.ub.testing.guerreros.vista.VistaCombateSingleplayer;


public class PartidaSingleplayer extends Partida{
	
	private int turnoEnemigo = 0;
	private int turnoJugadorOEnemigo = 1;
	private VistaCombateSingleplayer vista;
	private boolean jugando = true;
	private boolean continuar = true;

	public PartidaSingleplayer(EntidadesJuego entidadesExternas) {
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
	public void victoriaJugadorUno() {
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
	public void victoriaEnemigos() {
		vista.mostrarMensajeEnConsola(" Jugador derrotado por generacion #" + this.getEntidades().getRound());
		print();
		wait(5);
		new Juego().ejecutar();

	}
	@Override
	public void jugar() {
		jugando = true;
		setTurnoJugadorOEnemigo(1);
		activarPasivos();
		this.tienda(entidades.getJugador());
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
		atacar(entidades.getGuerrerosEnemigos()[turnoEnemigo],entidades.getJugador());
		turnoEnemigo ++;
		wait(1);
		System.out.println(entidades.getJugador().getAtributos().getVida());
	}
	
	public void print() {
		
		vista.print(entidades);
	}
	
	private int buscarSiguienteEnemigoNoMuerto(int turno) {
		if (turno > 3) {
			turno = 0;
		}
		int siguienteTurno = turno;
			while (entidades.getGuerrerosEnemigos()[siguienteTurno].checkEnemigoNoDisponible()) {
				
				if(entidades.getGuerrerosEnemigos()[siguienteTurno].checkNocked()) {
					vista.mostrarMensajeEnConsola(" " + entidades.getGuerrerosEnemigos()[siguienteTurno].getAtributos().getNombre() + " se encuentra incapacitado por " + entidades.getGuerrerosEnemigos()[siguienteTurno].getContTurnosPausados() + " turnos ");
				}
				
				if (siguienteTurno == 3) {
					siguienteTurno = 0;
					
				}else {
					
					siguienteTurno++;
					
				}
			}
		return siguienteTurno;
	}
	
	public void atacar(Guerrero atacante, Guerrero atacado){
		int daño = atacante.getAtributos().getAtaque() - (atacado.getAtributos().getDefensa()/2);
		if (daño < 0) {
			daño = 0;
		}
		atacante.atacar(atacado);
		vista.mostrarMensajeEnConsola(" " + atacante.getAtributos().getNombre() + " ataco a " + atacado.getAtributos().getNombre() + " por " + daño + " puntos de daño");
		
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
	
}


