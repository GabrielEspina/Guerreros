package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;

public class MenuConsola implements IMenu {
	
	

	@Override
	public void mostrarMenuPrincipal() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X             GUERREROS             X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Nuevo Juego                    X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) Ver Records                    X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) Tutorial                       X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 4) Salir                          X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

	@Override
	public void mostrarMenuSeleccion() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X             GUERREROS             X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) SinglePlayer                   X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) MultiPlayer Cooperativo        X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) MultiPlayer Versus             X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 4) Atras                          X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

	

	@Override
	public void mostrarMenuTienda(GuerreroJugador guerrero, EntidadesJuego entidades) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreGuerrero(guerrero));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Tienda Items                   X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) Tienda Habilidades             X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) Asignar Puntos                 X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreNivel(entidades));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}
	
	
	private String printNombreGuerrero(GuerreroJugador guerrero) {
		String s  ="X " + guerrero.getAtributos().getNombre().toUpperCase() + "    Puntos: " + guerrero.getPuntos();
		int cantidadEspacios = 37 - s.length();
		for(int i = 0; i<cantidadEspacios-2;i++) {
			s += " ";
		}
		s += " X";
		return s;
		
	}
	

	private String printNombreNivel(EntidadesJuego entidades) {
		String s  ="X 4) Continuar al nivel: " + entidades.getRound();
		int cantidadEspacios = 37 - s.length();
		for(int i = 0; i<cantidadEspacios-2;i++) {
			s += " ";
		}
		s += " X";
		return s;
		
	}

	@Override
	public void mostrarMenuTiendaItem(GuerreroJugador guerrero) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreGuerrero(guerrero));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Items Activos                  X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) Items Pasivos                  X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) Atras                          X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

	@Override
	public void mostrarMenuTiendaHabilidades(GuerreroJugador guerrero) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreGuerrero(guerrero));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Habilidades Activas            X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) Habilidades Pasivas            X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) Atras                          X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

	@Override
	public void mostrarMenuTiendaHabilidadesActivas(GuerreroJugador guerrero) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Herida sangrante           15P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) Honda Expansiva            15P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) Cortina de Humo            15P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 4) Confusion Inevitable       15P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 5) Atras                          X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
		
	}

	@Override
	public void mostrarMenuTiendaHabilidadesPasivas(GuerreroJugador guerrero) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Golpe Paralizador          15P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) Movimiento Agil            15P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) Golpe Crítico              15P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 4) Atras                          X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

	@Override
	public void mostrarMenuTiendaItemsActivos(GuerreroJugador guerrero) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreGuerrero(guerrero));
		if (guerrero.getItems()[0] == null) {
			System.out.println("X Slot 1) Vacio                     X");
		}else {
			System.out.println(this.printNombreItem(0,guerrero));
		}
		
		if (guerrero.getItems()[1] == null) {
			System.out.println("X Slot 2) Vacio                     X");
		}else {
			System.out.println(this.printNombreItem(1,guerrero));
		}
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Guantes de Ataque +3       10P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) Guantes de Ataque +5       15P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) Bomba                      10P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 4) Gran Bomba                 15P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 5) Atras                          X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}
	
	private String printNombreItem(int item, GuerreroJugador guerrero) {
		
		String s  ="X " + (item+1) + ")" + guerrero.getItems()[item].getNombre();
		int cantidadEspacios = 37 - s.length();
		for(int i = 0; i<cantidadEspacios-2;i++) {
			s += " ";
		}
		s += " X";
		return s;
	}

	@Override
	public void mostrarMenuTiendaItemsPasivos(GuerreroJugador guerrero) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreGuerrero(guerrero));
		if (guerrero.getItems()[0] == null) {
			System.out.println("X Slot 1) Vacio                     X");
		}else {
			System.out.println(this.printNombreItem(0,guerrero));
		}
		
		if (guerrero.getItems()[1] == null) {
			System.out.println("X Slot 2) Vacio                     X");
		}else {
			System.out.println(this.printNombreItem(1,guerrero));
		}
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1)    Anillo de Ataque         5P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2)    Anillo de Defensa        5P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3)    Anillo de Presicion      5P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 4)    Anillo de Energia        5P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 5)         Atras                  X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

	@Override
	public void mostrarMenuAsignacionDePuntos(GuerreroJugador guerrero) {
		System.out.println("Puntos restantes =" + guerrero.getPuntos());
		System.out.println("----------------------------");
		System.out.println("1) Ataque ->\t"     + guerrero.getAtributos().getAtaque());
		System.out.println("2) Defensa ->\t"    + guerrero.getAtributos().getDefensa());
		System.out.println("3) Presicion ->\t"  + guerrero.getAtributos().getPresicion());
		System.out.println("4) Vida ->\t"       + guerrero.getAtributos().getVida());
		System.out.println("5) Energia ->\t"    + guerrero.getAtributos().getEnergia());
		System.out.println("----------------------------");
		System.out.println("6) Regresar");
		System.out.println("Seleccionar campo a asignar");
		
	}

	@Override
	public void mostrarMenuCreacionPersonaje() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X         Ingresar Nombre           X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

}
