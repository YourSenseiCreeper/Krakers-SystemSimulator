package me.gastherr.crackers.utils;

import me.gastherr.crackers.engine.Server;

public class Assembler {

	public static void command(Server s1, String line){
		String[] args = line.split(" ");
		
		if(args[0].equals("cdr")) cdr(s1, args[1]);
		if(args[0].equals("cpth")) cpth(s1, args[1]);
	}
	
	private static void cdr(Server s1, String arg){
		String[] names = arg.contains("/") ? arg.split("/") : arg.split(".");
		String c = s1.getCurrnetPath();
		if(arg.contains("/"))
		{
			for(String s : names){
				c = s1.getCurrnetPath()+"."+s;
				if(!s1.paths().contains(c)) s1.paths().add(c);
			}
		}
		else
		{
			for(String s : names){
				c = c+"."+s;
				if(!s1.paths().contains(c)) s1.paths().add(c);
			}
			s1.setCurrentPath(c);
		}
	}
	
	private static void cpth(Server s1, String arg){
		s1.setCurrentPath(arg);
	}
}
