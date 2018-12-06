package ar.edu.ub.testing.guerreros.control.records;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;

public class Records implements Serializable {

	private static final long serialVersionUID = 6020110967780955319L;


	public static void guardar(EntidadesJuego entidades  ) throws IOException {
		
		ArrayList<String> record = new ArrayList<>();
		
		record.add(Integer.toString(entidades.getRound()));
		record.add(Integer.toString(entidades.getJugador().getPuntos()));
		record.add(entidades.getJugador().getAtributos().getNombre());
		
		
		String ruta ="records.txt";
        File archivo = new File(ruta);
		
		//if (archivo.exists()) archivo.delete();
		
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo));
        for(String rec : record)
        	bw.write(rec+",");
        bw.close();	
        
        System.out.println("Records guardados");
        
	}
	
	
	public static ArrayList<ArrayList<String>> cargar(  ) throws IOException, ClassNotFoundException {
		
		String fichero = "records.txt";
		
		String cadena;
		FileReader f = new FileReader(fichero);
		
		BufferedReader b = new BufferedReader(f);
		
		ArrayList<String> record = new ArrayList<>();
		ArrayList<ArrayList<String>> records = new ArrayList<>();
		while((cadena = b.readLine())!=null) {
			String[] arraycadena = cadena.split(",");
			for(int i=0;i<3;i++)
				record.add(arraycadena[i]);
			records.add(record);
		}
		
		b.close();
		
		return records;
		
}

}
