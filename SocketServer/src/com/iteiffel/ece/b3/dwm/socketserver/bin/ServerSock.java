package com.iteiffel.ece.b3.dwm.socketserver.bin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;

public class ServerSock extends Thread {

    protected static boolean serverContinue = true;
    protected static int portnumber = 1500;
    protected static JLabel lblMatchName, lblTeam1Name,lblTeam2Name, lblTeam1Score, lblTeam2Score;
    protected Socket clientSocket;

    public ServerSock (JLabel lblMatch, JLabel lblT1Name, JLabel lblT2Name,
            JLabel lblT1Score, JLabel lblT2Score){
    	
		 lblMatchName = lblMatch;
		 lblTeam1Name = lblT1Name;
		 lblTeam2Name = lblT2Name;
		 lblTeam1Score = lblT1Score;
		 lblTeam2Score = lblT2Score;
    }
    
	private ServerSock (Socket clientSoc)
	   {
	    clientSocket = clientSoc;
	    start();
	   }
	
	public void run()
	   {
	    System.out.println ("New Communication Thread Started");

	    try { 
	         BufferedReader in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream())); 

	         String inputLine; 
	         
	         while ((inputLine = in.readLine()) != null) 
	             { 
	              String[] data = inputLine.split(";");
	              
	              lblMatchName.setText(data[0]);
	              
	              if (data.length > 1)
	            	  lblTeam1Name.setText(data[1]);
	              
	              if (data.length > 2)
	            	  lblTeam1Score.setText(data[2]);
	              
	              if (data.length > 3)
	            	  lblTeam2Name.setText(data[3]);
	              
	              if (data.length > 4)
	            	  lblTeam2Score.setText(data[4]);

	              if (inputLine.equals("Bye.")) 
	                  break; 

	              if (inputLine.equals("End Server.")) 
	                  serverContinue = false; 
	             } 

	         in.close(); 
	         clientSocket.close(); 
	        } 
	    catch (IOException e) 
	        { 
	         System.err.println("Problem with Communication Server");
	         System.exit(1); 
	        } 
	    
	   }
	 
	public void StartServer () {
		 
		 ServerSocket serverSocket = null; 

		    try { 
		         serverSocket = new ServerSocket(portnumber); 
		         System.out.println ("Connection Socket Created");
		         try { 
		              while (serverContinue)
		                 {
		                  new ServerSock (serverSocket.accept()); 
		                 }
		             } 
		         catch (IOException e) 
		             { 
		              System.err.println("Accept failed."); 
		              System.exit(1); 
		             } 
		        } 
		    catch (IOException e) 
		        { 
		         System.err.println("Could not listen on port: "+portnumber+"."); 
		         System.exit(1); 
		        } 
		    finally
		        {
		         try {
		              serverSocket.close(); 
		             }
		         catch (IOException e)
		             { 
		              System.err.println("Could not close port: "+portnumber+"."); 
		              System.exit(1); 
		             } 
		        }
	 } 
	
}
