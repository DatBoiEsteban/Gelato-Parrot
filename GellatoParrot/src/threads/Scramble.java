package threads;

import lists.GenericList;
import lists.Ingredient;
import lists.Scrambler;

public class Scramble extends Thread {
	private GenericList<Ingredient> IngL;
	private Scrambler scrambler;
	private boolean resort = true;
	private GenericList<Ingredient> newIngL;

	public Scramble(GenericList<Ingredient> pIngL) {
		this.setName("Scramble Thread");
		IngL = pIngL;
	}

	public void run() {
		while (true) {
			try {
				if (resort) {
					resort = false;
					scrambler = new Scrambler(IngL);
					newIngL = scrambler.getNewIngL();
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public GenericList<Ingredient> getList() {
		resort = true;
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newIngL;
	}
}
