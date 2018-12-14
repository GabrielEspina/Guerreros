package ar.edu.ub.testing.guerreros.modelo.items;


import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public class Bomba1 extends ItemActivo{


	public Bomba1(Guerrero jugador) {
		this.setJugador(jugador);
		this.setEnergiaNecesaria(7);
		this.setNombre("Bomba" + "(" + this.getEnergiaNecesaria() +  ")");
		this.setDescripcion("Ataca a dos enemigos(-5 daño)");
		this.setPrecio(20);
	}
	
	public void setDueño(Guerrero jugador) {
	}
	
	@Override
	public void desactivarAccion() {
		getJugador().getAtributos().setAtaque(this.getAtributoOriginal());
	}


	@Override
	public String ejecutarAccionActiva(EntidadesJuego entidades, int objetivo) {
		this.setAtributoOriginal(getJugador().getAtributos().getAtaque());
		this.getJugador().getAtributos().setAtaque(getJugador().getAtributos().getAtaque() - 5);
		this.getJugador().atacar(entidades.getGuerrerosEnemigos()[objetivo]);
		atacarEnemigosCercanos(entidades,objetivo);
		desactivarAccion();
		return " " + getJugador().getAtributos().getNombre() + " lanza una bomba";
	}
	
	public void atacarEnemigosCercanos(EntidadesJuego entidades, int objetivo) {
		int ataques = 1;
		for (int i = 0; i < entidades.getGuerrerosEnemigos().length; i++) {
			if(ataques > 0 && entidades.getGuerrerosEnemigos()[i] != entidades.getGuerrerosEnemigos()[objetivo] && !(entidades.getGuerrerosEnemigos()[i].murio()) ) {
				getJugador().atacar(entidades.getGuerrerosEnemigos()[i]);
				ataques--;
			}
		}
	}
	

}
