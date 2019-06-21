package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Filtri {
	public List<StrutturaDati> dati;
	
	public Filtri(List<StrutturaDati> dati)
	{ 
		this.dati=dati;			
	}
	
	public List<StrutturaDati> alfabetico() 
	{ 
		List<StrutturaDati> ordinato=this.dati;
		for(int i=0;i<ordinato.size();i++)
		{ 
			Boolean flag=false;
			for(int j=0;j<ordinato.size()-1;j++)
			{ 
				if(ordinato.get(j).TITOLO_DEL_PROGETTO.charAt(0)<ordinato.get(j+1).TITOLO_DEL_PROGETTO.charAt(0))
				{ 
					StrutturaDati temp=ordinato.get(j);
					ordinato.set(j, ordinato.get(j+1));
					ordinato.set(j+1, temp);
					flag=true;
				}
			}
			if(!flag) {break;}
		}
		return ordinato;
	}
	
		/**
		 * 
		 * @param data
		 * @return
		 */
	public List<StrutturaDati> data_avvio(String data) 
	{ 
		List<StrutturaDati> data_avvio=new ArrayList();
		try
		{ 
			SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
			Date datamax=format.parse(data);
			
			for(int i=0;i<dati.size();i++)
			{ 
				String datas=dati.get(i).DATA_DI_AVVIO;
				datas=datas.replaceAll("\"", "");
				Date data1=format.parse(datas);
				if(datamax.compareTo(data1)>=0)
				{
					data_avvio.add(this.dati.get(i));
				}
			}
			
		}catch(Exception e) {System.out.println(e);}
		return data_avvio;
	}
	/**
	 * 
	 * @param valmin
	 * @return
	 */
	public List<StrutturaDati> getCTR(String valmin)
	{
		List<StrutturaDati> dataotp=new ArrayList();
		for(int i=0;i<this.dati.size();i++)
		{
			try
			{
				double v1=Double.parseDouble(this.dati.get(i).getCONTRIBUTO_SPESE_RICHIESTO().replace(".","").replace(",","."));
				double v2=Double.parseDouble(valmin);
				if(v1>=v2)
				{
					dataotp.add(this.dati.get(i));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return dataotp;
	}
	/**
	 * 
	 * @param durata
	 * @return
	 */
	public List<StrutturaDati> durata(String durata) 
	{ 
		List<StrutturaDati> dataotp=new ArrayList();
		try
		{ 
			int duratamax=Integer.parseInt(durata);
			for(int i=0;i<dati.size();i++)
			{ 
				int duratas=Integer.parseInt(dati.get(i).getDURATA_DEL_PROGETTO().replaceAll("\"", ""));
				if(duratas<=duratamax)
				{
					dataotp.add(this.dati.get(i));
				}
			}
			
		}catch(Exception e) {System.out.println(e);}
		return dataotp;
	}	
	/**
	 * 
	 * @param prov
	 * @return
	 */
	public int OccorrenzeProvincia(String prov) 
	{ 
		int count=0;
		for(int i=0;i<dati.size();i++)
		{
			System.out.println(dati.get(i).getPROVINCIA());
			if(dati.get(i).getPROVINCIA().replaceAll("\"","").equals(prov))
			{
				count++;
			}
			
		}
		return count;
	}	
}
