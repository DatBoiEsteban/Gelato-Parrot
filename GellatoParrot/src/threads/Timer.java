package threads;

public class Timer extends Thread {
	private int time = 0;

	public Timer() {
		while (time < 121) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time++;
		}
	}

	public int getTime() {
		return time;
	}
	
}
