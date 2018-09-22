package gui;

import java.awt.Color;

import javax.swing.JPanel;

import threads.Timer;

public class InfoPanel extends JPanel {
	private GameTime time = new GameTime();
	private Timer timer = new Timer(time);
	private PlayerPoints points = new PlayerPoints();
	private OrdersLeft ordersLeft = new OrdersLeft();
	private OrdersDone ordersDone = new OrdersDone();

	public InfoPanel() {
		this.setBackground(Color.WHITE);
		initComponents();
	}

	public void initComponents() {
		timer.start();

		this.add(time);
		this.add(points);
		this.add(ordersLeft);
		this.add(ordersDone);
	}

	public void changePoints(int newPoints) {
		points.setPoints(newPoints);
	}

	public int getOrdersLeft() {
		return ordersLeft.getOrdersLeft();
	}

	public void addOrdersLeft(int pI) {
		ordersLeft.setAmmountOfOrders(pI);
	}

	public void incrementOrdersDone() {
		ordersDone.setAmmountOfOrders(ordersDone.getOrdersDone() + 1);
	}
}
