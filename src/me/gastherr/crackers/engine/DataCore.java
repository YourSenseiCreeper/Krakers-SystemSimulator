package me.gastherr.crackers.engine;

import java.util.HashMap;

public class DataCore {
	
	private String currentPath;
	private Server currentServer;
	
	private HashMap<String, Server> servers;
	private Object[] values;
	
	public DataCore(){
		values = new Object[30];
		currentPath = "";
		currentServer = null;
		servers = new HashMap<>();
	}
	
	public Object getValue(int index){
		return values[index];
	}
	
	public HashMap<String, Server> getServers(){
		return servers;
	}
	
	public String getCurrnetPath(){
		return currentPath;
	}
	
	public void setCurrentPath(String path){
		this.currentPath = path;
	}
	
	public Server getCurrentServer(){
		return currentServer;
	}

	public void setCurrentServer(Server s){
		this.currentServer = s;
	}
}
