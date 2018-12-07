package ar.edu.ub.testing.guerreros.modelo;

public class GuerreroEnemigo extends Guerrero {
	
	private boolean turnoPausado;
	private int contTurnosPausados;
	
	public GuerreroEnemigo() {
		super();
		this.getAtributos().setAtaque(4);
		this.getAtributos().setDefensa(4);
		this.getAtributos().setEnergia(4);
		this.getAtributos().setPresicion(4);
		this.getAtributos().setVida(10);
	}
	
	public void nockear(int pausarTurnos) {
		setTurnoPausado(true);
		setContTurnosPausados(pausarTurnos);
	}

	public boolean checkNocked() {
		if (this.getContTurnosPausados() == 0) {
			this.setTurnoPausado(false);
		}
		this.setContTurnosPausados(this.getContTurnosPausados()-1);
		return this.isTurnoPausado();
	}
	
	public boolean checkEnemigoNoDisponible(){
		return (this.checkNocked() || this.murio());
	}
	
	public boolean isTurnoPausado() {
		return turnoPausado;
	}

	public void setTurnoPausado(boolean turnoPausado) {
		this.turnoPausado = turnoPausado;
	}

	public int getContTurnosPausados() {
		return contTurnosPausados;
	}

	public void setContTurnosPausados(int contTurnosPausados) {
		this.contTurnosPausados = contTurnosPausados;
	}
	
	
}
