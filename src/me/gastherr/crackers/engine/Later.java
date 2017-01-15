package me.gastherr.crackers.engine;

import java.awt.EventQueue;

public class Later implements Runnable{
	
	private long later;
	
	public static void later(Runnable r, long milis){
		EventQueue.invokeLater({

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					con.say("Po³¹czono!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	@Override
	public void run() {
		try {
			Thread.sleep(later);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
