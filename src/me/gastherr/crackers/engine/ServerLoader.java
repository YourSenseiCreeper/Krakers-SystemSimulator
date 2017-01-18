package me.gastherr.crackers.engine;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import me.gastherr.crackers.utils.Assembler;
import me.gastherr.crackers.utils.Resource;

public class ServerLoader extends DataCore{
	
	public ServerLoader(){
		File[] listOfFiles = null;
		try {
			listOfFiles = Resource.getFiles("crackersIcon.png", "servers");
			
		} catch (IOException | URISyntaxException e) { e.printStackTrace(); }

		Server s = null;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				s = loadOne(listOfFiles[i].getName());
				super.getServers().put(s.getIP(), s);
			}
		}
	}
	
	private Server loadOne(String name){
		Scanner sc = null;
		try {
			sc = new Scanner(Resource.getFile(name+".txt"));
		} catch (IOException | URISyntaxException e) {e.printStackTrace();}
		//Mo¿e byæ problem ze œcie¿k¹ wzglêdn¹
		Server s1 = new Server();
		
		String line;
		String[] array;
		
		while(sc.hasNextLine()){
			line = sc.nextLine();
			array = line.split(" ");
			
			switch(array[0]){
			//Pobieranie ip serwera
			case "ip:":
				line.replace(array[0]+" ", "");
				s1.setIp(line);
				break;
			//Pobieranie systemu i jego wersji
			case "os:":
				line.replace(array[0]+" ", "");
				s1.setOS(line);
			//Wolne miejsce w systemie
			case "freespace:":
				line.replace(array[0]+" ", "");
				s1.setFreeSpace(Double.parseDouble(line));
			}
			
			if(line.equals("EXECUTE")) break;
		}
		
		//ASSEMBLER COMMANDS
		if(sc.nextLine().equals("EXECUTE")){
			sc.nextLine();
			
			while(sc.hasNextLine()){
				line = sc.nextLine();
				Assembler.command(s1, line);
			}
		}
		sc.close();
		return s1;
	}
}
