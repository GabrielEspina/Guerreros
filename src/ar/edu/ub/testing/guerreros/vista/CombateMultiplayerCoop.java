package ar.edu.ub.testing.guerreros.vista;

import java.util.ArrayList;

import ar.edu.ub.testing.guerreros.excepciones.EntidadesNoEncontradasException;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;


public class CombateMultiplayerCoop implements IVista{
	
	private ArrayList<String[][]> bloques = new ArrayList<>();
	private String[][]            bloqueUno = new String[4][64];
	private String[][]            bloqueDos = new String[4][64];
	private String[][]            bloqueTres = new String[4][64];
	private String[][]            bloqueCuatro = new String[4][64];
	
	public CombateMultiplayerCoop(EntidadesJuego entidades) {
		try {
		generarBloques(entidades);
		}catch(EntidadesNoEncontradasException e) {}
	}

	@Override
	public void print() {
		for (String[][] s : bloques) {
			for (String[] s2 : s) {
				for (String s3 : s2) {
					if (s3 != null) {
					System.out.print(s3);
					}
				}
				System.out.println("");
			}
		}
	}
	
	private void generarBloque(String[][] bloque) {
		for (int i = 0; i <= (bloque[0].length - 1) ;i++) {
			bloque[0][i] = "X";
		}
		for (int i = 0; i <= (bloque.length - 1); i++) {
			bloque[i][0] = "X";
			bloque[i][63] = "X";
			for(int x = 1; x < (bloque[i].length - 1); x++) {
				bloque[i][x] = " ";
			}
		}
	}
	
	private void generarBloques(EntidadesJuego entidades) {
		generarBloque(bloqueUno);
		generarBloque(bloqueDos);
		generarBloque(bloqueTres);
		generarBloque(bloqueCuatro);
		
		setEntidadesEnBloques(entidades);
		bloques.add(bloqueUno);
		bloques.add(bloqueDos);
		bloques.add(bloqueTres);
		bloques.add(bloqueCuatro);
	}
	
	public ArrayList<String[][]> getBloques() {
		return bloques;
	}
	
	public void setEntidadesEnBloques(EntidadesJuego entidades) {
		setGuerreroJugadorEnBloque(entidades.getJugador(),bloqueUno);
		setGuerreroJugadorEnBloque(entidades.getJugador2(),bloqueDos);
		setGuerreroEnemigoEnBloquePrimeraFila(entidades.getGuerrerosEnemigos()[0],bloqueUno);
		setNumeroGuerreroPrimeraFila(bloqueUno,1);
		setGuerreroEnemigoEnBloqueSegundaFila(entidades.getGuerrerosEnemigos()[1],bloqueUno);
		setNumeroGuerreroSegundaFila(bloqueUno,2);
		setGuerreroEnemigoEnBloquePrimeraFila(entidades.getGuerrerosEnemigos()[2],bloqueDos);
		setNumeroGuerreroPrimeraFila(bloqueDos,3);
		setGuerreroEnemigoEnBloqueSegundaFila(entidades.getGuerrerosEnemigos()[3],bloqueDos);
		setNumeroGuerreroSegundaFila(bloqueDos,4);
		setGuerreroEnemigoEnBloquePrimeraFila(entidades.getGuerrerosEnemigos()[4],bloqueTres);
		setNumeroGuerreroPrimeraFila(bloqueTres,5);
		setGuerreroEnemigoEnBloqueSegundaFila(entidades.getGuerrerosEnemigos()[5],bloqueTres);
		setNumeroGuerreroSegundaFila(bloqueTres,6);
		setGuerreroEnemigoEnBloquePrimeraFila(entidades.getGuerrerosEnemigos()[6],bloqueCuatro);
		setNumeroGuerreroPrimeraFila(bloqueCuatro,7);
		setGuerreroEnemigoEnBloqueSegundaFila(entidades.getGuerrerosEnemigos()[7],bloqueCuatro);
		setNumeroGuerreroSegundaFila(bloqueCuatro,8);
	}
	
	public void setNumeroGuerreroPrimeraFila(String[][] bloque, int numero) {
		bloque[3][54] = "(" + numero + ")";
		bloque[3][55] = null;
		bloque[3][56] = null;
	}
	
	public void setNumeroGuerreroSegundaFila(String[][] bloque, int numero) {
		bloque[3][59] = "(" + numero + ")";
		bloque[3][60] = null;
		bloque[3][61] = null;
	}
	public void setGuerreroJugadorEnBloque(Guerrero g, String[][] bloque) {
		bloque[0][3] = g.getCuerpo().getCabeza();
		bloque[1][2] = g.getCuerpo().getTorso();
		bloque[1][3] = null;
		bloque[1][4] = null;
		bloque[2][2] = g.getCuerpo().getPiernas();
		bloque[2][3] = null;
		bloque[2][4] = null;
	}
	
	
	
	public void setGuerreroEnemigoEnBloqueSegundaFila(Guerrero g, String[][] bloque) {
		bloque[0][60] = g.getCuerpo().getCabeza();
		bloque[1][59] = g.getCuerpo().getTorso();
		bloque[1][60] = null;
		bloque[1][61] = null;
		bloque[2][59] = g.getCuerpo().getPiernas();
		bloque[2][60] = null;
		bloque[2][61] = null;
		
	}
	
	public void setGuerreroEnemigoEnBloquePrimeraFila(Guerrero g, String[][] bloque) {
		bloque[0][55] = g.getCuerpo().getCabeza();
		bloque[1][54] = g.getCuerpo().getTorso();
		bloque[1][55] = null;
		bloque[1][56] = null;
		bloque[2][54] = g.getCuerpo().getPiernas();
		bloque[2][55] = null;
		bloque[2][56] = null;
		
	}

}
