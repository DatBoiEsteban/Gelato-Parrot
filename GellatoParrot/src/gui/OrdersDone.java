package gui;

import javax.swing.JLabel;

public class OrdersDone extends JLabel {
	private int ordersDone = 0;

	public OrdersDone() {
		updateOrderCount();
	}

	public void updateOrderCount() {
		this.setText("Orders Done: " + ordersDone);
	}

	public void setAmmountOfOrders(int pOrders) {
		ordersDone = pOrders;
		updateOrderCount();
	}

	public int getOrdersDone() {
		return ordersDone;
	}
}
