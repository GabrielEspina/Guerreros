package ar.edu.ub.testing.guerreros.modelo;


import java.util.ArrayList;
import java.util.Random;

/*import ar.edu.ub.testing.guerros.modelo.items.Item;
import ar.edu.ub.testing.guerros.modelo.items.ItemActivo;
import ar.edu.ub.testing.guerros.modelo.items.ItemPasivo;*/


public abstract class Guerrero {
	
	static Random  rand = new Random();
	private Atributos atributos;
	private Cuerpo    cuerpo;
	private Item[]    items;
	

	public Guerrero(){
		this.atributos = new Atributos();
		this.cuerpo = new Cuerpo();
		this.setItems(new Item[2]);
	}

	public void dañar(int daño) {
		if (daño > 0) {
			this.getAtributos().setVida(this.getAtributos().getVida() - daño);
		}
	}
	public Atributos getAtributos() {
		return atributos;
	}
	public Cuerpo getCuerpo() {
		return cuerpo;
	}
	
	public void printAtributos() {
		System.out.println("-------------------------------");
		System.out.println(this.getAtributos().getNombre());
		System.out.println("-------------------------------");
		System.out.println("Atauqe = " + this.getAtributos().getAtaque());
		System.out.println("Defensa = " + this.getAtributos().getDefensa());
		System.out.println("Energia = " + this.getAtributos().getEnergia());
		System.out.println("Precision = " + this.getAtributos().getPresicion());
		System.out.println("Vida = "  + this.getAtributos().getVida());
	}
	
	//PARA RAPIDA CONSTRUCCION EN CASOS DE PRUEBA
	public void setAtributosSimple(int ataque,int defensa,int energia,int presicion, int vida) {
		
		this.getAtributos().setAtaque(ataque);
		this.getAtributos().setDefensa(defensa);
		this.getAtributos().setEnergia(energia);
		this.getAtributos().setPresicion(presicion);
		this.getAtributos().setVida(vida);
	}
	
	
	public boolean murio() {
		if (this.getAtributos().getVida() <= 0) {
			this.getCuerpo().setCuerpoMuerto();
			this.getAtributos().setVida(0);
			return true;
		}else{
			this.cuerpo = new Cuerpo();
			return false;
		}
	}
	public void atacar(Guerrero enemigo) {
		int chanceCritico = 1 + rand.nextInt((100 - 1) + 1);
		if (1 <= chanceCritico && chanceCritico <= this.getAtributos().getPresicion() ) {
			enemigo.dañar((this.getAtributos().getAtaque()*2) - (enemigo.getAtributos().getDefensa()/2));
		}else {
		enemigo.dañar(this.getAtributos().getAtaque() - (enemigo.getAtributos().getDefensa()/2));	
		}
	}
	
	/*public ArrayList<ItemPasivo> getItemsPasivos(){
		
		ArrayList<ItemPasivo> itemsPasivos = new ArrayList<>();
		if (this.getItems()[0] != null && ItemActivo.class.isAssignableFrom(this.getItems()[0].getClass())) {
			itemsPasivos.add((ItemPasivo)getItems()[0]);
		}
		if (this.getItems()[1] != null && ItemActivo.class.isAssignableFrom(this.getItems()[1].getClass())) {
			itemsPasivos.add((ItemPasivo)getItems()[1]);
		}
		return itemsPasivos;
	}
	
	public void desactivarItemsPasivos(){
		if (this.getItems()[0] != null && ItemPasivo.class.isAssignableFrom(this.getItems()[0].getClass())) {
			getItems()[0].desactivarAccion();
		}
		if (this.getItems()[1] != null && ItemPasivo.class.isAssignableFrom(this.getItems()[1].getClass())) {
			getItems()[1].desactivarAccion();
		}
	}
	public void activarItemsPasivos(){
		ArrayList<ItemPasivo> itemsPasivos = new ArrayList<>();
		if (this.getItems()[0] != null && ItemPasivo.class.isAssignableFrom(this.getItems()[0].getClass())) {
			itemsPasivos.add((ItemPasivo)getItems()[0]);
		}
		if (this.getItems()[1] != null  && ItemPasivo.class.isAssignableFrom(this.getItems()[1].getClass())) {
			itemsPasivos.add((ItemPasivo)getItems()[1]);
		}
		
		for (ItemPasivo i : itemsPasivos) {
			i.ejecutarAccionPasiva();
		}
	}
	
	public ArrayList<ItemActivo> getItemsActivos(){
		
		ArrayList<ItemActivo> itemsActivos = new ArrayList<>();
		if (!(this.getItems()[0] == null) && ItemActivo.class.isAssignableFrom(this.getItems()[0].getClass())) {
			itemsActivos.add((ItemActivo)getItems()[0]);
		}
		if (!(this.getItems()[1] == null) && ItemActivo.class.isAssignableFrom(this.getItems()[1].getClass())) {
			itemsActivos.add((ItemActivo)getItems()[1]);
		}
		return itemsActivos;
	}*/

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}
}

