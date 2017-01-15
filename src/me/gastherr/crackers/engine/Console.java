package me.gastherr.crackers.engine;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import me.gastherr.crackers.utils.Assembler;
import me.gastherr.crackers.utils.Messages;
import me.gastherr.crackers.utils.Resource;

public class Console{
	
	private static JTextArea console;
	private JScrollPane scrollConsole;
	private JTextField input;
	private DataCore dc;
	private CommandsManager cm;
	private boolean execution;
	
	public Console(Font f, JTextField input, double version){
		
		execution = true;
		int year = 2017;
		console = new JTextArea(8,40);
		console.setEditable(false);
		console.setBackground(Color.BLACK);
		console.setForeground(Color.WHITE);
		console.setFont(f);
		console.setLineWrap(true);
		console.setSelectionColor(Color.GRAY.darker());
		scrollConsole = new JScrollPane(console);
		scrollConsole.setBorder(BorderFactory.createEmptyBorder());
		this.input = input;
		
		new Resource();
		new Assembler();
		new Messages();
		
		//ce = new CommandExecutor(this);
		dc = new DataCore();
		//new ServerLoader();
		cm = new CommandsManager(this);
		
		
		//Welcome!
		send(Messages.getMessage("welcome1").replace("$v", version+""));
		send(Messages.getMessage("welcome2").replace("$y", year+""));
		send(Messages.getMessage("welcome3"));
		send(" ");
		
	}
	
	public boolean isExecuting(){
		return this.execution;
	}
	
	public void setExecuting(boolean execution){
		this.execution = execution;
	}
	
	public JScrollPane getConsole(){
		return scrollConsole;
	}
	
	public void say(String msg){
		
		String[] args = msg.split(" ");
		if(execution){
			if(cm.getCommand(args)){
				return;
			}
		}
		
		console.append(getTime()+msg+"\n");
		input.setText("");
	}
	
	@SuppressWarnings("deprecation")
	public String getTime(){
		
		Date d = new Date();
		String h = "";
		String m = "";
		String s = "";
		
		if(d.getHours() < 10) h = "0"+d.getHours();
		else h = d.getHours()+"";
		
		if(d.getMinutes() < 10) m = "0"+d.getMinutes();
		else m = d.getMinutes()+"";
		
		if(d.getSeconds() < 10) s = "0"+d.getSeconds();
		else s = d.getSeconds()+"";
		
		String format = "["+h+":"+m+":"+s+"] ";
		return format;
	}
	
	public void send(String msg){
		console.append(msg+"\n");
		input.setText("");
	}
	
	public DataCore getDataCore(){
		return dc;
	}
	
	public String setTextColor(Color c){
		console.setForeground(c);
		return "";
	}
	
	public CommandsManager getCommandsManager(){
		return this.cm;
	}

}
