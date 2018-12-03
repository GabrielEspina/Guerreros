package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.modelo.habilidades.IHabilidad;

public class MenuCompraHabilidad extends MenuRaiz{
	
	private IHabilidad habilidad;
	
	public void setHabilidad(IHabilidad habilidad) {
		this.habilidad = habilidad;
	}

	@Override
	public void ir() {
		MENU.menuCompraHabilidad(habilidad);
	}

}