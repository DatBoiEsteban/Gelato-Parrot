package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import consts.IGUIconsts;
import lists.Ingredient;
import lists.Stack;

public class UndoButton extends JButton implements ActionListener, IGUIconsts {
	private ConePanel connee;

	public UndoButton(ConePanel pOrder) {
		connee = pOrder;
		this.setText("UNDO");
		this.setFont(BUTTONS_FONT);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		connee.PopLastIng();
	}

}
