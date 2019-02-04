package ar.edu.ub.testing.guerreros.vista;

import java.util.ArrayList;

public class MenuRecords {
	
	public void mostrarMenuRecords() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X             GUERREROS             X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Record singleplayer            X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) Record multiplayer             X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) Atras                          X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public void mostrarRecordSingleplayer(ArrayList<String> atributos) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X       RECORD SINGLEPLAYER         X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printElemento(atributos.get(0),"NIVEL= "));
		System.out.println(printElemento(atributos.get(1),"NOMBRE= "));
		System.out.println(printElemento(atributos.get(2),"ATAQUE= "));
		System.out.println(printElemento(atributos.get(3),"DEFENSA= "));
		System.out.println(printElemento(atributos.get(4),"PRESICION= "));
		System.out.println(printElemento(atributos.get(5),"VIDA= "));
		System.out.println(printElemento(atributos.get(6),"ENERGIA= "));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("X PRESIONE ENTER PARA REGRESAR      X");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}
	
	public void mostrarRecordMultiplayer(ArrayList<String> atributos) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X        RECORD MULTIPLAYER         X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printElemento(atributos.get(0),"NIVEL= "));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printElemento(atributos.get(1),"NOMBRE= "));
		System.out.println(printElemento(atributos.get(2),"ATAQUE= "));
		System.out.println(printElemento(atributos.get(3),"DEFENSA= "));
		System.out.println(printElemento(atributos.get(4),"PRESICION= "));
		System.out.println(printElemento(atributos.get(5),"VIDA= "));
		System.out.println(printElemento(atributos.get(6),"ENERGIA= "));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printElemento(atributos.get(7),"NOMBRE= "));
		System.out.println(printElemento(atributos.get(8),"ATAQUE= "));
		System.out.println(printElemento(atributos.get(9),"DEFENSA= "));
		System.out.println(printElemento(atributos.get(10),"PRESICION= "));
		System.out.println(printElemento(atributos.get(11),"VIDA= "));
		System.out.println(printElemento(atributos.get(12),"ENERGIA= "));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("X PRESIONE ENTER PARA REGRESAR      X");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}
	
	public String printElemento(String Elemento, String queElemento) {
		String s = "X " + queElemento + Elemento;
		int cantidadEspacios = 37 - s.length();
		for(int i = 0; i<cantidadEspacios-2;i++) {
			s += " ";
		}
		s += " X";
		return s;
	}
}
