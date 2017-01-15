package me.gastherr.crackers;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import me.gastherr.crackers.frame.FrameBase;

public class Main{

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame jf = new FrameBase(0.03);
				Image img = null;
				try {
					img = ImageIO.read(Main.class.getResourceAsStream("/files/crackersIcon.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				jf.setIconImage(img);
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
	}

}
