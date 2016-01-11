package com.iteiffel.ece.b3.dwm.TPGraph.run;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.iteiffel.ece.b3.dwm.TPGraph.bin.ClientSock;
import com.iteiffel.ece.b3.dwm.TPGraph.common.ClockChecker;
import com.iteiffel.ece.b3.dwm.TPGraph.dao.TeamDAO;
import com.iteiffel.ece.b3.dwm.TPGraph.interfaces.*;
import com.iteiffel.ece.b3.dwm.TPGraph.model.*;

public class AppMain implements ActionListener {
	
    private MainWindow frame;
    private MatchWindow frameMatch;
	
	private List<Equipe> lstEquipe;
	
	private HashMap<String,String> lstTypes;
	
	private JComboBox <ComboItem> cbxTeam2, cbxTeam1, cbxTypeT;
	
	private ButtonGroup btnGrp, btnGrpMain;
	
	private JButton btnExit, btnPlay, btnTerminate, btnStartClock, btnPauseClock, btnRestartClock, 
	                btnAddScoreT1, btnAddScoreT2;
	
	private IntegerField tbScoreT1, tbScoreT2;
	
    private ClockChecker chk;
    
	private Stopwatch clock;
    
    private String fdate; //ne pas toucher!
        
	public AppMain ()
	{
		try {
			frame = new MainWindow();
			frameMatch = new MatchWindow();
			lstEquipe =  new ArrayList <Equipe> ();
		    lstTypes = new HashMap <String,String> ();
			cbxTeam1 = frame.getCbxTeam1();
			cbxTeam2 = frame.getCbxTeam2();
			cbxTypeT = frame.getCbxTypeT();
			btnGrp = frameMatch.getGroupBtn();
			btnGrpMain = frame.getGroupBtnMainW();
			btnExit = frame.getBtnExit();
			btnPlay = frame.getBtnPlay();		
			btnTerminate = frameMatch.getBtnTerminate();
		    btnStartClock = frameMatch.getBtnStartClock();
		    btnPauseClock = frameMatch.getBtnPauseClock();
		    btnRestartClock = frameMatch.getBtnRestartClock();
			btnAddScoreT1 = frame.getBtnAddScoreT1();
			btnAddScoreT2 = frame.getBtnAddScoreT2();
			tbScoreT1 = frame.getTbScoreT1();
			tbScoreT2 = frame.getTbScoreT2();
			clock = frameMatch.getClock();
		}
		catch (Exception e){
			e.printStackTrace();
			e.getMessage();
		}
		finally {
			System.out.println("init successeful");
		}
	}
	
