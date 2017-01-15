package me.gastherr.crackers.engine;

import java.util.HashMap;

import me.gastherr.crackers.commands.CmdConnect;
import me.gastherr.crackers.commands.CmdDirectory;
import me.gastherr.crackers.commands.CmdDisconnect;
import me.gastherr.crackers.commands.CmdExit;
import me.gastherr.crackers.commands.CmdHelp;

public class CommandsManager {
	
	private HashMap<String, Command> cmds;

	public CommandsManager(Console con){
		cmds = new HashMap<>();
		
		cmds.put("help", new CmdHelp(con));
		cmds.put("exit", new CmdExit(con));
		cmds.put("connect", new CmdConnect(con));
		cmds.put("disconnect", new CmdDisconnect(con));
		cmds.put("cd", new CmdDirectory(con));
		
	}
	
	public HashMap<String, Command> getCommands(){
		return cmds;
	}
	
	public boolean getCommand(String[] args){
		if(cmds.containsKey(args[0])){
			cmds.get(args[0]).execute(args);
			return true;
		}
		return false;
		
	}
}
