package ar.edu.ub.testing.guerreros.control;
import java.util.Random;

import ar.edu.ub.testing.guerreros.modelo.Cruzador;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.Mutador;
import ar.edu.ub.testing.guerreros.vista.UtilidadesConsola;

public class LaboratorioGuerreros {
	
	static Random  rand = new Random();
	
	public static GuerreroJugador nuevoJugador(EntidadesJuego entidades) {
		
		GuerreroJugador jugador = new GuerreroJugador();
		UtilidadesConsola.limpiarConsola();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X         Ingresar Nombre           X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		jugador.getAtributos().setNombre( Consola.pedirNombre() );
		jugador.setPuntos(50);
		return jugador;
	}
	
	public static void generarGuerrerosEnemigos(GuerreroEnemigo[] enemigos) {
		for (int i = 0; i < enemigos.length; i++) {
			GuerreroEnemigo guerrero = new GuerreroEnemigo();              //CREA UN SET INICIAL DE GUERREROS ENEMIGOS
			mutarGuerrero(10,guerrero);
			guerrero.getAtributos().setNombre("Enemigo " + (i+1));
			enemigos[i] = guerrero;
		}
	}	
	/*public static void mutarGuerreroManual(int puntos, GuerreroJugador guerrero, EntidadesJuego entidades){
		while (puntos > 0) {
			
			
			UtilidadesConsola.limpiarConsola();
			System.out.println("Puntos restantes =" + puntos);
			System.out.println("----------------------------");
			System.out.println("1) Ataque ->\t"     + guerrero.getAtributos().getAtaque());
			System.out.println("2) Defensa ->\t"    + guerrero.getAtributos().getDefensa());
			System.out.println("3) Presicion ->\t"  + guerrero.getAtributos().getPresicion());
			System.out.println("4) Vida ->\t"       + guerrero.getAtributos().getVida());
			System.out.println("5) Energia ->\t"    + guerrero.getAtributos().getEnergia());
			System.out.println("----------------------------");
			System.out.println("6) Regresar");
			System.out.println("Seleccionar campo a asignar");
			
			int eleccion = Consola.pedirNumero(1, 6);
			
			if(eleccion == 6) {
				//new VistaTiendaYEvolucion((GuerreroJugador) guerrero,entidades);
			}
			
			Mutador.values()[eleccion - 1 ].asignarPunto(guerrero);  //SE ASIGNA MANUALMENTE EL TIPO DE MUTACION DESDE EL ENUM MUTADOR
			puntos--;
			guerrero.setPuntos(puntos);
		}
	}*/
	
	public static void mutarGuerrero(int puntos, Guerrero guerrero) {
		for (int i = 0; i < puntos; i ++) {
			int eleccion = 1 + rand.nextInt((5 - 1) + 1);
			Mutador.values()[eleccion - 1 ].asignarPunto(guerrero);  //ASIGNA ALEATORIAMENTE EL TIPO DE MUTACION DESDE EL ENUM MUTADOR
		}
	}
	
	public static GuerreroEnemigo cruzarGuerreros(GuerreroEnemigo padre, GuerreroEnemigo madre,String nombre){
		Random rand = new Random();
		int eleccion = 1 + rand.nextInt((4 - 1) + 1);
		return Cruzador.values()[eleccion - 1 ].cruzar(padre, madre, nombre); //SELECCIONA ALEATORIAMENTE EL TIPO DE CRUZE DESDE EL ENUM CRUZADOR
	}
	

	
}