package me.gastherr.crackers.commands;
import java.util.HashMap;

import me.gastherr.crackers.engine.Command;
import me.gastherr.crackers.engine.Console;
import me.gastherr.crackers.utils.Messages;

public class CmdHelp implements Command{
	
	private Console con;
	
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
			
			con.send(time+s+" - "+cmds.get(s).getDesc());
		}
		con.setExecuting(true);
		con.send(time+"---------------------------------------------");
		
	}

	@Override
	public String getDesc() {
		return Messages.getMessage("desc_help");
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
