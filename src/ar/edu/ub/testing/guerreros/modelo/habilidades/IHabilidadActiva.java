package ar.edu.ub.testing.guerreros.modelo.habilidades;



import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;


public interface IHabilidadActiva extends IHabilidad{
	
	
	public void ejecutar(Guerrero jugador, GuerreroEnemigo[] enemigos);

}
