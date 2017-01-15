package me.gastherr.crackers.commands;

import me.gastherr.crackers.engine.Command;
import me.gastherr.crackers.engine.Console;
import me.gastherr.crackers.engine.DataCore;
import me.gastherr.crackers.utils.Messages;

public class CmdDirectory implements Command{

	private Console console;
	private DataCore core;
	private final String desc = "Pozwala przemieszczaæ siê po folderach.";
	
	public CmdDirectory(Console con){
		this.console = con;
		this.core = con.getDataCore();
	}
	
	@Override
	public void execute(String[] args) {
		if(args.length == 1){
			if(core.getCurrentServer() == null){
				console.say("Nie jesteœ po³¹czony z ¿adnym serwerem!");
				return;
			}
			console.say("Dostêpne dyski: ");
			char last = ' ';
			for(String d : core.getCurrentServer().paths()){
				if(d.charAt(0) != last){
					last = d.charAt(0);
					console.say("- "+d.charAt(0)+":");
				}
			}
			return;
		}
		if(args.length == 2){
			if(core.getCurrentServer().paths().contains(args[1])){
				console.send("Przechodzisz do: ");
			}
			else Messages.getMessage("err_brak_sciezki");
		}
		
	}

	@Override
	public String getDesc() {
		return desc;
	}

}
