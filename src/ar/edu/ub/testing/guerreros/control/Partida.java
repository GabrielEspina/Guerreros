package ar.edu.ub.testing.guerreros.control;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.testing.guerreros.control.interfaces.IControlDeFlujo;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.habilidades.Habilidad15PorcParalizarDosTurnos;
import ar.edu.ub.testing.guerreros.modelo.habilidades.Habilidad20PorcEvadirAtaque;
import ar.edu.ub.testing.guerreros.modelo.habilidades.Habilidad25PorcDobleDanio;
import ar.edu.ub.testing.guerreros.modelo.habilidades.HabilidadDaniarEnemigoCincoTurnos;
import ar.edu.ub.testing.guerreros.modelo.habilidades.HabilidadDaniarEnemigos;
import ar.edu.ub.testing.guerreros.modelo.habilidades.HabilidadEnemigoFallaAtaque;
import ar.edu.ub.testing.guerreros.modelo.habilidades.HabilidadEnemigosPierdenTurno;
import ar.edu.ub.testing.guerreros.modelo.habilidades.IHabilidad;
import ar.edu.ub.testing.guerreros.modelo.habilidades.IHabilidadActiva;
import ar.edu.ub.testing.guerreros.modelo.habilidades.IHabilidadPasiva;
import ar.edu.ub.testing.guerreros.modelo.items.AnilloDeAtaque;
import ar.edu.ub.testing.guerreros.modelo.items.AnilloDeDefensa;
import ar.edu.ub.testing.guerreros.modelo.items.AnilloDeEnergia;
import ar.edu.ub.testing.guerreros.modelo.items.AnilloDePresicion;
import ar.edu.ub.testing.guerreros.modelo.items.Bomba1;
import ar.edu.ub.testing.guerreros.modelo.items.Bomba2;
import ar.edu.ub.testing.guerreros.modelo.items.GuantesDeAtaque1;
import ar.edu.ub.testing.guerreros.modelo.items.GuantesDeAtaque2;
import ar.edu.ub.testing.guerreros.modelo.items.Item;
import ar.edu.ub.testing.guerreros.modelo.items.ItemActivo;
import ar.edu.ub.testing.guerreros.modelo.items.ItemPasivo;

public abstract class Partida implements IPartida {
	
	EntidadesJuego entidades;
	private Map<Integer,IHabilidadActiva> habilidadesActivas = new HashMap<>();
	private Map<Integer,IHabilidadPasiva> habilidadesPasivas = new HashMap<>();
	private Map<Integer,ItemPasivo> itemsPasivos = new HashMap<>();
	private Map<Integer,ItemActivo> itemsActivos = new HashMap<>();

	public Partida(EntidadesJuego entidadesExternas) {
		
		this.entidades = entidadesExternas;
		
		
	}
	
	private Map<Integer,IHabilidadActiva> crearHabilidadesActivas() {
		Map<Integer,IHabilidadActiva> habilidadesActivas = new HashMap<>();;
		
		habilidadesActivas.put(4, new HabilidadEnemigosPierdenTurno());
		habilidadesActivas.put(3, new HabilidadEnemigoFallaAtaque());
		habilidadesActivas.put(2, new HabilidadDaniarEnemigos());
		habilidadesActivas.put(1, new HabilidadDaniarEnemigoCincoTurnos());
		return habilidadesActivas;
		
	}
	private Map<Integer,IHabilidadPasiva> crearHabilidadesPasivas() {
		Map<Integer,IHabilidadPasiva> habilidadesPasivas = new HashMap<>();;
		habilidadesPasivas.put(3, new Habilidad25PorcDobleDanio());
		habilidadesPasivas.put(2, new Habilidad20PorcEvadirAtaque());
		habilidadesPasivas.put(1, new Habilidad15PorcParalizarDosTurnos());
		return habilidadesPasivas;
	}
	
	
	private Map<Integer,ItemPasivo> crearItemsPasivos(GuerreroJugador guerrero) {
		Map<Integer,ItemPasivo> itemsPasivos = new HashMap<>();
		itemsPasivos.put(1, new AnilloDeAtaque(guerrero));
		itemsPasivos.put(2, new AnilloDeDefensa(guerrero));
		itemsPasivos.put(3, new AnilloDePresicion(guerrero));
		itemsPasivos.put(4, new AnilloDeEnergia(guerrero));
		
		return itemsPasivos;
	}
	
