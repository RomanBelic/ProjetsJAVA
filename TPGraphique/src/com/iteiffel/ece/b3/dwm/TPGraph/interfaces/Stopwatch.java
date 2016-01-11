package com.iteiffel.ece.b3.dwm.TPGraph.interfaces;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Roman
 *
 */
public class Stopwatch extends JLabel{
	
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

public Stopwatch (int delay, int period)
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

public static void main(String[] args)  {
	
	FlowLayout experimentLayout = new FlowLayout();
	JFrame frame = new JFrame ();
	frame.setLayout(experimentLayout);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final int acctime = 2;
	final Stopwatch sw = new Stopwatch (1000,1000);
	final JButton rest = new JButton ("restart");
	final JButton start = new JButton ("start");
	final JButton stop = new JButton ("stop");
	final int mTime = 10;
	sw.setText("Temps restant : " + mTime + " min");
	
	stop.setVisible(false);
	rest.setVisible(false);

	start.addActionListener(
			new ActionListener () {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					if (sw.interval == 0) {
						sw.startWatch(mTime, acctime);
						stop.setVisible(true);
						start.setVisible(false);
					}		
				}
			}
			);
	
	rest.addActionListener(
			new ActionListener () {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (sw.interval > 0) {
						// TODO Auto-generated method stub
						sw.restartWatch();
						stop.setVisible(true);
						rest.setVisible(false);
					}
				}
				
			}
			);
	
	stop.addActionListener(
			new ActionListener () {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (sw.interval > 0) {
						sw.stopWatch();
						stop.setVisible(false);
						rest.setVisible(true);
					}	
				}
			}
			);
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	frame.setBounds(x, y, 450, 300);
	frame.getContentPane().add(sw);
	frame.getContentPane().add(stop);
	frame.getContentPane().add(start);
	frame.getContentPane().add(rest);
	frame.pack();
	frame.setVisible(true);

}

}