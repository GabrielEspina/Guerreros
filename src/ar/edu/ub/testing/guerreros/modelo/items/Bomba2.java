package ar.edu.ub.testing.guerreros.modelo.items;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public class Bomba2 extends ItemActivo{
	
	private Guerrero jugador;

	public Bomba2(Guerrero jugador) {
		this.setEnergiaNecesaria(6);
		this.setNombre("Gran Bomba" + "(" + this.getEnergiaNecesaria() +  ")");
		this.setDescripcion("Ataca a cuatro enemigos(-7 daño)");
		this.setPrecio(15);
	}
	
	public void setDueño(Guerrero jugador) {
		this.jugador = jugador;
	}
	
	@Override
	public void desactivarAccion() {
		jugador.getAtributos().setAtaque(this.getAtributoOriginal());
	}



	@Override
	public String ejecutarAccionActiva(EntidadesJuego entidades, int objetivo) {
		this.setAtributoOriginal(jugador.getAtributos().getAtaque());
		this.jugador.getAtributos().setAtaque(jugador.getAtributos().getAtaque() - 5);
		this.jugador.atacar(entidades.getGuerrerosEnemigos()[objetivo]);
		atacarEnemigosCercanos(entidades,objetivo);
		desactivarAccion();
		return " " + jugador.getAtributos().getNombre() + " lanza una bomba";
	}
	
	public void atacarEnemigosCercanos(EntidadesJuego entidades, int objetivo) {
		int ataques = 3;
		for (int i = 0; i < entidades.getGuerrerosEnemigos().length; i++) {
			if(ataques > 0 && entidades.getGuerrerosEnemigos()[i] != entidades.getGuerrerosEnemigos()[objetivo] && !(entidades.getGuerrerosEnemigos()[i].murio()) ) {
				jugador.atacar(entidades.getGuerrerosEnemigos()[i]);
				ataques--;
			}
		}
	}
	
}
