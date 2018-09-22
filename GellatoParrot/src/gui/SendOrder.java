package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import consts.IGUIconsts;
import lists.GenericList;
import lists.Ingredient;
import lists.Queue;

public class SendOrder extends JButton implements ActionListener, IGUIconsts {
	private boolean resort = false;
	private boolean OrderCorrect = false;
	private boolean pressed = false;

	public SendOrder() {
		this.setText("Send Order!");
		this.setFont(BUTTONS_FONT);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		pressed = true;
		try {
			Thread.sleep(25);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (OrderCorrect) {
			resort = true;
		}
		
	}

	public boolean doResort() {
		return resort;
	}

	public void setUnpressed() {
		pressed = false;
	}

	public boolean isPressed() {
		return pressed;
	}

	public void resetStatus() {
		resort = false;
		OrderCorrect = false;
	}

	public void wasOrderCorrect(boolean wasCorrect) {
		OrderCorrect = wasCorrect;
	}
}
