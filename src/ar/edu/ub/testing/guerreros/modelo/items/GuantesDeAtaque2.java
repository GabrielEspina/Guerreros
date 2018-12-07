package ar.edu.ub.testing.guerreros.modelo.items;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public class GuantesDeAtaque2 extends ItemActivo{
	

	public GuantesDeAtaque2(Guerrero jugador) {
		this.setEnergiaNecesaria(5);
		this.setNombre("Guantes de Ataque +5"  + "(" + this.getEnergiaNecesaria() +  ")");
		this.setDescripcion("Aumenta el ataque en +5");
		this.setPrecio(15);
	}
	
	

	@Override
	public String ejecutarAccionActiva(EntidadesJuego entidades, int objetivo) {
		this.setAtributoOriginal(getJugador().getAtributos().getAtaque());
		getJugador().getAtributos().setAtaque(getJugador().getAtributos().getAtaque() + 5);
		getJugador().atacar(entidades.getGuerrerosEnemigos()[objetivo]);
		desactivarAccion();
		return " " + getJugador().getAtributos().getNombre() + " aumenta su daño en +5 con guantes de ataque";
	}

	@Override
	public void desactivarAccion() {
		getJugador().getAtributos().setAtaque(this.getAtributoOriginal());
	}



}
