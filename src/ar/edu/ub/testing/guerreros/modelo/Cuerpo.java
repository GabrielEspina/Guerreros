package ar.edu.ub.testing.guerreros.modelo;

public class Cuerpo {
	
	private String cabeza =    "o";
	private String torso =    "/|\\";
	private String piernas =  "/ \\";
	
	
	public String getCabeza() {
		return cabeza;
	}
	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}
	public String getTorso() {
		return torso;
	}
	public void setTorso(String torso) {
		this.torso = torso;
	}

	public String getPiernas() {
		return piernas;
	}
	public void setPiernas(String piernas) {
		this.piernas = piernas;
	}
	
	public void setCuerpoMuerto() {
		this.setCabeza ("o");
		this.setTorso  ("/X\\");
		this.setPiernas("!! ");

	}
	
	public Cuerpo cuerpoFalso() {
		Cuerpo cuerpoFalso = new Cuerpo();
		return cuerpoFalso;

	}
}
