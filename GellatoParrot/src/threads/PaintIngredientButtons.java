package threads;

import java.awt.Graphics;

import consts.I_INGconsts;
import gui.IngButtons;
import lists.GenericList;
import lists.Ingredient;
import lists.Stack;

public class PaintIngredientButtons extends Thread implements I_INGconsts {
	GenericList<Ingredient> DrawableIngs;
	Graphics g;
	Stack stack;

	public PaintIngredientButtons(GenericList<Ingredient> ingL, Graphics pG, Stack pStack) {
		g = pG;
		DrawableIngs = ingL;
		stack = pStack;
	}

	@Override
	public void run() {
		int currentIng = 0;
		int currentLine = 1;
		int IngPosY = INGREDIENT_Y_LOCATION;
		if (DrawableIngs != null) {
			while (currentIng < DrawableIngs.getLength()) {
				int IngsInLine = 0;
				int IngPosX = INGREDIENT_X_LOCATION;
				while (IngsInLine++ < 4 && currentIng < DrawableIngs.getLength()) {
					Ingredient currntIng = DrawableIngs.getValue(currentIng++);
					currntIng.paintIng(g, IngPosX, IngPosY);
					
					IngPosX += INGREDIENT_SEPARATOR;
				}
				IngPosY = INGREDIENT_Y_LOCATION + (INGREDIENT_SEPARATOR * currentLine++);
			}
		}

	}

}
