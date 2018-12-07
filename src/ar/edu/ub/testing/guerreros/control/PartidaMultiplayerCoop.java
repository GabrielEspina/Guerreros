package ar.edu.ub.testing.guerreros.control;

import java.util.concurrent.TimeUnit;

import ar.edu.ub.testing.guerreros.vista.UtilidadesConsola;
import ar.edu.ub.testing.guerreros.vista.VistaCombateMultiplayerCoop;
import ar.edu.ub.testing.guerreros.vista.VistaCombateSingleplayer;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class PartidaMultiplayerCoop extends Partida {
	
	private int turnoEnemigo = 0;
	private int turnoJugadorOEnemigo = 1;
	private int turnoJugador = 1;
	private VistaCombateMultiplayerCoop vista;
	private boolean jugando = true;
	private boolean continuar = true;

	public PartidaMultiplayerCoop(EntidadesJuego entidadesExternas) {
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
	
	public void victoriaJugadores() {
		desactivarPasivos();
		vista.mostrarMensajeEnConsola(" Ganadores: " + this.getEntidades().getJugador().getAtributos().getNombre() + " y " + this.getEntidades().getJugador2().getAtributos().getNombre());
		vista.mostrarMensajeEnConsola(" Comenzando nivel: " + (this.getEntidades().getRound() + 1));
		print();
		wait(5);
		entidades.siguienteRound();
		vista = new VistaCombateMultiplayerCoop(entidades);
		turnoEnemigo = 0;
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
	public void victoriaEnemigos() {
		vista.mostrarMensajeEnConsola(" Jugadores derrotados por generacion #" + this.getEntidades().getRound());
		print();
		wait(5);
		new Juego();
	}

	@Override
	public void jugar() {
		setTurnoJugadorOEnemigo(1);
		turnoJugador = 1;
		jugando = true;
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
		
		if(turnoJugador == 2 ) {
			new ControladorHumano(entidades.getJugador2(), entidades, vista);
			print();
			turnoJugador = 1;
		}else {
			new ControladorHumano(entidades.getJugador(), entidades, vista);
			print();
			turnoJugador = 2;
		}
	}

	@Override
	public void turnoEnemigo() {
		print();
		checkearCondicionesDeVictoria();
		wait(2);
		turnoEnemigo =  buscarSiguienteEnemigoNoMuerto(turnoEnemigo);
		atacar(entidades.getGuerrerosEnemigos()[turnoEnemigo],entidades.getJugador());
		turnoEnemigo ++;
		turnoJugador();
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
			while (entidades.getGuerrerosEnemigos()[siguienteTurno].checkEnemigoNoDisponible()) {
				if(entidades.getGuerrerosEnemigos()[siguienteTurno].checkNocked()) {
					vista.mostrarMensajeEnConsola(" " + entidades.getGuerrerosEnemigos()[siguienteTurno].getAtributos().getNombre() + " se encuentra incapacitado por " + entidades.getGuerrerosEnemigos()[siguienteTurno].getContTurnosPausados() + " turnos ");
				}
				if (siguienteTurno == 7) {
					siguienteTurno = 0;
					
				}else {
					
					siguienteTurno++;
					
				}
			}
		return siguienteTurno;
	}
	
	/*public void controladorHumano(Guerrero guerrero) {
		Scanner scan = new Scanner(System.in);
		int eleccion = scan.nextInt();
		while( esEleccionValida(eleccion) ) {
			eleccion = scan.nextInt();
		}
		switch(eleccion) {
		case 1:
			humanoAtaca(entidades,guerrero);	
			break;
		case 2:
			 break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			verAtributos();
			break;
		}
	}
	
	private boolean esEleccionValida(int eleccion) {
		return !(1<= eleccion && eleccion <= 5);
	}

	public void humanoAtaca(EntidadesJuego entidades,Guerrero guerrero) {
		Scanner scan = new Scanner(System.in);
		int eleccion = scan.nextInt();
		while(!(1<= eleccion && eleccion <= entidades.getGuerrerosEnemigos().length)) {
			eleccion = scan.nextInt();
		}
		atacar(guerrero,entidades.getGuerrerosEnemigos()[eleccion-1]);
	}*/
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
		int daño = atacante.getAtributos().getAtaque() - (atacado.getAtributos().getDefensa()/2);
		if (daño < 0) {
			daño = 0;
		}
		atacante.atacar(atacado);
		vista.mostrarMensajeEnConsola(" " + atacante.getAtributos().getNombre() + " ataco a " + atacado.getAtributos().getNombre() + " por " + daño + " puntos de daño");
		
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
