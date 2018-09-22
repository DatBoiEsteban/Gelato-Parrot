package gui;

import javax.swing.JLabel;

public class PlayerPoints extends JLabel {
	private int points = 0;

	public PlayerPoints() {
		updateText();
	}

	public void setPoints(int newPoints) {
		points += newPoints;
		updateText();
	}

	public void decreasePoints() {
		points--;
	}

	private void updateText() {
		this.setText("Points: " + points);
	}

	public int getPoints() {
		return points;
	}
}
