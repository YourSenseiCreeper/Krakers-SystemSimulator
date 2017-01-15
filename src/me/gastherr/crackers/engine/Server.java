package me.gastherr.crackers.engine;

import java.util.ArrayList;

public class Server extends DataCore{
	
	private String ip;
	private ArrayList<String> allPaths;
	private double freeSpace;
	private String OS;

	public Server(){
		super.setCurrentPath("C:");
		ip = ""; freeSpace = 0; OS = "";
		allPaths = new ArrayList<>();
	}
	
	public Server(String ip, double freeSpace, String OS, String currentPath){
		super.setCurrentPath(currentPath);
		this.ip = ip;
		this.freeSpace = freeSpace;
		this.OS = OS;
	}
	
	public String getIP(){
		return this.ip;
	}
	
	public double getFreeSpace(){
		return freeSpace;
	}
	
	public String getOS(){
		return OS;
	}
	
	public void extend(String name){
		String c = super.getCurrnetPath()+"."+name;
		super.setCurrentPath(c);
		paths().add(c);
	}
	
	public boolean pathA(String pathToGo){
		String to = super.getCurrnetPath()+pathToGo;
		
		if(allPaths.contains(to)){
			jumpTo(to);
			return true;
		}
		else return false;
	}
	
	public boolean path(String pathToGo){
		if(allPaths.contains(pathToGo)){
			jumpTo(pathToGo);
			return true;
		}
		else return false;	
	}
	
	
	public void extendMulti(String dirs){
		String[] names = dirs.contains("/") ? dirs.split("/") : dirs.split(".");
		String c = super.getCurrnetPath();
		if(dirs.contains("/"))
		{
			for(String s : names){
				c = super.getCurrnetPath()+"."+s;
				if(!allPaths.contains(c)) allPaths.add(c);
			}
		}
		else
		{
			for(String s : names){
				c = c+"."+s;
				if(!allPaths.contains(c)) allPaths.add(c);
			}
			super.setCurrentPath(c);
		}
	}
	
	public ArrayList<String> paths(){
		return allPaths;
	}
	
	public void jumpTo(String path){
		super.setCurrentPath(path);
	}
	
	@Override
	public String toString() {
		return "Server [ip=" + ip + ", allPaths=" + allPaths + ", freeSpace=" + freeSpace + ", OS=" + OS + "]";
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setFreeSpace(double freeSpace) {
		this.freeSpace = freeSpace;
	}

	public void setOS(String oS) {
		OS = oS;
	}
}
