package com.iteiffel.ece.b3.dwm.TPGraph.interfaces;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;

/**
 * @author Roman
 *
 */
public final class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel contentPane, panel;
	private JComboBox<ComboItem> cbxTeam2, cbxTypeT, cbxTeam1;
	private JButton btnExit, btnAddScoreT1, btnAddScoreT2, btnPlay;
	private JComboBox<Integer> cbxAccTime;
    private IntegerField tbTime, tbScoreT1, tbScoreT2;

    private ButtonGroup groupBtnMainW;
    
	public ButtonGroup getGroupBtnMainW() {
		return groupBtnMainW;
	}

	public void setGroupBtnMainW(ButtonGroup groupBtnMainW) {
		this.groupBtnMainW = groupBtnMainW;
	}

	public JComboBox<ComboItem> getCbxTeam2() {
		return cbxTeam2;
	}

	public void setCbxTeam2(JComboBox<ComboItem> cbxTeam2) {
		this.cbxTeam2 = cbxTeam2;
	}

	public JComboBox<ComboItem> getCbxTeam1() {
		return cbxTeam1;
	}

	public void setCbxTeam1(JComboBox<ComboItem> cbxTeam1) {
		this.cbxTeam1 = cbxTeam1;
	}

	public JComboBox<ComboItem> getCbxTypeT() {
		return cbxTypeT;
	}

	public void setCbxTypeT(JComboBox<ComboItem> cbxTypeT) {
		this.cbxTypeT = cbxTypeT;
	}
	
	public JComboBox<Integer> getCmbAccTime() {
		return cbxAccTime;
	}

	public void setCmbAccTime(JComboBox<Integer> cmbAccTime) {
		this.cbxAccTime = cmbAccTime;
	}
	
	public JButton getBtnExit() {
		return btnExit;
	}
	
	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

	public IntegerField getTbTime() {
		return tbTime;
	}

	public void setTbTime(IntegerField tbTime) {
		this.tbTime = tbTime;
	}
	public JButton getBtnPlay() {
		return btnPlay;
	}

	public void setBtnPlay(JButton btnPlay) {
		this.btnPlay = btnPlay;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public JButton getBtnAddScoreT1() {
		return btnAddScoreT1;
	}

	public void setBtnAddScoreT1(JButton btnAddScoreT1) {
		this.btnAddScoreT1 = btnAddScoreT1;
	}

	public JButton getBtnAddScoreT2() {
		return btnAddScoreT2;
	}

	public void setBtnAddScoreT2(JButton btnAddScoreT2) {
		this.btnAddScoreT2 = btnAddScoreT2;
	}

	public IntegerField getTbScoreT1() {
		return tbScoreT1;
	}

	public void setTbScoreT1(IntegerField tbScoreT1) {
		this.tbScoreT1 = tbScoreT1;
	}

	public IntegerField getTbScoreT2() {
		return tbScoreT2;
	}

	public void setTbScoreT2(IntegerField tbScoreT2) {
		this.tbScoreT2 = tbScoreT2;
	}

	public MainWindow() {
		
		this.setTitle("Panneau des equipes");
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblT1 = new JLabel("Equipe 1");
		lblT1.setHorizontalAlignment(SwingConstants.CENTER);
		lblT1.setBounds(10, 60, 100, 20);
		panel.add(lblT1);
		
		cbxTeam1 = new JComboBox<ComboItem>();

		cbxTeam1.setBounds(10, 83, 100, 20);
		panel.add(cbxTeam1);
		
		JLabel lblT2 = new JLabel("Equipe 2");
		lblT2.setHorizontalAlignment(SwingConstants.CENTER);
		lblT2.setBounds(314, 60, 100, 20);
		panel.add(lblT2);
		
		cbxTeam2 = new JComboBox<ComboItem>();

		cbxTeam2.setBounds(314, 83, 100, 20);
		panel.add(cbxTeam2);
		
		JLabel lblTypeT = new JLabel("Type d'equipe");
		lblTypeT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeT.setBounds(164, 11, 100, 20);
		panel.add(lblTypeT);
		
		cbxTypeT = new JComboBox<ComboItem>();
		cbxTypeT.setName("cbxTypeT");
		cbxTypeT.setBounds(164, 34, 100, 20);
		panel.add(cbxTypeT);
		
	    btnExit = new JButton("Quitter");
		
		btnExit.setBounds(325, 217, 89, 23);
		panel.add(btnExit);
		
		JLabel lblTime = new JLabel("Temps du partie (min)");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(120, 132, 184, 20);
		panel.add(lblTime);
		
		tbTime = new IntegerField (3,0);
		tbTime.setText("0");
		tbTime.setFont(new Font("Verdana", Font.BOLD, 14));
		tbTime.setEnabled(false);
		tbTime.setToolTipText("");
		tbTime.setHorizontalAlignment(SwingConstants.CENTER);
		tbTime.setBounds(158, 151, 40 , 20);
		panel.add(tbTime);
		
		cbxAccTime = new JComboBox<Integer>();
		cbxAccTime.setToolTipText("Choisissez le coefficient d'acceleration");
		cbxAccTime.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 4, 8, 10}));
		cbxAccTime.setSelectedIndex(0);
		cbxAccTime.setBounds(218, 151, 40, 20);
		panel.add(cbxAccTime);
		
	    btnPlay = new JButton("Jouer");
		btnPlay.setBounds(158, 182, 100, 23);
		panel.add(btnPlay);
		
		JLabel lblNewLabel = new JLabel("x");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(200, 151, 15, 20);
		panel.add(lblNewLabel);
		
	    btnAddScoreT1 = new JButton("Ajouter");
		btnAddScoreT1.setBounds(10, 114, 60, 23);
		btnAddScoreT1.setMargin(new Insets(0, 0, 0, 0));
		panel.add(btnAddScoreT1);
		
	    tbScoreT1 = new IntegerField(1, 0);
		tbScoreT1.setToolTipText("");
		tbScoreT1.setText("0");
		tbScoreT1.setHorizontalAlignment(SwingConstants.CENTER);
		tbScoreT1.setFont(new Font("Verdana", Font.BOLD, 14));
		tbScoreT1.setBounds(80, 115, 30, 23);
		panel.add(tbScoreT1);
		
		tbScoreT2 = new IntegerField(1, 0);
		tbScoreT2.setToolTipText("");
		tbScoreT2.setText("0");
		tbScoreT2.setHorizontalAlignment(SwingConstants.CENTER);
		tbScoreT2.setFont(new Font("Verdana", Font.BOLD, 14));
		tbScoreT2.setBounds(384, 114, 30, 23);
		panel.add(tbScoreT2);
		
		btnAddScoreT2  = new JButton("Ajouter");
		btnAddScoreT2.setMargin(new Insets(0, 0, 0, 0));
		btnAddScoreT2.setBounds(314, 114, 60, 23);
		panel.add(btnAddScoreT2);
		
	    groupBtnMainW = new ButtonGroup();
		
	    groupBtnMainW.add(btnAddScoreT2);
	    groupBtnMainW.add(btnAddScoreT1);
	    groupBtnMainW.add(btnExit);
	    groupBtnMainW.add(btnPlay);
	}
	
	public void centerWindow() {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
	}
}
