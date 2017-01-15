package me.gastherr.crackers.commands;

import java.awt.EventQueue;

import me.gastherr.crackers.engine.Command;
import me.gastherr.crackers.engine.Console;

public class CmdExit implements Command{
	
	private Console con;
	
	public CmdExit(Console con){
		this.con = con;
	}
	
	@Override
	public void execute(String[] args) {
		con.say("Zamykanie systemu...");
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					System.exit(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});	
	}

	@Override
	public String getDesc() {
		return "Wy³¹cza program.";
	}
}
