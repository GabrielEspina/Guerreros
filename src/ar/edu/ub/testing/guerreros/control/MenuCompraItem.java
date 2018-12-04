package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.modelo.items.Item;

public class MenuCompraItem extends MenuRaiz{
	
	private Item item;
	
	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public void ir() {
		MENU.menuCompraItem(item);
	}

}