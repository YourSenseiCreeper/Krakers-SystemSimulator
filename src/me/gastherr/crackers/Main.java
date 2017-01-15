package me.gastherr.crackers;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

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
				File f;
				try {
					f = new File(getClass().getClassLoader().getResource("crackersIcon.png").toURI());
					img = ImageIO.read(f);
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				jf.setIconImage(img);
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
	}

}
