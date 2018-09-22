package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import consts.IGUIconsts;
import consts.I_INGconsts;
import lists.GenericList;
import lists.Ingredient;
import lists.Stack;

public class OrderPanel extends JPanel implements IGUIconsts, I_INGconsts {
	private GenericList<Ingredient> Order;
	private boolean repaint;

	public OrderPanel() {
		this.setBackground(Color.decode("#abb2bc"));
		this.setSize(CONE_PANE_WIDTH, CONE_PANE_HEIGHT);
	}

	private void DrawTriangle(Graphics g) {
		g.setColor(Color.BLACK);
		int[] x = { this.getWidth() / 2 - 10, this.getWidth() / 2, this.getWidth() / 2 + 10 };
		int[] y = { this.getHeight() - 40, this.getHeight() - 10, this.getHeight() - 40 };
		g.fillPolygon(x, y, 3);
	}

	private void drawPanelRect(Graphics g) {
		g.setColor(Color.decode("#abb2bc"));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (repaint) {
			drawPanelRect(g);
		}
		DrawTriangle(g);
		repaint = false;

	}

	protected void paintStack() {
		
		int pX = CONE_PANE_WIDTH / 2 - HELADO_SIZE / 2;
		int pY = CONE_PANE_HEIGHT - INGREDIENT_SEPARATOR - 40;
		Graphics g = this.getGraphics();
		for (int i = Order.getLength() - 1; i >= 0; i--) {
			Order.getValue(i).paintSelf(g, pX, pY);
			pY -= INGREDIENT_SEPARATOR;
		}
	}

	public void setOrder(GenericList<Ingredient> pOrder) {
		Order = pOrder;
		repaintPanel();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.paintStack();
	}

	private void repaintPanel() {
		repaint = true;
		this.repaint();
	}

}
