package gui;

import javax.swing.JLabel;

public class OrdersLeft extends JLabel {
	private int ordersLeft = 0;

	public OrdersLeft() {
		updateOrderCount();
	}

	public void updateOrderCount() {
		this.setText("Orders Left: " + ordersLeft);
	}

	public void setAmmountOfOrders(int pOrders) {
		ordersLeft = pOrders;
		updateOrderCount();
	}

	public int getOrdersLeft() {
		return ordersLeft;
	}
}