	private Map<Integer,ItemActivo> crearItemsActivos(GuerreroJugador guerrero) {
		Map<Integer,ItemActivo> itemsActivos = new HashMap<>();
		
		itemsActivos.put(1, new GuantesDeAtaque1(guerrero));
		itemsActivos.put(2, new GuantesDeAtaque2(guerrero));
		itemsActivos.put(3, new Bomba1(guerrero));
		itemsActivos.put(4, new Bomba2(guerrero));

		
		return itemsActivos;
	}
	
	private void crearElementosDeTienda(GuerreroJugador guerrero) {
		
		setHabilidadesActivas(crearHabilidadesActivas());
		setHabilidadesPasivas(crearHabilidadesPasivas());
		setItemsActivos(crearItemsActivos(guerrero));
		setItemsPasivos(crearItemsPasivos(guerrero));
	}
	
	public void activarPasivos() {
		if (entidades.getJugador() != null)
		//entidades.getJugador().activarItemsPasivos();
		if (entidades.getJugador2() != null) {}
		//entidades.getJugador2().activarItemsPasivos();
	}
	
	public void desactivarPasivos() {
		if (entidades.getJugador() != null)
		//entidades.getJugador().desactivarItemsPasivos();
		if (entidades.getJugador2() != null) {}
		//entidades.getJugador2().desactivarItemsPasivos();
	}
	
	public EntidadesJuego getEntidades() {
		return this.entidades;
	}
	
	private Map<Integer, IControlDeFlujo> generarMenusTienda(GuerreroJugador guerrero, EntidadesJuego entidades) {
		Map<Integer, IControlDeFlujo> menus = new HashMap<>(); 
		menus.put(0, new MenuTienda(guerrero,getEntidades()));
		menus.put(1, new MenuItems(guerrero,getEntidades()));
		menus.put(2, new MenuItemsActivos(guerrero,getEntidades()));
		menus.put(3, new MenuItemsPasivos(guerrero,getEntidades()));
		menus.put(4, new MenuHabilidades(guerrero,getEntidades()));
		menus.put(5, new MenuHabilidadesActivas(guerrero,getEntidades()));
		menus.put(6, new MenuHabilidadesPasivas(guerrero,getEntidades()));
		menus.put(7, new MenuAsignacion(guerrero,getEntidades()));
		menus.put(8, new MenuCompraItem());
		menus.put(9, new MenuCompraHabilidad());
		
		return menus;
	}
	
	public void tienda(GuerreroJugador guerrero) {
		crearElementosDeTienda(guerrero);
		Map<Integer, IControlDeFlujo> menus = generarMenusTienda(guerrero, getEntidades());
		menuPrincipalTienda(menus,guerrero);
	}
	
	private void menuPrincipalTienda(Map<Integer, IControlDeFlujo> menus,GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		menus.get(0).ir();
		int eleccion = Consola.pedirNumero(1,4);
		switch(eleccion) {
		case 1:
			menuTiendaItems(menus,guerrero);
			break;
		case 2:
			menuTiendaHabilidades(menus,guerrero);
			break;
		case 3:
			menuTiendaAsignacion(menus,guerrero);
			break;
		case 4:
			break;
		}
	}
	
	private void menuTiendaItems(Map<Integer, IControlDeFlujo> menus,GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		menus.get(1).ir();
		int eleccion = Consola.pedirNumero(1,3);
		switch(eleccion) {
		case 1:
			menuTiendaItemsActivos(menus,guerrero);
			break;
		case 2:
			menuTiendaItemsPasivos(menus,guerrero);
			break;
		case 3:
			menuPrincipalTienda(menus,guerrero);
			break;
		}
	}
	
