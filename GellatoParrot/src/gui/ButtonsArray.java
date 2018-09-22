package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import consts.IGUIconsts;
import consts.I_INGconsts;
import lists.GenericList;
import lists.Ingredient;
import lists.Stack;

public class ButtonsArray extends JPanel implements IGUIconsts, I_INGconsts {
	private Stack<Ingredient> cone;
	private ConePanel conePanel;

	public ButtonsArray(Stack<Ingredient> ConeStack, ConePanel pConePanel) {
		conePanel = pConePanel;
		cone = ConeStack;
		this.setBounds(BUTTONS_X_LOCATION, BUTTONS_Y_LOCATION, BUTTONS_PANE_WIDTH, BUTTONS_PANE_HEIGHT);
		this.setBackground(Color.decode("#abb2bc"));
	}

	public void setNewStack(Stack<Ingredient> newStack) {
		cone = newStack;
	}

	public void paintButtons(GenericList<Ingredient> IngL) {
		this.removeAll();
		this.repaint();
		int ingsInLine = 0;
		int currentLine = 0;
		int currentIng = 0;
		while (currentIng < IngL.getLength()) {
			if (ingsInLine < 4) {
				IngredientButton button = new IngredientButton(IngL.getValue(currentIng++), cone, conePanel);
				this.add(button);
			} else {
				ingsInLine = 0;
				currentLine++;
			}
		}
	}

}
