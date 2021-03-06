package me.gastherr.crackers.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import me.gastherr.crackers.Main;

public class Resource {
	
	/**
	 * Podawa� tylko nazw� pliku i jego rozszerzenie
	 * @param name - nazwa + rozszerzenie pliku
	 * @return Plik o okre�lonej nazwie
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static File getFile(String name) throws IOException, URISyntaxException{
		return new File(Main.class.getClass().getClassLoader().getResource(name).toURI());
	}
	
	/**
	 * 
	 * @param folder
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static File[] getFiles(String folder) throws IOException, URISyntaxException{
		return getFile().listFiles();
	}

}
