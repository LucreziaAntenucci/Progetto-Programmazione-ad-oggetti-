package com.example.demo;

	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;

	import org.springframework.util.NumberUtils;


	public class StampaFile
	 { 

		private static final String COMMA_DELIMITER = ",";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<StrutturaDati> lista =new ArrayList();
		String[] valori;
		public StampaFile() throws FileNotFoundException, IOException
		{
			try (BufferedReader br = new BufferedReader(new FileReader("dataset.csv"))) {
			    String line;
			    try {
			    	line = br.readLine();   //salvo la prima riga dei titoli in modo che non crei collisioni dopo
					while ((line = br.readLine()) != null) //legge ogni riga fino a quando non è arrivato alla fine del file 
					{ 					  
						
					      String[] valori = line.split(COMMA_DELIMITER,28); //salva i valori del dataset in un array di stringhe
					      
					      //controlli sui valori double e int in modo che non contengano il valore null

					      lista.add(new StrutturaDati (valori[0],valori[1],valori[2],valori[3],valori[4],valori[5],valori[6],valori[7],valori[8],valori[9],valori[10],valori[11],valori[12],valori[13],valori[14],valori[15],valori[16],valori[17],valori[18],valori[19],valori[20],valori[21],valori[22],valori[23],valori[24],valori[25],valori[26]));
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
		public String[] getValori() {
			return valori;
		}
		public void setValori(String[] valori) {
			this.valori = valori;
		}
		
		
	}
