package com.example.demo;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
/**
 * 
 * @author Lucry
 *
 */
public class Download {	
	/**
	 * 
	 * @throws IOException
	 * @throws ParseException
	 */
	public Download() throws IOException, ParseException
	{
	 File dataset = new File("dataset.csv");
	 String input;
	 String dati="";
	 String url="https://www.dati.gov.it/api/3/action/package_show?id=b28ae475-54f7-4c46-bea4-172387613dc4";
     URL connessione = new URL(url);
     System.setProperty("http.agent", "Chrome");
     URLConnection web = connessione.openConnection();
     BufferedReader s = new BufferedReader(new InputStreamReader(web.getInputStream()));
     while ((input = s.readLine()) != null) 
     {
        dati+=input;
     }
     s.close();
	 JSONObject ogg1 = (JSONObject) JSONValue.parseWithException(dati);	
	 JSONObject ogg2 = (JSONObject) ogg1.get("result");
	 JSONArray ogg3 = (JSONArray) ogg2.get("resources");
	 for (Object test:ogg3)
	 {
		if(test instanceof JSONObject)
		{
			JSONObject Ob2 = (JSONObject) test; 				
	        String formato = (String)Ob2.get("format");		
	        URL url1 = new URL ((String)Ob2.get("url"));	
	        if(formato.equals("csv")) 
	        {
	        	FileUtils.copyURLToFile(url1,dataset);
	        	break;
	        }
		}
	  }
	 }
}
