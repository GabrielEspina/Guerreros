package ar.edu.ub.testing.guerreros.modelo.items;

import ar.edu.ub.testing.guerreros.modelo.Guerrero;

public abstract class Item {
	
	public Item() {
		
	}
	
	
	private String nombre;
	private String descripcion;
	private int    precio;
	private int    atributoOriginal;
	private Guerrero jugador;
	private int energiaNecesaria;
	
	public abstract void desactivarAccion();

	public String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	protected void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecio() {
		return precio;
	}
	protected void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getAtributoOriginal() {
		return atributoOriginal;
	}
	protected void setAtributoOriginal(int atributoOriginal) {
		this.atributoOriginal = atributoOriginal;
	}

	public Guerrero getJugador() {
		return jugador;
	}

	public void setJugador(Guerrero jugador) {
		this.jugador = jugador;
	}

	public int getEnergiaNecesaria() {
		return energiaNecesaria;
	}

	protected void setEnergiaNecesaria(int energiaNecesaria) {
		this.energiaNecesaria = energiaNecesaria;
	}
	
	
}
