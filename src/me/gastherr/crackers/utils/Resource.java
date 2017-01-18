package me.gastherr.crackers.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	public static File[] getFiles(String filefolder, String foldername) throws IOException, URISyntaxException{
		File f = getFile(filefolder);
		Path p = Paths.get(f.getParentFile().toPath().toString(), foldername);
		return new File(p.toString()).listFiles();
	}

}
