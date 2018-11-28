package ar.edu.ub.testing.guerreros.modelo;

public abstract class Item {
	
	private String nombre;
	private String descripcion;
	private int    precio;
	private int    atributoOriginal;
	
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
	
	
}
