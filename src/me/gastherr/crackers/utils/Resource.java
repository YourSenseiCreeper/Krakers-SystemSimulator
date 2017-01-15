package me.gastherr.crackers.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Resource {
	
	/**
	 * Podawaæ tylko nazwê pliku i jego rozszerzenie
	 * @param name - nazwa + rozszerzenie pliku
	 * @return Plik o okreœlonej nazwie
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static File getFile(String name) throws IOException, URISyntaxException{
		return new File(Resource.class.getClass().getClassLoader().getResource(name).toURI());
	}
	
	/**
	 * 
	 * @param folder
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static File[] getFiles(String folder) throws IOException, URISyntaxException{
		File f = new File(Resource.class.getClass().getClassLoader().getResource(folder).toURI());
		return f.listFiles();
	}

}