	//Not used anymore
	//Used to add static data from .txt files
	protected List <Equipe> ReadFromFile (String fileName, Object obj)throws IOException {
		
		BufferedReader br = null;
		List <Equipe> lstTeam = new ArrayList <Equipe> ();
		Equipe eq = null;
	    try {
	        String sCurrentLine;
	        br = new BufferedReader(new FileReader(Statics.DataPath + "/"+ fileName));//file name with path
	        
	        while ((sCurrentLine = br.readLine()) != null) {
	               String[] strArr = sCurrentLine.split(",");
	               
	               String teamName = strArr[0].trim();
	               int teamScore = 0;
	               try {
	            	   teamScore = Integer.parseInt(strArr[1].trim());
	               }
	               catch (Exception e)
	               {
	            	   e.printStackTrace();
	               }
	               
			       if (obj instanceof Foot){
			    	   eq = new Foot (teamName,teamScore,"",0);
			       }
			               
			       if (obj instanceof Baskett){
			    	   eq = new Baskett (teamName,teamScore,"",0);
			       }
			               
			        if (obj instanceof Rugby){
			           eq = new Rugby (teamName,teamScore,"",0);
			       }   
			       lstTeam.add(eq);
	            }//End while
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (br != null)br.close();
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	    return lstTeam;
	}

	protected void cbxTypePIndexChanged () throws InstantiationException, IllegalAccessException {
		
		 ComboItem it = (ComboItem) cbxTypeT.getSelectedItem();
		 int ind = Integer.parseInt(it.getValue());

		 lstEquipe = new ArrayList <Equipe> (); 
		 cbxTeam1.removeAllItems();
		 cbxTeam2.removeAllItems();
		 
         switch (ind) {
         
         case 1 : //Foot   
            lstEquipe = TeamDAO.class.newInstance().getListEquipeByIdType(ind, new Foot ("",0,"",0));
        	break;
        	
         case 2 : //Baskett
            lstEquipe = TeamDAO.class.newInstance().getListEquipeByIdType(ind, new Baskett ("",0,"",0));
        	break;
        	
         case 3 : //Rugby
        	lstEquipe = TeamDAO.class.newInstance().getListEquipeByIdType(ind, new Rugby ("",0,"",0));
        	break;
		 }
         
         if (lstEquipe.size() > 0){
    		 for (Equipe e : lstEquipe ){
    			 ComboItem item  = new ComboItem (e.getIdTeam(), e.getNom());
    			 cbxTeam1.addItem(item);
    			 cbxTeam2.addItem(item);
    		 }
    		frame.getTbTime().setText(lstEquipe.get(0).getmTime() + "");
    	 }
	}

	public static void main(String args[]) {
		
	    AppMain app = new AppMain ();
	    
		app.addActions();
		
		try {
			app.lstTypes = TeamDAO.class.newInstance().getTypeEquipe();
		} 
		catch (InstantiationException | IllegalAccessException e) {}
		
		if (app.lstTypes.size() > 0)
		{ 
			for (Map.Entry<String, String> entry : app.lstTypes.entrySet())
			{
				ComboItem item = new ComboItem (entry.getKey(),entry.getValue());
				app.cbxTypeT.addItem(item);
			}
			app.frame.getCbxTypeT().setSelectedIndex(0); //Force selection
		}
		
		app.frame.centerWindow();
		app.frame.setVisible(true);
		
		app.SetComponentAvailability(false, new Component[]
		{app.btnAddScoreT1,app.btnAddScoreT2,app.tbScoreT1,app.tbScoreT2});
	}
	
	protected void addActions () 
	{
		cbxTeam1.addActionListener(this);
		cbxTeam2.addActionListener(this);
		cbxTypeT.addActionListener(this);
		//Auto add ActionListener to buttons in button group
		Enumeration<?> elements = btnGrp.getElements();
		while (elements.hasMoreElements()) {
			   AbstractButton button = (AbstractButton)elements.nextElement();
			   button.addActionListener(this);
		}
		elements = btnGrpMain.getElements();
		while (elements.hasMoreElements()) {
			   AbstractButton button = (AbstractButton)elements.nextElement();
			   button.addActionListener(this);
		}

	}
	
	protected void setMatchWindowUI ()
	{
		Equipe e1 = null;
		Equipe e2 = null;
		
        ComboItem it1 = (ComboItem)cbxTeam1.getSelectedItem();
        int idTeam1 = Integer.parseInt(it1.getValue());
        
        ComboItem it2 = (ComboItem)cbxTeam2.getSelectedItem();
        int idTeam2 = Integer.parseInt(it2.getValue());
        
        ComboItem itT = (ComboItem)cbxTypeT.getSelectedItem();
        
        int indexT1 = cbxTeam1.getSelectedIndex();
        int indexT2 = cbxTeam2.getSelectedIndex();
        
        try {
	         e1 = TeamDAO.class.newInstance().getEquipeByIdEquipe(idTeam1, lstEquipe.get(indexT1));
	         e2 = TeamDAO.class.newInstance().getEquipeByIdEquipe(idTeam2, lstEquipe.get(indexT2));
        }
        catch (Exception e) {}

		frameMatch.getLblTeam1().setText(e1.getNom());
		frameMatch.getLblTeam2().setText(e2.getNom());
		
		frameMatch.getLblTotT1().setText(e1.getScore() + "");
		frameMatch.getLblTotT2().setText(e2.getScore() + "");
		
		frameMatch.getLblT1Score().setText("0");
		frameMatch.getLblT2Score().setText("0");
		frameMatch.getLblWinner().setText ("");
	
		frameMatch.getLblMatchName().setText("Match de " + itT.getText());

		int accT = (int) frame.getCmbAccTime().getSelectedItem();
		frameMatch.getLblTimeAcc().setText("Temps du jeu (x"+ accT +") : " + e1.getmTime()+ " min");
	    clock.setText("Temps restant : " + e1.getmTime()+ " min");
	}
	
	protected void ClearMatchWindowUI ()
	{
		if (clock != null){
		    clock.stopWatch();
		    if (clock.getTimer() != null)
		    	clock.getTimer().cancel();
		    clock.setText("");
	     }	
		frameMatch.getLblTimeAcc().setText("");
		frameMatch.getLblMatchName().setText("");
		frameMatch.getLblT1Score().setText("0");
		frameMatch.getLblT2Score().setText("0");
		frameMatch.getLblTeam1().setText("");
		frameMatch.getLblTeam2().setText("");
		frameMatch.getLblTotT1().setText("0");
		frameMatch.getLblTotT2().setText("0");
		frameMatch.getLblWinner().setText("");
		tbScoreT1.setText("0");
		tbScoreT2.setText("0");
	}
	
	protected int InsertMatch () {
		
		int rows = 0;
		
		ComboItem it1 = (ComboItem) cbxTeam1.getSelectedItem();
		ComboItem it2 = (ComboItem) cbxTeam2.getSelectedItem();
		
		int idTeam1 = Integer.parseInt(it1.getValue());
		int idTeam2 = Integer.parseInt(it2.getValue());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
	    fdate = dateFormat.format(date);

		try {
	         rows = TeamDAO.class.newInstance().InsertNewMatch(idTeam1, idTeam2, fdate);
		} 
		catch (InstantiationException | IllegalAccessException e) {}
		finally 
		{
			System.out.println (rows + " rows inserted ");
		}
		return rows;
	}
	
	protected void BtnPlayClicked ()
	{
		if (cbxTeam1.getSelectedIndex()!= cbxTeam2.getSelectedIndex())
		{
			setMatchWindowUI ();
			
			Equipe e1 = GetEquipeArr()[0];
			Equipe e2 = GetEquipeArr()[1];
			
			//Equipe e1 = lstEquipe.get(cbxTeam1.getSelectedIndex());
			//Equipe e2 = lstEquipe.get(cbxTeam2.getSelectedIndex());
			
			int x = frame.getX() + frame.getWidth();
			int y = frame.getY();
			frameMatch.setLocation(x, y);
					
			SetComponentAvailability(false, new Component[] {btnPlay, cbxTeam1,cbxTeam2,cbxTypeT,
			frame.getCmbAccTime()});
			
			SetComponentAvailability(true, new Component[]{btnStartClock,btnRestartClock,btnPauseClock});
					
			btnStartClock.setVisible(true);
			btnPauseClock.setVisible(false);
			btnRestartClock.setVisible(false);
			
			frameMatch.setVisible(true);
			
			ClientSock.SendData (e1,e2, frameMatch.getLblMatchName());
			System.out.println(e2.getNom());
			/*ClientSock cs = new ClientSock (e1,e2, frameMatch.getLblMatchName());
			try {
				cs.StartClient();
			} catch (IOException e) {}*/
			
		}
		else 
			{   
			JOptionPane.showMessageDialog(frame,
			"Choisissez les equipes adversaires differents!",
			"Erreur",
		    JOptionPane.ERROR_MESSAGE);
			}
	}

	protected void BtnTerminateClicked ()
	{
		boolean v = frameMatch.isVisible();
		
		SetComponentAvailability(true, new Component[]
		{btnPlay,cbxTeam1,cbxTeam2,cbxTypeT,frame.getCmbAccTime()});
				
		SetComponentAvailability(false, new Component[]
		{btnAddScoreT1,btnAddScoreT2,tbScoreT1,tbScoreT2});
		
		frameMatch.dispose();
		frameMatch.setVisible(!v);
		frame.setVisible(v);
		
		if (chk != null){
	     	chk.getExecutor().shutdown();
		}
		
		ClearMatchWindowUI ();
		
		UpdateMatchScores ();
		
		ClearScores ();
	}
	
	protected void SetComponentAvailability (boolean b, Component[] cm){
		for (Component c:cm){
			c.setEnabled(b);
		}
	}
	
	protected Equipe[] GetEquipeArr(){
		Equipe e1 = lstEquipe.get(cbxTeam1.getSelectedIndex());
		Equipe e2 = lstEquipe.get(cbxTeam2.getSelectedIndex());
		
		Equipe ar[] = new Equipe[] {e1,e2};
		
		return ar;
	}
	
	protected void ClearScores (){
		
		Equipe e1 = GetEquipeArr()[0];
		Equipe e2 = GetEquipeArr()[1];
		
		//Equipe e1 = lstEquipe.get(cbxTeam1.getSelectedIndex());
		//Equipe e2 = lstEquipe.get(cbxTeam1.getSelectedIndex());
		e1.setScoreMatch(0);
		e2.setScoreMatch(0);
	}
	
	protected void UpdateMatchScores () {
		if (fdate != "") {
	    try {   	
			//Equipe objType1 = lstEquipe.get(cbxTeam1.getSelectedIndex());
			//Equipe objType2 = lstEquipe.get(cbxTeam2.getSelectedIndex());
			
			Equipe objType1 = GetEquipeArr()[0];
			Equipe objType2 = GetEquipeArr()[1];
			
			int idTeam1 = Integer.parseInt(objType1.getIdTeam());
			int idTeam2 = Integer.parseInt(objType2.getIdTeam());
			
			int idWinner = 0;
			
			if (objType1.getScoreMatch() > objType2.getScoreMatch() )
				idWinner = idTeam1;
			else {
				idWinner = idTeam2;
			}
			
			HashMap <Integer,Integer> mapT = new HashMap <Integer,Integer> ();
			mapT.put(idTeam1,objType1.getScore());
			mapT.put(idTeam2,objType2.getScore());
			
		    TeamDAO.class.newInstance().UpdateTotalTeamScoreAll(mapT);
			
		    TeamDAO.class.newInstance().UpdateMatchAllTeam(fdate, idTeam1, objType1.getScoreMatch(), 
					                                              idTeam2, objType2.getScoreMatch(),idWinner);
		}
	    catch (Exception e ){}
		}
	}
	
	@Override
    public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();

		if (source == cbxTypeT)
		{
			try 
			{
			    cbxTypePIndexChanged();
			} 
			catch (InstantiationException | IllegalAccessException e1) {}
		}
		
		if (source == cbxTeam1)
		{
			//toDO
			//System.out.println(cbxTeam2.getSelectedIndex());
		}
		
		if (source == cbxTeam2)
		{
			//toDO
			//System.out.println(cbxTeam2.getSelectedIndex());
		}
		
		if (source == btnExit)
		{
			System.exit(0);
			System.out.println("Exit without exception");
		}
		
		if (source == btnPlay)
		{ 
			BtnPlayClicked ();	
		}
		
		if (source == btnTerminate)
		{ 
			BtnTerminateClicked ();
		}
		
		if (source == btnStartClock)
		{ 
			Component[] cArray = {btnStartClock,btnPauseClock,btnRestartClock,
					              btnAddScoreT1,btnAddScoreT2,tbScoreT1,tbScoreT2};
			
			SetComponentAvailability(true, new Component[]{btnAddScoreT1,btnAddScoreT2,tbScoreT1,tbScoreT2});
			
			try 
			{
		     	//Equipe e1 = lstEquipe.get(cbxTeam1.getSelectedIndex());
		     	//Equipe e2 = lstEquipe.get(cbxTeam2.getSelectedIndex());
				
				Equipe e1 = GetEquipeArr()[0];
				Equipe e2 = GetEquipeArr()[1];
		     	
		     	int accT = (int) frame.getCmbAccTime().getSelectedItem();
		     	int mTime = e1.getmTime();
	
				clock.startWatch(mTime, accT);
				
			    chk = new ClockChecker(clock, cArray, e1, e2, frameMatch.getLblWinner());
				chk.getExecutor().scheduleAtFixedRate(chk.CheckerTask, 0, 1, TimeUnit.SECONDS);

				btnStartClock.setVisible(false);
				btnRestartClock.setVisible(false);
				btnPauseClock.setVisible(true);
				
				InsertMatch ();
				
			}
			catch (Exception ex){}
		}
		
		if (source == btnPauseClock)
		{ 
			clock.stopWatch();
			btnPauseClock.setVisible(false);
			btnRestartClock.setVisible(true);
		}
		
		if (source == btnRestartClock)
		{ 
			clock.restartWatch();
			btnRestartClock.setVisible(false);
			btnPauseClock.setVisible(true);
		}
		
		if (source == btnAddScoreT1)
		{
			if (fdate != "")
			{
				//Equipe objType1 = lstEquipe.get(cbxTeam1.getSelectedIndex());
				Equipe objType1 = GetEquipeArr()[0];
				Equipe objType2 = GetEquipeArr()[1];

			    objType1.addScoreMatch(Integer.parseInt(tbScoreT1.getText()));
			    objType1.addScore(Integer.parseInt(tbScoreT1.getText()));
			    
				frameMatch.getLblT1Score().setText(objType1.getScoreMatch() + "");
				frameMatch.getLblTotT1().setText(objType1.getScore() +"");
				
				ClientSock.SendData (objType1,objType2, frameMatch.getLblMatchName());
			}
		}
		
		if (source == btnAddScoreT2)
		{
			if (fdate != "") 
			{
				//Equipe objType2 = lstEquipe.get(cbxTeam2.getSelectedIndex());
				Equipe objType2 = GetEquipeArr()[1];
				Equipe objType1 = GetEquipeArr()[0];
				
			    objType2.addScoreMatch(Integer.parseInt(tbScoreT2.getText()));
			    objType2.addScore(Integer.parseInt(tbScoreT2.getText()));
			    
				frameMatch.getLblT2Score().setText(objType2.getScoreMatch() + "");
				frameMatch.getLblTotT2().setText(objType2.getScore() +"");
				
				ClientSock.SendData (objType1,objType2, frameMatch.getLblMatchName());
			}
		}	
	}	

}
