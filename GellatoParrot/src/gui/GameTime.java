package gui;

import javax.swing.JLabel;

public class GameTime extends JLabel {
	private int x = 0;

	public GameTime() {
		updateTime();
	}
	public void setTime(int newX) {
		x = newX;
		updateTime();
	}
	public int getTime() {
		return x;
	}
	private void updateTime() {
		this.setText("Time: " + x + "s");
	}
}
