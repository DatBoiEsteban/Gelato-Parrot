package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import consts.IGUIconsts;
import lists.Ingredient;
import lists.Stack;

public class IngredientButton extends JButton implements ActionListener, IGUIconsts {
	private Ingredient ing;
	private Stack<Ingredient> cone;
	private ConePanel conePanel;

	public IngredientButton(Ingredient pIng, Stack<Ingredient> pCone, ConePanel pConePanel) {
		conePanel = pConePanel;
		cone = pCone;
		ing = pIng;
		this.setBackground(pIng.getColor());
		this.setOpaque(true);
		this.setText("<html>" + pIng.getName() + "<br/>" + pIng.getType() + "</html>");
		this.setFont(BUTTONS_FONT);
		this.setSize(ING_BUTTON_WIDTH, ING_BUTTON_HEIGHT);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		cone.Push(ing);
		conePanel.paintStack();
		
	}

}
