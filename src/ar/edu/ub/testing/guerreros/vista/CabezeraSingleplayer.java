package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerreros.excepciones.EntidadesNoEncontradasException;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;

public class CabezeraSingleplayer extends Cabezera {
	
	String separadorTitulo ="XXXXXXXXXXXXXXXXXXXXXXX";
	String titulo;
	String separador ="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	String[][] bloque = new String[2][3];
	String linea1;
	String linea2;
	
	public CabezeraSingleplayer(EntidadesJuego entidades) {
		try {
		construirCabezeraSinglePlayer(entidades);
		}catch(EntidadesNoEncontradasException e) {}
	}
	
	

	public void construirCabezeraSinglePlayer(EntidadesJuego entidades) {
			linea1 = construirLinea(entidades.getJugador().getAtributos().getNombre() + ": " + entidades.getJugador().getAtributos().getVida(),("1)" + entidades.getGuerrerosEnemigos()[0].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[0].getAtributos().getVida() + "  " + "2)"+ entidades.getGuerrerosEnemigos()[1].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[1].getAtributos().getVida() ));
			linea2 = construirLinea(" ",("3)" + entidades.getGuerrerosEnemigos()[2].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[2].getAtributos().getVida() + "  " + "4)"+ entidades.getGuerrerosEnemigos()[3].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[3].getAtributos().getVida() ));
			titulo = generarTitulo(entidades);
		}
	
	public String construirLinea(String adelante, String atras) {
		int espacios = 59 - (adelante.length() + atras.length());
		String linea = "X " + adelante + construirEspacios(espacios) + atras + " X";
		return linea;
	}

	public String construirEspacios( int cantidad) {
		String espacio = " ";
		for (int i = 0; i < cantidad;i++) {
			espacio += " ";
		}
		return espacio;
	}
	
	public String generarTitulo(EntidadesJuego entidades) {
		String titulo = "Nivel: " + entidades.getRound();
		int cantidadEspacios = 64 - ((separadorTitulo.length()*2) + titulo.length());
		cantidadEspacios = cantidadEspacios - 4;
		String espacio = " ";
		for (int i = 0; i <= cantidadEspacios/2;i++){
			espacio += " ";
		}
		if(entidades.getRound() >= 10) {
			titulo += " ";
		}
		String resultado = separadorTitulo + espacio + titulo + espacio + separadorTitulo;
		
		return resultado;
		
	}

	@Override
	public void print() {
		
		System.out.println(separador);
		System.out.println(titulo);
		System.out.println(separador);
		System.out.println(linea1);
		System.out.println(linea2);
		System.out.println(separador);
	}
}
