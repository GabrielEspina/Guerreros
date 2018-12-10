package ar.edu.ub.testing.guerreros.control.records;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;

public class Records implements Serializable {

	private static final long serialVersionUID = 6020110967780955319L;
	
	private static String recordSP = "recordSP.txt";
	private static String recordMP = "recordMP.txt";


	public static void guardarSP(EntidadesJuego entidades  ) throws IOException, ClassNotFoundException {
		
		String ruta = "";
		ArrayList<String> record = obtenerAtributosSP(entidades);
		System.out.println("Entre");
		if(!compararRecords(record,recordSP)) {
			ruta = recordSP;
	        File archivo = new File(ruta);
	        BufferedWriter bw;
	        bw = new BufferedWriter(new FileWriter(archivo));
	        for(String rec : record)
	        	bw.write(rec+",");
	        bw.close();	
	        System.out.println("");
	        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	        System.out.println("X        NUEVO RECORD!!       X");
	        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	        wait(4);
		}
	}
	
	public static void guardarMP(EntidadesJuego entidades  ) throws IOException, ClassNotFoundException {
		
		String ruta = "";
		ArrayList<String> record = obtenerAtributosSP(entidades);
		
		if(!compararRecords(record,recordMP)) {
			ruta = recordMP;
	        File archivo = new File(ruta);
	        BufferedWriter bw;
	        bw = new BufferedWriter(new FileWriter(archivo));
	        for(String rec : record)
	        	bw.write(rec+",");
	        bw.close();	
	        System.out.println("");
	        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	        System.out.println("X        NUEVO RECORD!!       X");
	        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	        wait(4);
		}
	}
	
	public static ArrayList<String> obtenerAtributosSP(EntidadesJuego entidades  ){
		ArrayList<String> record = new ArrayList<>();
		
		record.add(Integer.toString(entidades.getRound()));
		record.add(entidades.getJugador().getAtributos().getNombre());
		record.add(Integer.toString(entidades.getJugador().getAtributos().getAtaque()));
		record.add(Integer.toString(entidades.getJugador().getAtributos().getDefensa()));
		record.add(Integer.toString(entidades.getJugador().getAtributos().getPresicion()));
		record.add(Integer.toString(entidades.getJugador().getAtributos().getVida()));
		record.add(Integer.toString(entidades.getJugador().getAtributos().getEnergia()));
		return record;
	}
	
	public static ArrayList<String> obtenerAtributosMP(EntidadesJuego entidades  ){
		ArrayList<String> record = new ArrayList<>();
		
		record.add(Integer.toString(entidades.getRound()));
		record.add(entidades.getJugador().getAtributos().getNombre());
		record.add(Integer.toString(entidades.getJugador().getAtributos().getAtaque()));
		record.add(Integer.toString(entidades.getJugador().getAtributos().getDefensa()));
		record.add(Integer.toString(entidades.getJugador().getAtributos().getPresicion()));
		record.add(Integer.toString(entidades.getJugador().getAtributos().getVida()));
		record.add(Integer.toString(entidades.getJugador().getAtributos().getEnergia()));
		record.add(entidades.getJugador2().getAtributos().getNombre());
		record.add(Integer.toString(entidades.getJugador2().getAtributos().getAtaque()));
		record.add(Integer.toString(entidades.getJugador2().getAtributos().getDefensa()));
		record.add(Integer.toString(entidades.getJugador2().getAtributos().getPresicion()));
		record.add(Integer.toString(entidades.getJugador2().getAtributos().getVida()));
		record.add(Integer.toString(entidades.getJugador2().getAtributos().getEnergia()));
		return record;
	}
	
	private static boolean compararRecords(ArrayList<String> record,String path) throws ClassNotFoundException, IOException {
		ArrayList<String> comparador = cargar(path);
		if(Integer.parseInt(comparador.get(0)) > Integer.parseInt(record.get(0))) {
			return true;	
		}else {
			return false;
		}	
	}
	
	public static ArrayList<String> cargar(String path  ) throws IOException, ClassNotFoundException {
		
		String fichero = path;
		
		String cadena;
		FileReader f = new FileReader(fichero);
		
		BufferedReader b = new BufferedReader(f);
		
		ArrayList<String> record = new ArrayList<>();
		while((cadena = b.readLine())!=null) {
			String[] arraycadena = cadena.split(",");
			for(int i=0;i < arraycadena.length;i++)
				record.add(arraycadena[i]);
		}
		
		b.close();
		return record;	
	}
	public static void wait(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
