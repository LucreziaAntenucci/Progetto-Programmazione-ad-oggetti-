package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
@RequestMapping (path="/data") 
 public StampaFile getdata() throws FileNotFoundException, IOException
 {
	
	return new StampaFile();
 }
@RequestMapping (path="/Metadata") 
public Metadati getMetadati() throws FileNotFoundException, IOException
{
	return new Metadati();
}
}

