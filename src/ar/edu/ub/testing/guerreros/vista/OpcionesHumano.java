package ar.edu.ub.testing.guerreros.vista;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import ar.edu.ub.testing.guerreros.modelo.Guerrero;
import ar.edu.ub.testing.guerreros.modelo.items.ItemActivo;

public class OpcionesHumano {
	
	private Guerrero humano;
	
	public OpcionesHumano(Guerrero humano) {
		this.humano = humano;
	}
	
	public void printOpcionesHumano() {
		printCabezera(humano);
		System.out.println("X   1)Atacar  2)Defender  3)Habilidad   4)Items   5)Descansar  X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public void printCabezera(Guerrero humano) {
		String datos = "X Turno: " + humano.getAtributos().getNombre() + "              Energia: " + humano.getAtributos().getEnergia();
		int cantidadEspacios = 64 - datos.length();
		for (int i = 0; i < cantidadEspacios-2; i++) {
			datos += " ";
		}
		datos += " X";
		System.out.println(datos);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public void printPanelAtacar() {
		printCabezera(humano);
		System.out.println("X  Seleccione objetivo                                         X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public void printErrorEnergiaInsuficiente() {
		printCabezera(humano);
		System.out.println("X  Tu energia es insuficiente para realizar esa accion         X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		wait(3);
	}
	
	public void printPanelItems(ArrayList<ItemActivo> itemsActivos) {
		if(itemsActivos.isEmpty()) {
			System.out.println("X  No se tienen items activos                                  X");
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			wait(3);
		}else {
			String items = "X ";
			for (int i = 1; i <= itemsActivos.size();i++) {
				items += i + ")" + itemsActivos.get(i-1).getNombre() + " ";
			}
			int cantidadEspacios = 64 - items.length();
			for (int i = 0; i < cantidadEspacios-2; i++) {
				items += " ";
			}
			items += " X";
			System.out.println(items);
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		}
	}
	
	public void printPanelHabilidad(Guerrero humano) {
		if(humano.getHabilidad() == null) {
			System.out.println("X  No se tiene ninguna habilidad equipada                      X");
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			wait(3);
		}else {
			String habilidad = "X " + humano.getHabilidad().nombre();
			int cantidadEspacios = 64 - habilidad.length();
			for (int i = 0; i < cantidadEspacios-2; i++) {
				habilidad += " ";
			}
			habilidad += " X";
			System.out.println(habilidad);
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		}
	}
		
	
	public void wait(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
