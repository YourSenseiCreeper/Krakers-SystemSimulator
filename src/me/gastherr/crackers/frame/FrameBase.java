package me.gastherr.crackers.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;

import me.gastherr.crackers.engine.Console;
import me.gastherr.crackers.engine.ConsoleMemory;

public class FrameBase extends JFrame{

	private static final long serialVersionUID = 1L;
	public static Console console;

	public FrameBase(double version){
		
		//Font
		Font f = new Font("SansSerif", Font.BOLD, 12);
		GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames().toString();
		
		//Style
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(FrameBase.this);
		//
		
		this.setBounds(30, 30, 600, 350);
		this.setTitle("Crackers v."+version);
		this.setForeground(Color.black);
		
		
		
		JTextField insert = new JTextField(40);
		insert.setBackground(Color.BLACK);
		insert.setForeground(Color.WHITE);
		insert.setFont(f);
		insert.setBorder(BorderFactory.createEmptyBorder());
		insert.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		insert.setSelectionColor(Color.GRAY.darker());
		insert.setFocusAccelerator('c');
		
		Caret caret = new DefaultCaret();
		insert.setCaretColor(Color.WHITE);
        caret.setBlinkRate( UIManager.getInt("TextField.caretBlinkRate") );
        insert.setCaret(caret);

		
		ConsoleMemory mem = new ConsoleMemory(insert);
		insert.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				
				String text = insert.getText();
				if(!text.equals("")){
					mem.send(text);
				}
				console.say(text);
				//COMMAND EXECUTOR!!!
			}
			
		});
		insert.addKeyListener(mem);
		
		console = new Console(f, insert, version);
		
		JScrollPane con = console.getConsole();
		this.add(con);
	
		this.add(insert, BorderLayout.SOUTH);
	}
	
	
	
}
