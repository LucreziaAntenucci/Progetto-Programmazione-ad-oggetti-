package com.example.demo;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.jackson.JsonObjectSerializer;
import org.apache.commons.text.StringEscapeUtils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

/** Classe per restituire i metadati (formato JSON) ovvero elenco degli attributi e del tipo della classe**/

public class Metadati {	
	
	//attributi
	/**
	 * 
	 */
	String metadata ;
	String[] values;
	
	//metodi
	/**
	 * 
	 */
	public Metadati() {
		metadata="";
	    try (BufferedReader br = new BufferedReader(new FileReader("dataset.csv"))) //file da leggere
		 { 
		    
	      Class c = Class.forName("com.example.demo.StrutturaDati");
		  try {
		      	Constructor listaCostruttori[] = c.getConstructors();  //ottiene lista dei costruttori
		      	Field listaParam[] = c.getDeclaredFields();			//ottiene lista dei parametri
		      	for (int i=0; i < listaCostruttori.length; i++)		
		      	{
		      		String fullDesc = listaCostruttori[i].toString();
		      		Class  tipiParam[] = listaCostruttori[i].getParameterTypes();
		      		if (tipiParam.length == 0)     //se non ci sono parametri del costruttore passa al successivo
		      		{	
		      			continue;
		      		}
		      		String line;
		      		line = br.readLine(); 	//legge la prima riga del dataset in modo da ricavarne i titoli
		      		String[] values = line.split("\",\"");
		      		for(String item: values) {
		      		   item = item.replace("\"", "");
		      		   System.out.println(item);
		      		}
		      			
		      		for (int j=0; j < listaParam.length; j++)
		      		{   
	 	 	    	
		      			Field campoCorrente = listaParam[j];
			      		//Per ogni campo crea un oggetto con i parametri alias type e nome
        	
		      			JSONObject obj = new JSONObject();
		      			obj.put("alias", campoCorrente.getName());
		      			obj.put("sourceField", values[j] );
		      			obj.put("type", tipiParam[j].getName());
		      			System.out.println(obj.toJSONString()+","); 
		      			metadata=metadata+obj.toJSONString()+","; 
		      		}
		      	}
		   	}   
	       	catch (IOException e) {
	       		e.printStackTrace();
	       	}
		}
	    catch (ClassNotFoundException cnfe)
	    {
	      System.out.println ("Classe non trovata");
	    } 
	    catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
	    catch (IOException e1) {
			e1.printStackTrace();
		}
	}
		
		
	public String getMetadata() {
			return metadata;
	}
	public void setMetadata(String metadata) {
	this.metadata = metadata;
	}
	public String[] getValues() {
		return values;
	}
	public void setValues(String[] values) {
		this.values = values;
	}

	
   }