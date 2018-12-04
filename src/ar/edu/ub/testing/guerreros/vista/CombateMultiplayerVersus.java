package ar.edu.ub.testing.guerreros.vista;


import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public class CombateMultiplayerVersus implements IVista{
	
	private String[][]            bloque = new String[4][64];
	
	public CombateMultiplayerVersus(EntidadesJuego entidades) {
		generarBloques(entidades);
	}
	
	
	private void generarBloques(EntidadesJuego entidades) {
		generarBloque(bloque);
		setEntidadesEnBloques(entidades);
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
	public void setGuerreroJugador2EnBloque(Guerrero g, String[][] bloque) {
		bloque[0][60] = g.getCuerpo().getCabeza();
		bloque[1][59] = g.getCuerpo().getTorso();
		bloque[1][60] = null;
		bloque[1][61] = null;
		bloque[2][59] = g.getCuerpo().getPiernas();
		bloque[2][60] = null;
		bloque[2][61] = null;
		
	}
	
	public void setEntidadesEnBloques(EntidadesJuego entidades) {
		setGuerreroJugadorEnBloque(entidades.getJugador(),bloque);
		setGuerreroJugador2EnBloque(entidades.getJugador2(),bloque);

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
	
	@Override
	public void print() {
		for (String[] s2 : bloque) {
			for (String s3 : s2) {
				if (s3 != null) {
				System.out.print(s3);
				}
			}
			System.out.println("");
		}
	}

}
