package com.iteiffel.ece.b3.dwm.socketserver.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class ScoreFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private StopWatch clock;
	
	private JLabel lblMatchName, lblT1name, lblT2name, lblT1score, lblT2score;
	
	public JLabel getLblMatchName() {
		return lblMatchName;
	}

	public void setLblMatchName(JLabel lblMatchName) {
		this.lblMatchName = lblMatchName;
	}

	public JLabel getLblT1name() {
		return lblT1name;
	}

	public void setLblT1name(JLabel lblT1name) {
		this.lblT1name = lblT1name;
	}

	public JLabel getLblT2name() {
		return lblT2name;
	}

	public void setLblT2name(JLabel lblT2name) {
		this.lblT2name = lblT2name;
	}

	public JLabel getLblT1score() {
		return lblT1score;
	}

	public void setLblT1score(JLabel lblT1score) {
		this.lblT1score = lblT1score;
	}

	public JLabel getLblT2score() {
		return lblT2score;
	}

	public void setLblT2score(JLabel lblT2score) {
		this.lblT2score = lblT2score;
	}

	public StopWatch getClock() {
		return clock;
	}

	public void setClock(StopWatch clock) {
		this.clock = clock;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreFrame frame = new ScoreFrame();
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
	public ScoreFrame() {
		initGUI();
	}
	private void initGUI() {
		
		this.setTitle("Panneau du jeu (Serveur)");
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMatchName = new JLabel("match de");
		lblMatchName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatchName.setBounds(10, 11, 264, 20);
		contentPane.add(lblMatchName);
		
		JLabel lblNewLabel = new JLabel("VS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 42, 50, 20);
		contentPane.add(lblNewLabel);
		
		lblT1name = new JLabel("team1");
		lblT1name.setHorizontalAlignment(SwingConstants.CENTER);
		lblT1name.setBounds(10, 42, 110, 20);
		contentPane.add(lblT1name);
		
		lblT2name = new JLabel("team2");
		lblT2name.setHorizontalAlignment(SwingConstants.CENTER);
		lblT2name.setBounds(164, 42, 110, 20);
		contentPane.add(lblT2name);
		
		JLabel lblNewLabel_1 = new JLabel("Score :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 73, 40, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblScore = new JLabel("Score :");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(164, 73, 40, 20);
		contentPane.add(lblScore);
		
		lblT1score = new JLabel("0");
		lblT1score.setHorizontalAlignment(SwingConstants.CENTER);
		lblT1score.setBounds(60, 73, 30, 20);
		contentPane.add(lblT1score);
		
	    lblT2score = new JLabel("0");
		lblT2score.setHorizontalAlignment(SwingConstants.CENTER);
		lblT2score.setBounds(214, 73, 30, 20);
		contentPane.add(lblT2score);
		
		clock = new StopWatch (1000, 1000);
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setText("Temps restant : 0 min");
		clock.setBounds(70, 104, 150, 20);
		contentPane.add(clock);
		
	}
}
