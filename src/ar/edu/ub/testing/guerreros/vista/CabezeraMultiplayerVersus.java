package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;

public class CabezeraMultiplayerVersus {
	
	String separadorTitulo ="XXXXXXXXXXXXXXXXXXXXXXX";
	String titulo;
	String separador ="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	String[][] bloque = new String[1][3];
	
	public CabezeraMultiplayerVersus(EntidadesJuego entidades) {
		construirCabezeraMultiplayerVersus(entidades);
	}
	
	
	
	public void construirCabezeraMultiplayerVersus(EntidadesJuego entidades) {
		bloque[0][0] = "X " + entidades.getJugador().getAtributos().getNombre() + ": " + entidades.getJugador().getAtributos().getVida();
		bloque[0][2] = "X " + entidades.getJugador2().getAtributos().getNombre() + ": " + entidades.getJugador2().getAtributos().getVida() + " X";
		int cantidadEspacios = 64 - (bloque[0][0].length() + bloque[0][2].length());
		bloque[0][1] = construirEspacios(cantidadEspacios-1);
		titulo = generarTitulo(entidades);
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

	public void print() {
		
		System.out.println(separador);
		System.out.println(titulo);
		System.out.println(separador);
		
		for(String[] s : bloque) {
			for (String s2 : s) {
				System.out.print(s2);
			}
			System.out.println(" ");
		}
		
		System.out.println(separador);
	}
}
