package threads;

import javax.swing.JLabel;

import gui.GameTime;

public class Timer extends Thread {
	private Boolean pause = false;
	private Boolean TimesUp = false;
	GameTime label;

	public int getTime() {
		return label.getTime();
	}

	public Timer(GameTime pLabel) {
		this.setName("Timer Thread");
		label = pLabel;
	}

	public Boolean isTimeUp() {
		return TimesUp;
	}


	public void pauseTimer() {
		pause = true;
	}

	@Override
	public void run() {
			try {
				Thread.sleep(2500);
				while (!pause) {
					if (label.getTime() > 120) {
						TimesUp = true;
					}
					Thread.sleep(500);
					label.setTime(label.getTime() +1);
					Thread.sleep(500);
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
}
