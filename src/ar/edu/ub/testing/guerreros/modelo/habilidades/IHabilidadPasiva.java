package ar.edu.ub.testing.guerreros.modelo.habilidades;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public interface IHabilidadPasiva extends IHabilidad{
	
	public boolean probar();
	
	public void ejecutar(Guerrero jugador);
	
}
