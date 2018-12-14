package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerreros.excepciones.EntidadesNoEncontradasException;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;

public class CabezeraMultiplayerCoop extends Cabezera{
	
	String separadorTitulo ="XXXXXXXXXXXXXXXXXXXXXXX";
	String titulo;
	String separador ="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	String linea1 = "";
	String linea2 = "";
	String linea3 = "";
	String linea4 = "";
	
	public CabezeraMultiplayerCoop(EntidadesJuego entidades) {
		try {
			construirCabezeraMultiplayer(entidades);
		}catch(EntidadesNoEncontradasException e) {}
	}

	
	public void construirCabezeraMultiplayer(EntidadesJuego entidades) {
		linea1 = construirLinea(entidades.getJugador().getAtributos().getNombre() + ": " + entidades.getJugador().getAtributos().getVida(),("1)" + entidades.getGuerrerosEnemigos()[0].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[0].getAtributos().getVida() + " | " + "2)"+ entidades.getGuerrerosEnemigos()[1].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[1].getAtributos().getVida() ));
		linea2 = construirLinea(" ",("3)" + entidades.getGuerrerosEnemigos()[2].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[2].getAtributos().getVida() + " | " + "4)"+ entidades.getGuerrerosEnemigos()[3].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[3].getAtributos().getVida() ));
		linea3 = construirLinea(entidades.getJugador2().getAtributos().getNombre() + ": " + entidades.getJugador2().getAtributos().getVida(),("5)" + entidades.getGuerrerosEnemigos()[4].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[4].getAtributos().getVida() + " | " + "6)"+ entidades.getGuerrerosEnemigos()[5].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[5].getAtributos().getVida() ));
		linea4 = construirLinea(" ",("7)" + entidades.getGuerrerosEnemigos()[6].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[6].getAtributos().getVida() + " | " + "8)"+ entidades.getGuerrerosEnemigos()[7].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[7].getAtributos().getVida() ));
		titulo = generarTitulo(entidades);
	}
	
	public String construirLinea(String adelante, String atras) {
		String[] atrasSplit = atras.split("\\| ");
		if(atrasSplit[0].length() < 16) {
			atrasSplit[0] = (atrasSplit[0]+" ");
		}
		if(atrasSplit[1].length() < 15) {
			atrasSplit[1] = (atrasSplit[1]+" ");
		}
		String nuevoAtras = (atrasSplit[0] + " | " + atrasSplit[1]);
		int espacios = 59 - (adelante.length() + nuevoAtras.length());
		String linea = "X " + adelante + construirEspacios(espacios) + nuevoAtras + " X";
		return linea;
	}
	
	@Override
	public void print() {
		System.out.println(separador);
		System.out.println(titulo);
		System.out.println(separador);
		System.out.println(linea1);
		System.out.println(linea2);
		System.out.println(linea3);
		System.out.println(linea4);
		System.out.println(separador);
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

}
