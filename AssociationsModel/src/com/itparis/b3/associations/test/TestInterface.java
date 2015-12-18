package com.itparis.b3.associations.test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class TestInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8384760810583013078L;
	private JPanel contentPane;
	
	public JComboBox <String>comboBox;
	public JComboBox <String>comboBox2;
	public JButton button1;
	public JTextPane textPane2;
	public JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestInterface frame = new TestInterface();
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
	public TestInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 255, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 11, 105, 20);
		contentPane.add(comboBox);
		
	    comboBox2 = new JComboBox<String>();
	    comboBox2.setBounds(125, 11, 105, 20);
		contentPane.add(comboBox2);
		
	    textPane = new JTextPane();
		textPane.setBounds(10, 42, 105, 20);
		contentPane.add(textPane);
		
	    textPane2 = new JTextPane();
		textPane2.setBounds(125, 42, 105, 20);
		contentPane.add(textPane2);
		
		button1 = new JButton("New button");
		button1.setBounds(78, 88, 89, 23);
		contentPane.add(button1);


	}
	

	
}
