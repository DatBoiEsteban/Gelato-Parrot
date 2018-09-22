package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import consts.IGUIconsts;

public class FinishedWindow extends JFrame implements IGUIconsts {
	private JLabel StatusText;

	public FinishedWindow() {
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setBackground(Color.decode("#abb2bc"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void initComponents() {
		StatusText = new JLabel("YOU WON!");
		StatusText.setFont(new Font("Arial", Font.BOLD, 70));
		StatusText.setLocation(WINDOW_WIDTH / 2, this.getHeight() / 2 - 50);
		StatusText.setSize(200, 100);
		this.getContentPane().add(StatusText);
	}
}
