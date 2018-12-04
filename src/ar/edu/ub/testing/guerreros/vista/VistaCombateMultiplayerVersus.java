package ar.edu.ub.testing.guerreros.vista;


import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;

public class VistaCombateMultiplayerVersus extends Vista{
	
	private CombateMultiplayerVersus combate;
	private ConsolaJuego consola;
	private CabezeraMultiplayerVersus cabezera;
	
	public VistaCombateMultiplayerVersus(EntidadesJuego entidades) {
		combate = new CombateMultiplayerVersus(entidades);
		consola = new ConsolaJuego();
		cabezera = new CabezeraMultiplayerVersus(entidades);
	}
	
	public void mostrarMensajeEnConsola(String mensaje) {
		consola.actualizarConsola(mensaje);
	}
	public void limpiarConsola() {
		consola.limpiarConsola();
	}
	public void print(EntidadesJuego entidades) {
		UtilidadesConsola.limpiarConsola();
		actualizarEntidades(entidades);
		cabezera.print();
		combate.print();
		consola.print();
		
	}
	
	public void actualizarEntidades(EntidadesJuego entidades) {
	combate = new CombateMultiplayerVersus(entidades);
	cabezera = new CabezeraMultiplayerVersus(entidades);
	}

}