	private void menuTiendaItemsActivos(Map<Integer, IControlDeFlujo> menus,GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		menus.get(3).ir();
		int eleccion = Consola.pedirNumero(1, 5);
		if (eleccion <= 4) {
			MenuCompraItem menuCompra = new MenuCompraItem();
			menuCompra.setItem(this.getItemsPasivos().get(eleccion));
			menuCompra.ir();
			int confirmacion = Consola.pedirNumero(1, 2);
			if (confirmacion == 1) {
				
			}
		}
		
		
	}
	
	private void menuTiendaItemsPasivos(Map<Integer, IControlDeFlujo> menus,GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		menus.get(3).ir();
		int eleccion = Consola.pedirNumero(1, 5);
		if (eleccion <= 4) {
			MenuCompraItem menuCompra = new MenuCompraItem();
			menuCompra.setItem(this.getItemsPasivos().get(eleccion));
			menuCompra.ir();
			int confirmacion = Consola.pedirNumero(1, 2);
			if (confirmacion == 1) {
				
			}
		}
		
	}
	
	private void menuTiendaHabilidades(Map<Integer, IControlDeFlujo> menus,GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		menus.get(4).ir();
		int eleccion = Consola.pedirNumero(1,3);
		switch(eleccion) {
		case 1:
			menuTiendaHabilidadesActivas(menus,guerrero);
			break;
		case 2:
			menuTiendaHabilidadesPasivas(menus,guerrero);
			break;
		case 3:
			menuPrincipalTienda(menus,guerrero);
			break;
		}
		
	}
	
	private void menuTiendaHabilidadesPasivas(Map<Integer, IControlDeFlujo> menus,GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		menus.get(6).ir();
		int eleccion = Consola.pedirNumero(1, 4);
		if (eleccion <= 3) {
			MenuCompraHabilidad menuCompra = new MenuCompraHabilidad();
			menuCompra.setHabilidad(this.getHabilidadesPasivas().get(eleccion));
			Consola.limpiarConsola();
			menuCompra.ir();
			int confirmacion = Consola.pedirNumero(1, 2);
			if (confirmacion == 1) {
				compraHabilidad(guerrero,this.getHabilidadesPasivas().get(eleccion));
			}
			menuTiendaHabilidadesPasivas(menus,guerrero);
		}else {
			menuTiendaHabilidades(menus,guerrero);
		}

	}
	
	private void menuTiendaHabilidadesActivas(Map<Integer, IControlDeFlujo> menus,GuerreroJugador guerrero) {
		Consola.limpiarConsola();
		menus.get(5).ir();
		int eleccion = Consola.pedirNumero(1, 5);
		if (eleccion <= 4) {
			MenuCompraHabilidad menuCompra = new MenuCompraHabilidad();
			menuCompra.setHabilidad(this.getHabilidadesActivas().get(eleccion));
			Consola.limpiarConsola();
			menuCompra.ir();
			int confirmacion = Consola.pedirNumero(1, 2);
			if (confirmacion == 1) {
				compraHabilidad(guerrero,this.getHabilidadesActivas().get(eleccion));
			}
			menuTiendaHabilidadesActivas(menus,guerrero);
		}else {
			menuTiendaHabilidades(menus,guerrero);
		}
	}
	
