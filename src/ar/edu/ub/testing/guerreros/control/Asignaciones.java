package ar.edu.ub.testing.guerreros.control;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosAtaque;
import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosDefensa;
import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosEnergia;
import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosPresicion;
import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosVida;
import ar.edu.ub.testing.guerreros.control.asignacion.AsignacionPuntosException;
import ar.edu.ub.testing.guerreros.control.interfaces.IAsignacionPuntos;
import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.excepciones.AsignacionesNoEncontradasException;
import ar.edu.ub.testing.guerreros.excepciones.JugadorNoEncontradoException;
import ar.edu.ub.testing.guerreros.excepciones.MenuNoEncontradoException;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class Asignaciones {
	
	private Map<Integer,IAsignacionPuntos> asignaciones;
	
	public Asignaciones(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		
		setAsignaciones( new HashMap<>() );
		generarAsignaciones(menus,guerrero);
		
	}
	
	public IAsignacionPuntos traer(Integer key) {
		
		return checkAsignacion( getAsignaciones().get(key) );
	}

	private IAsignacionPuntos checkAsignacion(IAsignacionPuntos asignacion)throws AsignacionesNoEncontradasException {
		
		//CHECKEAR ACA ALGO PARA LANZAR LA EXCEPTION CORRESPONDIENTE
		return asignacion;
		
	}

	private void generarAsignaciones(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		
		   
			try{
				
				checkMenus(menus) ;
				checkGuerrero(guerrero) ;
				
				getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosAtaque(menus,guerrero));
				getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosDefensa(menus,guerrero));
				getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosPresicion(menus,guerrero));
				getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosVida(menus,guerrero));
				getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosEnergia(menus,guerrero));
				getAsignaciones().put( getAsignaciones().size()+1 , new AsignacionPuntosException(menus,guerrero));
				
			}catch( AsignacionesNoEncontradasException ane ) {
				
				Consola.imprimirMensaje( ane.getMessage() );
				
			}
			catch( MenuNoEncontradoException mne ) {
				
				Consola.imprimirMensaje( mne.getMessage() );
				
			}
			catch( JugadorNoEncontradoException jne ) {
				
				Consola.imprimirMensaje( jne.getMessage() );
				
			}
		 
		
		

	}

	private void checkGuerrero(GuerreroJugador guerrero) throws JugadorNoEncontradoException {
		if( guerrero==null )
			throw new JugadorNoEncontradoException();
	}

	private void checkMenus(Map<Integer, IControlDeFlujo> menus)throws MenuNoEncontradoException {
		if(menus==null)
			throw new MenuNoEncontradoException();
	}

	private Map<Integer,IAsignacionPuntos> getAsignaciones() {
		return asignaciones;
	}

	private void setAsignaciones(Map<Integer,IAsignacionPuntos> asignaciones) {
		this.asignaciones = asignaciones;
	}

}
