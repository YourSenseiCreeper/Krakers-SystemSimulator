package me.gastherr.crackers.commands;

import java.util.HashMap;

import me.gastherr.crackers.engine.Command;
import me.gastherr.crackers.engine.Console;

public class CmdHelp implements Command{
	
	private Console con;
	private String desc = "Lista dostêpnych komend";
	
	public CmdHelp(Console con) {
		this.con = con;
	}

	@Override
	public void execute(String[] args) {
		String time = con.getTime();
		con.send(time+"---------------------------------------------");
		HashMap<String, Command> cmds = con.getCommandsManager().getCommands();
		con.setExecuting(false);
		
		for(String s : cmds.keySet()){
			
			con.send(time+s+"\t\t"+cmds.get(s).getDesc());
		}
		con.setExecuting(true);
		con.send(time+"---------------------------------------------");
		
	}

	@Override
	public String getDesc() {
		return desc;
	}
	
	public String getHeader(String in){
		int le = in.length();
		StringBuilder head = new StringBuilder();
		for(int i = 0; i<le; i++){
			head.append("-");
		}
		return head.toString();
	}

}
