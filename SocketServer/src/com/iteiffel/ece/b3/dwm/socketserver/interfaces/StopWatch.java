package com.iteiffel.ece.b3.dwm.socketserver.interfaces;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 * @author Roman
 *
 */
public class StopWatch extends JLabel{
	
private static final long serialVersionUID = 1L;

private Timer timer;

private int interval;
private int delay; 
private int period;
private int accTime;

public Timer getTimer() {
	return timer;
}

public void setTimer(Timer timer) {
	this.timer = timer;
}

public int getDelay() {
	return delay;
}

public void setDelay(int delay) {
	this.delay = delay;
}

public int getPeriod() {
	return period;
}

public void setPeriod(int period) {
	this.period = period;
}

public void setInterval(int interval) {
	this.interval = interval;
}

public int getIntervalVal() {
    return this.interval;
}

public StopWatch (int delay, int period)
{
	super();
	this.delay = delay;
	this.period = period;
}

public void startWatch (final int interval, int accTime) {
     	this.timer = new Timer ();
		this.accTime = accTime;
		this.interval = interval;
		setText("Temps restant : " + interval + " min");
		
	    this.timer.scheduleAtFixedRate(new TimerTask() {
	         public void run() {
	            setText("Temps restant : " + getInterval()+ " min");
	        }	    	
	    }, this.delay/this.accTime, this.period/this.accTime);


}

public void restartWatch (){
	if(this.timer != null & this.interval > 0){
	   this.timer = new Timer ();
	   
	   this.timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	            setText("Temps restant : " + getInterval()+ " min");
	        }
	    }, this.delay/this.accTime, this.period/this.accTime);
}
}
public void stopWatch ()
{
	if(this.timer != null) {
	   this.timer.cancel();
	}
}

private int getInterval() {
    if (this.interval == 1) {
    	this.timer.cancel();
    }
    return --this.interval;
}

}