package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;

public class VistaCombateSingleplayer extends Vista{
	
	private CombateSingleplayer combate;
	private ConsolaJuego consola;
	private Cabezera cabezera;
	
	public VistaCombateSingleplayer(EntidadesJuego entidades) {
		
		combate = new CombateSingleplayer(entidades);
		consola = new ConsolaJuego();
		cabezera = new CabezeraSingleplayer(entidades);
		
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
	combate = new CombateSingleplayer(entidades);
	cabezera = new CabezeraSingleplayer(entidades);
	}
}
