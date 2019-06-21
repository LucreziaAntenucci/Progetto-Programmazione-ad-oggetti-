package com.example.demo;

	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;

	import org.springframework.util.NumberUtils;
/**
 * 
 * @author Lucry
 *
 */

	public class StampaFile
	 { 
/**
 * 
 */
		private static final String COMMA_DELIMITER = ",";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<StrutturaDati> lista =new ArrayList();
		public StampaFile() throws FileNotFoundException, IOException
		{
			try (BufferedReader br = new BufferedReader(new FileReader("dataset.csv"))) {
			    String line;
			    try {
			    	line = br.readLine();   //salvo la prima riga dei titoli in modo che non crei collisioni dopo
					while ((line = br.readLine()) != null) //legge ogni riga fino a quando non è arrivato alla fine del file 
					{ 					  
						
						String[] values = line.split("\",\"");
						for(String item: values) {
						   item = item.replace("\"", "");
						   System.out.println(item);
					} //salva i valori del dataset in un array di stringhe
					      
					      //controlli sui valori double e int in modo che non contengano il valore null

					      lista.add(new StrutturaDati (values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8],values[9],values[10],values[11],values[12],values[13],values[14],values[15],values[16],values[17],values[18],values[19],values[20],values[21],values[22],values[23],values[24],values[25],values[26]));
					     //aggiunge i valori letti a una lista
					}
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		public List<StrutturaDati> getLista() {
			return lista;
		}
		public void setLista(List<StrutturaDati> lista) {
			this.lista = lista;
		}
		
	}
