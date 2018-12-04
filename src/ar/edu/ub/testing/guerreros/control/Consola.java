package ar.edu.ub.testing.guerreros.control;

import java.util.Scanner;

public class Consola {
	
	private static Scanner scan = new Scanner( System.in );

	
	public static String pedirNombre() {
		String nombre = getScan().next();
		if(nombre.length() <= 15)
			return nombre;
		System.out.println("Error: Nombre muy largo");
		return pedirNombre();
	}
	
	public static Integer pedirNumero() {
		int numero;
		try {
			numero = getScan().nextInt();
			return numero;
		}catch(Exception e) {
			System.out.println("Error: Ingrese numeros");
			return pedirNumero();
		}
	}
	
	public static Integer pedirNumero( int min, int max ) {
		
		int numero = pedirNumero();
		if(min <= numero && numero <= max)
			return numero;
		System.out.println("Error: Ingrese opcion dentro del rango");
		return pedirNumero(min,max);
		
	}

	public static Scanner getScan() {
		return scan;
	}
	
	public static void limpiarConsola() {
		for (int i = 1; i < 100; i++) {
			System.out.println(" ");
		}
	}
	
	 public static void apretarEnterParaContinuar()
	 { 
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("X Presione Enter Para Regresar X");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
	 }
}
