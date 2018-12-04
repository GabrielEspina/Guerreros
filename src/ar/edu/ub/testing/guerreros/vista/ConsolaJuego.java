package ar.edu.ub.testing.guerreros.vista;

public class ConsolaJuego implements IVista{
	
	private String     cabezera = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private String[][] consola = new String[4][3];
	
	public ConsolaJuego() {
		construirConsola();
	}

	@Override
	public void print() {
		System.out.println(cabezera);
		for (String[] s : consola) {
			System.out.print(s[0]);
			printMensaje(s[1]);
			System.out.print(s[2]);
			System.out.println("");
		}
		System.out.println(cabezera);
	}
	
	public void actualizarConsola(String mensaje) {
		consola[0][1] = consola[1][1];
		consola[1][1] = consola[2][1];
		consola[2][1] = consola[3][1];
 		consola[3][1] = mensaje;
	}
	
	public void construirConsola() {
		for (int i = 0; i < consola.length; i++) {
			consola[i][0] = "X";
			consola[i][1] = " ";
			consola[i][2] = "X";
		}
	}
	
	public void printMensaje(String s) {
		int cantidad = 62-(s.length() + 1);
		System.out.print(s);
		for(int i = 0; i <= cantidad; i++ ) {
			System.out.print(" ");
		}
	}
	
	public void limpiarConsola() {
		consola[0][1] = " ";
		consola[1][1] = " ";
		consola[2][1] = " ";
 		consola[3][1] = " ";
	}
}
