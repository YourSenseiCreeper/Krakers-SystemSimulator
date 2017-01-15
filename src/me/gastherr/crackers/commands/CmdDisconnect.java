package me.gastherr.crackers.commands;

import me.gastherr.crackers.engine.Command;
import me.gastherr.crackers.engine.Console;
import me.gastherr.crackers.engine.DataCore;

public class CmdDisconnect implements Command{

	private Console con;
	private DataCore dc;
	private String desc = "Od³¹cza od serwera";
	
	public CmdDisconnect(Console con){
		this.con = con;
		this.dc = con.getDataCore();
	}
	
	@Override
	public void execute(String[] args) {
		if (args.length == 1){
			if(dc.getCurrentServer() == null){
				con.say("Nie jesteœ po³¹czony z ¿adnym serwerem!");
				return;
			}
			con.say("Serwer, z którym jesteœ po³¹czony:");
			con.say("- "+dc.getCurrentServer().getIP());
			return;
		}
		if (args.length == 2){
			if(dc.getServers().containsKey(args[1])){
				if(dc.getCurrentServer() != null){
					con.say("Od³¹czono od: "+args[1]);
					dc.setCurrentServer(null);
					return;
				}
				con.say("Nie jesteœ po³¹czony z "+args[1]);
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