	private void menuTiendaAsignacion(Map<Integer, IControlDeFlujo> menus, GuerreroJugador guerrero) {
		
		Consola.limpiarConsola();
		menus.get(7).ir();
		int eleccion = Consola.pedirNumero(1,6);
		System.out.println("Ingrese cantidad: ");
		switch(eleccion) {
		case 1:
			int puntosAtaque = pedirAsignacion(guerrero);
			guerrero.setPuntos(guerrero.getPuntos() - puntosAtaque);
			guerrero.getAtributos().setAtaque(guerrero.getAtributos().getAtaque() + puntosAtaque);
			menuTiendaAsignacion(menus,guerrero);
			break;
		case 2:
			int puntosDefensa = pedirAsignacion(guerrero);
			guerrero.setPuntos(guerrero.getPuntos() - puntosDefensa);
			guerrero.getAtributos().setDefensa(guerrero.getAtributos().getDefensa() + puntosDefensa);
			menuTiendaAsignacion(menus,guerrero);
			break;
		case 3:
			int puntosPresicion = pedirAsignacion(guerrero);
			guerrero.setPuntos(guerrero.getPuntos() - puntosPresicion);
			guerrero.getAtributos().setPresicion(guerrero.getAtributos().getPresicion() + puntosPresicion);
			menuTiendaAsignacion(menus,guerrero);
			break;
		case 4:
			int puntosVida = pedirAsignacion(guerrero);
			guerrero.setPuntos(guerrero.getPuntos() - puntosVida);
			guerrero.getAtributos().setVida(guerrero.getAtributos().getVida() + puntosVida);
			menuTiendaAsignacion(menus,guerrero);
			break;
		case 5:
			int puntosEnergia = pedirAsignacion(guerrero);
			guerrero.setPuntos(guerrero.getPuntos() - puntosEnergia);
			guerrero.getAtributos().setEnergia(guerrero.getAtributos().getEnergia() + puntosEnergia);
			menuTiendaAsignacion(menus,guerrero);
			break;
		case 6:
			menuPrincipalTienda(menus,guerrero);
			break;
		}
	}
	
	private boolean verificarAsignacion(int puntos, int puntosAsignados) {
		return puntos >= puntosAsignados;
	}
	
	private int pedirAsignacion(GuerreroJugador guerrero) {
		int puntos = Consola.pedirNumero();
		if (verificarAsignacion(guerrero.getPuntos(), puntos)) {
			return puntos;
		}else {
			System.out.println("Puntos insuficientes");
			return pedirAsignacion(guerrero);
		}
	
	}
	
	public void compraItem(Item item, GuerreroJugador guerrero) {
		if (verificarAsignacion(guerrero.getPuntos() , item.getPrecio())) {
			
		}
	}
	
	public void compraHabilidad(GuerreroJugador guerrero,IHabilidad habilidad) {
		if (verificarAsignacion(guerrero.getPuntos() , 15)) {
			guerrero.setPuntos(guerrero.getPuntos() - 15);
			guerrero.setHabilidad(habilidad);
		}else {
			System.out.println("Puntos insuficientes");
		}
	}
	
	public void compraItem(GuerreroJugador guerrero,Item item) {
		if (verificarAsignacion(guerrero.getPuntos() , item.getPrecio())) {
			guerrero.setPuntos(guerrero.getPuntos() - item.getPrecio());
		}else {
			System.out.println("Puntos insuficientes");
		}
	}
	
	public Map<Integer,IHabilidadActiva> getHabilidadesActivas() {
		return habilidadesActivas;
	}

	public void setHabilidadesActivas(Map<Integer,IHabilidadActiva> habilidadesActivas) {
		this.habilidadesActivas = habilidadesActivas;
	}

	public Map<Integer,IHabilidadPasiva> getHabilidadesPasivas() {
		return habilidadesPasivas;
	}

	public void setHabilidadesPasivas(Map<Integer,IHabilidadPasiva> habilidadesPasivas) {
		this.habilidadesPasivas = habilidadesPasivas;
	}

	public Map<Integer,ItemPasivo> getItemsPasivos() {
		return itemsPasivos;
	}

	public void setItemsPasivos(Map<Integer,ItemPasivo> itemsPasivos) {
		this.itemsPasivos = itemsPasivos;
	}

	public Map<Integer,ItemActivo> getItemsActivos() {
		return itemsActivos;
	}

	public void setItemsActivos(Map<Integer,ItemActivo> itemsActivos) {
		this.itemsActivos = itemsActivos;
	}
}
