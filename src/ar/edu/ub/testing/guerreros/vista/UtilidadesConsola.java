package ar.edu.ub.testing.guerreros.vista;

public class UtilidadesConsola {
	
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
