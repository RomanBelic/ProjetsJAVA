package com.iteiffel.ece.b3.dwm.socketserver.run;
import javax.swing.JLabel;

import com.iteiffel.ece.b3.dwm.socketserver.bin.*;
import com.iteiffel.ece.b3.dwm.socketserver.interfaces.*;

public class AppMain {
	
	private ScoreFrame frame;
	private JLabel lblMatchName, lblT1Name, lblT2Name, lblT1Score, lblT2Score;
	private StopWatch clock;
	
	public AppMain (){
		frame = new ScoreFrame ();
		lblMatchName = frame.getLblMatchName();
		lblT1Name = frame.getLblT1name();
		lblT2Name = frame.getLblT2name();
		lblT1Score = frame.getLblT1score();
		lblT2Score = frame.getLblT2score();	
		clock = frame.getClock();
	}
	
	
	public static void main (String[] args) throws InstantiationException, IllegalAccessException {
		
		AppMain app = new AppMain ();
		app.frame.setVisible(true);
		
		ServerSock sv = new ServerSock(app.lblMatchName, app.lblT1Name,
				                       app.lblT2Name, app.lblT1Score, app.lblT2Score);
		sv.StartServer();
	}
	
	 

}
