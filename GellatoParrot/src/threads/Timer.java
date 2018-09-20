package threads;

import javax.swing.JLabel;

public class Timer extends Thread {
	private Timer instance = null;
	private int time = 0;
	private Boolean pause = true;
	private Boolean TimesUp = false;
	JLabel label;

	public int getTime() {
		return time;
	}

	public Timer(JLabel pLabel) {
		label = pLabel;
	}

	public Boolean getTimesUp() {
		return TimesUp;
	}

	public void resumeTimer() {
		pause = false;
	}

	public void pauseTimer() {
		pause = true;
	}
	
	@Override
	public void run() {
		try {
			while (!pause) {
				if (time > 120) {
					TimesUp = true;
				}
				Thread.sleep(500);
				label.setText("Tiempo: " + time++ + "s");
				Thread.sleep(500);
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
