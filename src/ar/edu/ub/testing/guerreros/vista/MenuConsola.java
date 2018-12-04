package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerreros.control.interfaces.IMenu;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.habilidades.IHabilidad;
import ar.edu.ub.testing.guerreros.modelo.items.Item;

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
		System.out.println(printNombreGuerrero(guerrero));
		if (guerrero.getHabilidad() == null) {
			System.out.println("X H = Vacia                         X");
		}else {
			System.out.println(mostrarNombreHabilidad(guerrero));
		}
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
		System.out.println(printNombreGuerrero(guerrero));
		if (guerrero.getHabilidad() == null) {
			System.out.println("X H = Vacia                         X");
		}else {
			System.out.println(mostrarNombreHabilidad(guerrero));
		}
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
			System.out.println(this.mostrarNombreItem(0,guerrero));
		}
		
		if (guerrero.getItems()[1] == null) {
			System.out.println("X Slot 2) Vacio                     X");
		}else {
			System.out.println(this.mostrarNombreItem(1,guerrero));
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
	
	private String mostrarNombreItem(int item, GuerreroJugador guerrero) {
		
		String s  ="X " + (item+1) + ")" + guerrero.getItems()[item].getNombre();
		int cantidadEspacios = 37 - s.length();
		for(int i = 0; i<cantidadEspacios-2;i++) {
			s += " ";
		}
		s += " X";
		return s;
	}
	
	private String mostrarNombreHabilidad(GuerreroJugador guerrero) {
		
		String s  ="X " + guerrero.getHabilidad().nombre();
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
			System.out.println(this.mostrarNombreItem(0,guerrero));
		}
		
		if (guerrero.getItems()[1] == null) {
			System.out.println("X Slot 2) Vacio                     X");
		}else {
			System.out.println(this.mostrarNombreItem(1,guerrero));
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
	public void mostrarMenuCreacionPersonaje() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X         Ingresar Nombre           X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X                o                  X");
		System.out.println("X               /|\\                 X");
		System.out.println("X               / \\                 X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}
	
	@Override
	public void mostrarMenuAsignacionDePuntos(GuerreroJugador guerrero) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreGuerrero(guerrero));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(mostrarMenuAtributos(guerrero.getAtributos().getAtaque(), "Ataque", 1));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(mostrarMenuAtributos(guerrero.getAtributos().getDefensa(), "Defensa", 2));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(mostrarMenuAtributos(guerrero.getAtributos().getPresicion(), "Presicion", 3));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(mostrarMenuAtributos(guerrero.getAtributos().getVida(), "Vida", 4));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(mostrarMenuAtributos(guerrero.getAtributos().getEnergia(), "Energia", 5));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 6) REGRESAR                       X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("Seleccione atributo a mejorar:       ");

		
	}
	
	public String mostrarMenuAtributos(int atributo, String nombreAtributo, int posicion) {
		String s  ="X " + posicion + ") " + nombreAtributo + " = " + atributo;
		int cantidadEspacios = 37 - s.length();
		for(int i = 0; i<cantidadEspacios-2;i++) {
			s += " ";
		}
		s += " X";
		return s;
		
	}
	
	public String mostrarElemento(String elemento) {
		
		String s  ="X " + elemento;
		int cantidadEspacios = 37 - s.length();
		for(int i = 0; i<cantidadEspacios-2;i++) {
			s += " ";
		}
		s += " X";
		return s;
	}
	
	@Override
	public void mostrarMenuCompraItem(Item item) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X NOMBRE:                           X");
		System.out.println(mostrarElemento(item.getNombre()));
		System.out.println("X DESCRIPCION:                      X");
		System.out.println(mostrarElemento(item.getDescripcion()));
		System.out.println("X PRECIO:                           X");
		System.out.println(mostrarElemento(Integer.toString(item.getPrecio())));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Confirmar           2)Cancelar X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}
	
	@Override
	public void mostrarMenuCompraHabilidad(IHabilidad item) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X NOMBRE:                           X");
		System.out.println(mostrarElemento(item.nombre()));
		System.out.println("X DESCRIPCION:                      X");
		System.out.println(mostrarElemento(item.descripcion()));
		System.out.println("X PRECIO:                           X");
		System.out.println("X 15                                X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Confirmar           2)Cancelar X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

	
		
}


