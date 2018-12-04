package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerreros.modelo.items.Item;

public class MenuSeleccionSlot extends MenuRaiz{

	private Item item;
	
	public MenuSeleccionSlot(Item item, GuerreroJugador guerrero) {
		setItem(item);
		setGuerrero(guerrero);
	}
	
	
	@Override
	public void ir() {
		MENU.menuSeleccionSlot(getItem(), getGuerrero());
	}

	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}

}
