package lists;

import java.awt.Color;
import java.awt.Graphics;

import consts.I_INGconsts;
import consts.I_IngTypes;
import gui.IDrawableObj;

public class Ingredient implements IDrawableObj, I_INGconsts {

	private I_IngTypes type;
	private String name;
	private Color color;
	private Long iD;

	public I_IngTypes getType() {
		return type;
	}

	public void setType(String type) {
		if (type.toLowerCase().equalsIgnoreCase("bola")) {
			this.type = I_IngTypes.HELADO;
		} else {
			this.type = I_IngTypes.TOPPING;
		}

	}

	public Long getiD() {
		return iD;
	}

	public void setiD(Long piD) {
		this.iD = piD;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(String pColor) {
		this.color = Color.decode(pColor);
	}

	public String toString() {
		return "Name: " + name + ", Type: " + type + ", Color in HEX: " + color + ", ID: " + iD + ".";
	}

	public void paintIng(Graphics g, int pX, int pY) {
		g.setColor(this.getColor());
		if (this.getType() == I_IngTypes.HELADO) {
			g.drawOval(pX - INGREDIENT_BORDER_CENTER, pY - INGREDIENT_BORDER_CENTER, INGREDIENT_BORDER, INGREDIENT_BORDER);
			g.fillOval(pX, pY, HELADO_SIZE, HELADO_SIZE);
		}
		if (this.getType() == I_IngTypes.TOPPING) {
			g.drawOval(pX - INGREDIENT_BORDER_CENTER, pY - INGREDIENT_BORDER_CENTER, INGREDIENT_BORDER, INGREDIENT_BORDER);
			g.fillOval(pX + TOPPING_CENTER, pY + TOPPING_CENTER, TOPPING_SIZE, TOPPING_SIZE);
			g.fillOval(pX - TOPPING_SEPARATION + TOPPING_CENTER, pY + TOPPING_CENTER, TOPPING_SIZE, TOPPING_SIZE);
			g.fillOval(pX + TOPPING_SEPARATION + TOPPING_CENTER, pY + TOPPING_CENTER, TOPPING_SIZE, TOPPING_SIZE);
			g.fillOval(pX + TOPPING_CENTER, pY - TOPPING_SEPARATION + TOPPING_CENTER, TOPPING_SIZE, TOPPING_SIZE);
			g.fillOval(pX + TOPPING_CENTER, pY + TOPPING_SEPARATION + TOPPING_CENTER, TOPPING_SIZE, TOPPING_SIZE);
		}
	}

}