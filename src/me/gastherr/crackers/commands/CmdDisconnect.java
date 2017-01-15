package me.gastherr.crackers.commands;

import me.gastherr.crackers.engine.Command;
import me.gastherr.crackers.engine.Console;
import me.gastherr.crackers.engine.DataCore;

public class CmdDisconnect implements Command{

	private Console con;
	private DataCore dc;
	private String desc = "Od��cza od serwera";
	
	public CmdDisconnect(Console con){
		this.con = con;
		this.dc = con.getDataCore();
	}
	
	@Override
	public void execute(String[] args) {
		if (args.length == 1){
			if(dc.getCurrentServer() == null){
				con.say("Nie jeste� po��czony z �adnym serwerem!");
				return;
			}
			con.say("Serwer, z kt�rym jeste� po��czony:");
			con.say("- "+dc.getCurrentServer().getIP());
			return;
		}
		if (args.length == 2){
			if(dc.getServers().containsKey(args[1])){
				if(dc.getCurrentServer() != null){
					con.say("Od��czono od: "+args[1]);
					dc.setCurrentServer(null);
					return;
				}
				con.say("Nie jeste� po��czony z "+args[1]);
			}else{
				con.say("Nie znaleziono serwera!");
			}
		}
		
	}

	@Override
	public String getDesc() {
		return desc;
	}


}
