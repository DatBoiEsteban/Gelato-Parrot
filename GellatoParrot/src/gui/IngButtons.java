package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;

import lists.Ingredient;
import lists.Stack;

public class IngButtons extends JButton {
	JButton ingButton = new JButton();
	Ingredient ing;
	Stack stack;
	public IngButtons(Ingredient pIng, Stack pStack) {
		stack = pStack;
		ing = pIng;
		ingButton.setOpaque(true);
		ingButton.setBackground(ing.getColor());
		ingButton.setText(ing.getName() + "\n" + ing.getType());
		ingButton.setFont(new Font("Arial", 0, 10));
		ingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ingButtonActionPerformed(evt);
			}
		});
	}
	public void ingButtonActionPerformed(ActionEvent evt) {
		stack.add(ing);
	}

}
