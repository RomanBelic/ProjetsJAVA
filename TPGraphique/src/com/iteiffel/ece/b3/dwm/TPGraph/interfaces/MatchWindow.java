package com.iteiffel.ece.b3.dwm.TPGraph.interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

/**
 * @author Roman
 *
 */
public class MatchWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblTeam1, lblTeam2, lblVs, lblT1Score, lblT2Score, lblTimeAcc, 
	               lblMatchName;
	private JButton btnTerminate;
	private Stopwatch clock;
	
	private ButtonGroup groupBtn;
	private JButton btnStartClock;
	private JButton btnPauseClock;
	private JButton btnRestartClock;
	private JLabel label2;
	private JLabel label3;
	private JLabel lblTotT1;
	private JLabel lblTotT2;
	private final JLabel lblWinner;
	
	public JLabel getLblTotT1() {
		return lblTotT1;
	}

	public void setLblTotT1(JLabel lblTotT1) {
		this.lblTotT1 = lblTotT1;
	}

	public JLabel getLblTotT2() {
		return lblTotT2;
	}

	public void setLblTotT2(JLabel lblTotT2) {
		this.lblTotT2 = lblTotT2;
	}

	public JButton getBtnTerminate() {
		return btnTerminate;
	}

	public void setBtnTerminate(JButton btnTerminate) {
		this.btnTerminate = btnTerminate;
	}
	
	public Stopwatch getClock() {
		return clock;
	}

	public void setClock(Stopwatch clock) {
		this.clock = clock;
	}
	public JLabel getLblTeam1() {
		return lblTeam1;
	}

	public void setLblTeam1(JLabel lblTeam1) {
		this.lblTeam1 = lblTeam1;
	}

	public JLabel getLblTeam2() {
		return lblTeam2;
	}

	public void setLblTeam2(JLabel lblTeam2) {
		this.lblTeam2 = lblTeam2;
	}

	public JLabel getLblVs() {
		return lblVs;
	}

	public void setLblVs(JLabel lblVs) {
		this.lblVs = lblVs;
	}

	public JLabel getLblT1Score() {
		return lblT1Score;
	}

	public void setLblT1Score(JLabel lblT1Score) {
		this.lblT1Score = lblT1Score;
	}

	public JLabel getLblT2Score() {
		return lblT2Score;
	}

	public void setLblT2Score(JLabel lblT2Score) {
		this.lblT2Score = lblT2Score;
	}

	public JLabel getLblTimeAcc() {
		return lblTimeAcc;
	}

	public void setLblTimeAcc(JLabel lblTimeAcc) {
		this.lblTimeAcc = lblTimeAcc;
	}

	public JLabel getLblMatchName() {
		return lblMatchName;
	}

	public void setLblMatchName(JLabel lblMatchName) {
		this.lblMatchName = lblMatchName;
	}
	
	public ButtonGroup getGroupBtn() {
		return groupBtn;
	}

	public void setGroupBtn(ButtonGroup groupBtn) {
		this.groupBtn = groupBtn;
	}

	public JButton getBtnStartClock() {
		return btnStartClock;
	}

	public void setBtnStartClock(JButton btnStartClock) {
		this.btnStartClock = btnStartClock;
	}

	public JButton getBtnPauseClock() {
		return btnPauseClock;
	}

	public void setBtnPauseClock(JButton btnPauseClock) {
		this.btnPauseClock = btnPauseClock;
	}

	public JButton getBtnRestartClock() {
		return btnRestartClock;
	}

	public void setBtnRestartClock(JButton btnRestartClock) {
		this.btnRestartClock = btnRestartClock;
	}
	
	public JLabel getLblWinner() {
		return lblWinner;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchWindow frame = new MatchWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MatchWindow() {
		//setUndecorated(true);
		//getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setResizable(false);
		setTitle("Panneau du jeu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblTeam1 = new JLabel("Equipe1");
		lblTeam1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam1.setBounds(10, 30, 100, 20);
		panel.add(lblTeam1);
		
		lblTeam2 = new JLabel("Equipe2");
		lblTeam2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam2.setBounds(161, 30, 100, 20);
		panel.add(lblTeam2);
		
		lblVs = new JLabel("VS");
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);
		lblVs.setBounds(110, 30, 50, 20);
		panel.add(lblVs);
		
		JLabel lblScore = new JLabel("Score : ");
		lblScore.setHorizontalAlignment(SwingConstants.LEFT);
		lblScore.setBounds(10, 50, 50, 20);
		panel.add(lblScore);
		
		JLabel label = new JLabel("Score : ");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(174, 50, 50, 20);
		panel.add(label);
		
		lblT1Score = new JLabel("0");
		lblT1Score.setHorizontalAlignment(SwingConstants.CENTER);
		lblT1Score.setBounds(80, 50, 30, 20);
		panel.add(lblT1Score);
		
		lblT2Score = new JLabel("0");
		lblT2Score.setHorizontalAlignment(SwingConstants.CENTER);
		lblT2Score.setBounds(244, 50, 30, 20);
		panel.add(lblT2Score);
		
	    lblTimeAcc = new JLabel("Temps du jeu (x1) : ");
		lblTimeAcc.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeAcc.setBounds(10, 73, 254, 20);
		panel.add(lblTimeAcc);
		
		lblMatchName = new JLabel("Match de : ");
		lblMatchName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatchName.setBounds(10, 9, 254, 20);
		panel.add(lblMatchName);
		
	    btnTerminate = new JButton("Terminer");
		btnTerminate.setBounds(95, 210, 90, 20);
		panel.add(btnTerminate);
		
		clock = new Stopwatch (1000, 1000);
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setText("Temps restant : 0 min");
		clock.setBounds(65, 104, 150, 20);
		panel.add(clock);
		
	    //Group the buttons.
	    btnStartClock = new JButton("Demarrer");
		btnStartClock.setBounds(95, 135, 90, 20);
		
	    btnPauseClock = new JButton("Pause");
		btnPauseClock.setBounds(95, 135, 90, 20);
		
	    btnRestartClock = new JButton("Reprendre");
		btnRestartClock.setBounds(90, 135, 100, 20);

	    groupBtn = new ButtonGroup();
		
		groupBtn.add(btnStartClock);
		groupBtn.add(btnPauseClock);
		groupBtn.add(btnRestartClock);
		groupBtn.add(btnTerminate);
		
		panel.add(btnStartClock);
		panel.add(btnPauseClock);
		panel.add(btnRestartClock);
		
		label2 = new JLabel("Total :");
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		label2.setBounds(25, 135, 35, 20);
		panel.add(label2);
		
		label3 = new JLabel("Total :");
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		label3.setBounds(200, 135, 35, 20);
		panel.add(label3);
		
		lblTotT1 = new JLabel("0");
		lblTotT1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotT1.setBounds(60, 135, 30, 20);
		panel.add(lblTotT1);
		
		lblTotT2 = new JLabel("0");
		lblTotT2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotT2.setBounds(234, 135, 30, 20);
		panel.add(lblTotT2);
		
		lblWinner = new JLabel("Winner is");
		lblWinner.setForeground(Color.GREEN);
		lblWinner.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinner.setBounds(10, 166, 251, 20);
		
		panel.add(lblWinner);

	}
	
	public void centerWindow() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}
}
