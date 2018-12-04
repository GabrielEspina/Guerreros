package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;

public class CabezeraMultiplayerCoop extends Cabezera{
	
	String separadorTitulo ="XXXXXXXXXXXXXXXXXXXXXXX";
	String titulo;
	String separador ="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	String[][] bloque = new String[4][3];
	
	public CabezeraMultiplayerCoop(EntidadesJuego entidades) {
		construirCabezeraSinglePlayer(entidades);
	}
	
	
	public void construirCabezeraSinglePlayer(EntidadesJuego entidades) {
		bloque[0][0] = "X " + entidades.getJugador().getAtributos().getNombre() + ": " + entidades.getJugador().getAtributos().getVida();
		bloque[0][2] = "X 1)" + entidades.getGuerrerosEnemigos()[0].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[0].getAtributos().getVida() + "  ";
		bloque[0][2] += " 2)"+ entidades.getGuerrerosEnemigos()[1].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[1].getAtributos().getVida() + " X";
		bloque[1][0] = "X";
		bloque[1][2] = "X 3)" + entidades.getGuerrerosEnemigos()[2].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[2].getAtributos().getVida() + "  ";
		bloque[1][2] += " 4)"+ entidades.getGuerrerosEnemigos()[3].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[3].getAtributos().getVida() + " X";
		bloque[2][0] = "X " + entidades.getJugador2().getAtributos().getNombre() + ": " + entidades.getJugador2().getAtributos().getVida();
		bloque[2][2] = "X 5)" + entidades.getGuerrerosEnemigos()[4].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[4].getAtributos().getVida() + "  ";
		bloque[2][2] += " 6)"+ entidades.getGuerrerosEnemigos()[5].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[5].getAtributos().getVida() + " X";
		bloque[3][0] = "X";
		bloque[3][2] = "X 7)" + entidades.getGuerrerosEnemigos()[6].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[6].getAtributos().getVida() + "  ";
		bloque[3][2] += " 8)"+ entidades.getGuerrerosEnemigos()[7].getAtributos().getNombre() + ": " + entidades.getGuerrerosEnemigos()[7].getAtributos().getVida() + " X";
		
		int cantidadEspacios = 64 - (bloque[0][0].length() + bloque[0][2].length());
		int cantidadEspacios2 = 64 - (bloque[2][0].length() + bloque[2][2].length());
		bloque[0][1] = construirEspacios(cantidadEspacios-1);
		bloque[1][1] = construirEspacios((cantidadEspacios-2) + bloque[0][0].length());
		bloque[2][1] = construirEspacios(cantidadEspacios2-1);
		bloque[3][1] = construirEspacios((cantidadEspacios2-2) + bloque[2][0].length());
		titulo = generarTitulo(entidades);

	}
	
	@Override
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
