package me.gastherr.crackers.engine;

public interface Command {
		
	public void execute(String[] args);
	
	public String getDesc();
}