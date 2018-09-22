package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import consts.IGUIconsts;
import consts.I_INGconsts;
import lists.Ingredient;
import lists.Stack;

public class ConePanel extends JPanel implements IGUIconsts, I_INGconsts {
	private Stack<Ingredient> cone;
	private Boolean repaint = false;

	public ConePanel(Stack<Ingredient> pCone) {
		cone = pCone;
		this.setBounds(CONE_PANE_X_LOCATION, 0, CONE_PANE_WIDTH, CONE_PANE_HEIGHT);
		this.setBackground(Color.decode("#abb2bc"));
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (repaint) {
			drawPanelRect(g);
		}
		DrawTriangle(g);

	}

	private void DrawTriangle(Graphics g) {
		g.setColor(Color.BLACK);
		int[] x = { this.getWidth() / 2 - 10, this.getWidth() / 2, this.getWidth() / 2 + 10 };
		int[] y = { this.getHeight() - 40, this.getHeight() - 10, this.getHeight() - 40 };
		g.fillPolygon(x, y, 3);
	}

	public void paintStack() {
		repaintPanel();
		int pX = CONE_PANE_WIDTH / 2 - HELADO_SIZE / 2;
		int pY = CONE_PANE_HEIGHT - INGREDIENT_SEPARATOR - 40;
		Graphics g = this.getGraphics();
		for (int i = cone.getLength() - 1; i >= 0; i--) {
			cone.getValue(i).paintSelf(g, pX, pY);
			pY -= INGREDIENT_SEPARATOR;
		}
	}

	private void drawPanelRect(Graphics g) {
		g.setColor(Color.decode("#abb2bc"));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	private void repaintPanel() {
		repaint = true;
		this.paint(getGraphics());
	}

	public void setNewCone(Stack<Ingredient> newStack) {
		cone = newStack;
		paintStack();
	}

	public void PopLastIng() {
		if (!cone.isEmpty()) {
			cone.Pop();
			paintStack();
		}
	}

}
