package com.iteiffel.ece.b3.dwm.TPGraph.common;

import java.awt.Component;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.swing.JLabel;

import com.iteiffel.ece.b3.dwm.TPGraph.interfaces.Stopwatch;
import com.iteiffel.ece.b3.dwm.TPGraph.model.Equipe;

/**
 * @author Roman
 *
 */
public class ClockChecker {
	
	private Component[] map;
	private ScheduledExecutorService executor; 
	private Stopwatch sw;
	private Equipe eq1,eq2;
	private JLabel lblWin;

	public Component[] getMap() {
		return map;
	}

	public void setMap(Component[] map) {
		this.map = map;
	}

	public ScheduledExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ScheduledExecutorService executor) {
		this.executor = executor;
	}

	public Stopwatch getSw() {
		return sw;
	}

	public void setSw(Stopwatch sw) {
		this.sw = sw;
	}

	public ClockChecker (Stopwatch sw, Component[] map, Equipe eq1, Equipe eq2, JLabel lblWin) {
		this.sw = sw;
		this.map = map;
		this.eq1 = eq1;
		this.eq2 = eq2;
		this.lblWin = lblWin;
		executor = Executors.newSingleThreadScheduledExecutor();	
	}
	
	public Runnable CheckerTask = new Runnable() {
		    public void run() {
		    	System.out.println("Thread is checking clock");
		    	if (sw.getIntervalVal() < 1){
		    		executor.shutdown();
		    		System.out.println("clock is terminated; Thread checker shutdown");
		    		disableComponents (map);
		    		if (eq1.getScoreMatch() > eq2.getScoreMatch()){
		    			lblWin.setText(eq1.getNom() + " a gagne");
		    			}
		    		if (eq2.getScoreMatch() > eq1.getScoreMatch()){
		    			lblWin.setText(eq2.getNom() + " a gagne");
		    		}
		    		else if (eq2.getScoreMatch() == eq1.getScoreMatch()){
		    			lblWin.setText("partie nulle");
		    		}
		    	}
		    }
	};
	
	private void disableComponents (Component[] map){
		for (Component c : map)
		{
			c.setEnabled(false);
		}	
	}
	
}
