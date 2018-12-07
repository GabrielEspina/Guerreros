package ar.edu.ub.testing.guerreros.control;

import java.util.concurrent.TimeUnit;

import ar.edu.ub.testing.guerreros.vista.UtilidadesConsola;
import ar.edu.ub.testing.guerreros.vista.VistaCombateMultiplayerVersus;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;

public class PartidaMultiplayerVersus extends Partida {
	
	private VistaCombateMultiplayerVersus vista;
	private int                           turnoJugador = 1;

	public PartidaMultiplayerVersus(EntidadesJuego entidadesExternas) {
		super(entidadesExternas);
		vista = new VistaCombateMultiplayerVersus(entidadesExternas);
		print();
		jugar();
	}

	@Override
	public void checkearCondicionesDeVictoria() {
		if (this.getEntidades().checkJugadorUnoMuerto()) {
			this.victoriaJugadorDos();
	
		}
		if (this.getEntidades().checkJugadorDosMuerto()) {
			this.victoriaJugadorUno();
	
		}
	
	}

	@Override
	public void victoriaJugadorUno() {
		desactivarPasivos();
		vista.mostrarMensajeEnConsola(" Ganador: " + this.getEntidades().getJugador().getAtributos().getNombre());
		print();
		wait(5);
		new Juego();
	}

	@Override
	public void victoriaJugadorDos() {
		desactivarPasivos();
		vista.mostrarMensajeEnConsola(" Ganador: " + this.getEntidades().getJugador2().getAtributos().getNombre());
		print();
		wait(5);
		vista = new VistaCombateMultiplayerVersus(this.getEntidades());
		new Juego();
	}

	@Override
	public void victoriaEnemigos() {
	}

	@Override
	public void jugar() {
		activarPasivos();
		turnoJugador();
	}

	@Override
	public void turnoJugador() {
		print();
		checkearCondicionesDeVictoria();
		if(this.turnoJugador == 1) {
			//controladorHumano(this.getEntidades().getJugador(),this.getEntidades().getJugador2());
		}
		if (this.turnoJugador == 2) {
			//controladorHumano(this.getEntidades().getJugador2(),this.getEntidades().getJugador());
		}
		this.turnoJugador++;
		if(this.turnoJugador > 2) {
			this.turnoJugador = 1;
		}

	
	}

	@Override
	public void turnoEnemigo() {
		
	}

	@Override
	public void terminarPartida() {
		
	}

	@Override
	public void record() {
		
	}
	
	public void print() {
		vista.print(entidades);
	}
	
	/*public void controladorHumano(Guerrero activo, Guerrero pasivo) {
		Scanner scan = new Scanner(System.in);
		int eleccion = scan.nextInt();
		while( esEleccionValida(eleccion) ) {
			eleccion = scan.nextInt();
		}
		switch(eleccion) {
		case 1:
			atacar(activo,pasivo);	
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
	}*/
	
	private boolean esEleccionValida(int eleccion) {
		return !(1<= eleccion && eleccion <= 5);
	}

	public void atacar(Guerrero atacante, Guerrero atacado){
		int daño = atacante.getAtributos().getAtaque() - (atacado.getAtributos().getDefensa()/2);
		if (daño < 0) {
			daño = 0;
		}
		atacante.atacar(atacado);
		vista.mostrarMensajeEnConsola(" " + atacante.getAtributos().getNombre() + " ataco a " + atacado.getAtributos().getNombre() + " por " + daño + " puntos de daño");
		
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
	

}
