package ar.edu.ub.testing.guerreros.modelo.items;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public class GuantesDeAtaque1 extends ItemActivo{

	public GuantesDeAtaque1(Guerrero jugador) {
		this.setEnergiaNecesaria(3);
		this.setNombre("Guantes de Ataque + 3"  + "(" + this.getEnergiaNecesaria() +  ")");
		this.setDescripcion("Aumenta el ataque en +3");
		this.setPrecio(10);
	}
	
	
	
	@Override
	public String ejecutarAccionActiva(EntidadesJuego entidades, int objetivo) {
		this.setAtributoOriginal(getJugador().getAtributos().getAtaque());
		getJugador().getAtributos().setAtaque(getJugador().getAtributos().getAtaque() + 3);
		getJugador().atacar(entidades.getGuerrerosEnemigos()[objetivo]);
		desactivarAccion();
		return " " + getJugador().getAtributos().getNombre() + " aumenta su daño en +3 con guantes de ataque";
	}

	@Override
	public void desactivarAccion() {
		getJugador().getAtributos().setAtaque(this.getAtributoOriginal());
	}




}
