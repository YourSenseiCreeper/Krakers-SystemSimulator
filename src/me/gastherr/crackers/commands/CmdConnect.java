package me.gastherr.crackers.commands;

import java.awt.EventQueue;
import java.util.Random;

import me.gastherr.crackers.engine.Command;
import me.gastherr.crackers.engine.Console;
import me.gastherr.crackers.engine.DataCore;

public class CmdConnect implements Command{

	private Console con;
	private DataCore dc;
	
	public CmdConnect(Console con){
		this.con = con;
		this.dc = con.getDataCore();
	}
	
	@Override
	public void execute(String[] args) {
		if (args.length == 1){
			con.say("Dostêpne serwery:");
			for(String s : dc.getServers().keySet()){
				con.say("- "+s);
			}
			return;
		}
		if (args.length == 2){
			if(dc.getServers().containsKey(args[1])){
				if(dc.getCurrentServer() != null){
					con.say("Jesteœ ju¿ po³¹czony z tym serwerem!");
					return;
				}
				con.say("£¹czenie z "+args[1]);
				EventQueue.invokeLater(new Runnable(){

					@Override
					public void run() {
						try {
							long time = randomTime();
							double sTime = time/1000;
							Thread.sleep(time);
							con.say("Po³¹czono! ("+sTime+"s)");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				});
				dc.setCurrentServer(dc.getServers().get(args[1]));
			}else{
				con.say("Nie znaleziono serwera!");
			}
		}
		
	}
	
	public long randomTime(){
		Random r = new Random();
		return r.nextInt(5000);
	}

	@Override
	public String getDesc() {
		return "£¹czy z serwerem.";
	}


}
