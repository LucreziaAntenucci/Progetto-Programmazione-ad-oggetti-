package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	//attributi
	/**
	 * 
	 */
	private Filtri filters;
	public Controller()
	{
		try
		{
			StampaFile s=new StampaFile();
			filters=new Filtri(s.getLista());
		}catch(Exception e) {}
	}
	
	@RequestMapping (path="/data") 
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	 public StampaFile getdata() throws FileNotFoundException, IOException
	 {
		return new StampaFile();
	 }
	@RequestMapping (path="/Metadata") 
	
	/**Metodo che restituisce i <strong>metadati</strong> quando nella richiesta HTTP viene inserito "/metadata"**/
	
	public Metadati getMetadati() throws FileNotFoundException, IOException
	{
		return new Metadati();
	}	
	
	@RequestMapping (path="/alfa") 
	 public List<StrutturaDati> getAlfa() throws FileNotFoundException, IOException
	 {
		return filters.alfabetico();
	 }
	
	@RequestMapping (path="/occprov") 
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	 public int getOccProv() throws FileNotFoundException, IOException
	 {
		return filters.OccorrenzeProvincia("BA");
	 }
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping (path="/Avvio") 
	public List<StrutturaDati> getAvvio() throws FileNotFoundException, IOException
	{
		return filters.data_avvio("05/11/2012");
	}	
	@RequestMapping (path="/Spese") 
	public List<StrutturaDati> getSpese() throws FileNotFoundException, IOException
	{
		return filters.getCTR("190000.50");
	}	
	
	@RequestMapping (path="/Durata") 
	public List<StrutturaDati> getDurata() throws FileNotFoundException, IOException
	{
		return filters.durata("36");
	}	
}