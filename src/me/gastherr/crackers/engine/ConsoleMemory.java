package me.gastherr.crackers.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JTextField;

public class ConsoleMemory implements KeyListener{
	
	private HashMap<Integer, String> memory;
	private int global;
	private int selected;
	private JTextField input;
	
	public ConsoleMemory(JTextField input){
		this.memory = new HashMap<>();
		this.input = input;
		global = 0;
		selected = 0;
		memory.put(0, "");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//UP
		if(e.getKeyCode() == 38){
			if(selected-1 < 0){
				return;
			}
			selected--;
			input.setText(memory.get(selected));
		}
		//DOWN
		if(e.getKeyCode() == 40){
			if(selected+1 > global){
				return;
			}
			selected++;
			input.setText(memory.get(selected));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	public void send(String msg){
		memory.replace(selected, msg);
		memory.put(selected+1, "");
		selected++;
		global++;
	}

}
