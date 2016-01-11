package com.iteiffel.ece.b3.dwm.TPGraph.bin;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JLabel;

import com.iteiffel.ece.b3.dwm.TPGraph.model.Equipe;

public class ClientSock  {

	protected static Equipe eq1, eq2;
	protected static JLabel lblMatchName;
	
	protected static int portNumber = 1500;
	protected static String hostName = "localhost";
	
	public ClientSock (Equipe e1, Equipe e2, JLabel lblMatchName) {
		eq1 = e1;
		eq2 = e2;
		ClientSock.lblMatchName = lblMatchName;
	}
	
	public void StartClient () throws IOException {
		  String serverHostname = new String (hostName);

	        System.out.println ("Attemping to connect to host " +serverHostname + " on port "+portNumber+".");

	        Socket echoSocket = null;
	        PrintWriter out = null;

	        try {
	            echoSocket = new Socket(serverHostname, portNumber);
	            out = new PrintWriter(echoSocket.getOutputStream(), true);

	        } catch (UnknownHostException e) {
	            System.err.println("Don't know about host: " + serverHostname);
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for "
	                               + "the connection to: " + serverHostname);
	            System.exit(1);
	        }

		String userInput;

		userInput = lblMatchName.getText()+";"+eq1.getNom()+";"+eq1.getScoreMatch()+";"+
	                        eq2.getNom()+";"+eq2.getScoreMatch();
		
		out.println(userInput);
		out.close();
		echoSocket.close();
	}
	public static void SendData (Equipe e1, Equipe e2, JLabel lblMatchName) {
	    ClientSock cs = new ClientSock (e1,e2, lblMatchName);
		try {
			cs.StartClient();
		} catch (IOException e) {}
	}
	
}