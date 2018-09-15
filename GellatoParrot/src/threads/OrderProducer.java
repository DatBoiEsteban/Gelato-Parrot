package threads;

import lists.*;
import main.Config;

public class OrderProducer extends Thread {
	private int OrderFreq;
	private int minOrderGen;
	private int maxOrderGen;
	private int maxIceCream;
	private int maxToppings;
	private int probability;
	private GenericList<Ingredient> IceCreamL;
	private GenericList<Ingredient> ToppingL;
	private Queue<GenericList<Ingredient>> orders;

	public OrderProducer(Config cfg, GenericList<Ingredient> pIngL) {
		OrderFreq = cfg.getOrderFreq();
		minOrderGen = cfg.getMinOrderGen();
		maxOrderGen = cfg.getMaxOrderGen();
		maxIceCream = cfg.getMaxIceCream();
		maxToppings = cfg.getMaxToppings();
		probability = cfg.getProbability();
		for (int i = 0; i < pIngL.getLength(); i++) {
			Ingredient temp = pIngL.getValue(i);
			if (temp.getType() == "bola") {
				IceCreamL.add(temp);
			} else {
				ToppingL.add(temp);
			}
		}
		genOrders();
	}

	public void genOrders() {
		while (true) {
			int randOrder = (int) (Math.random() * (maxOrderGen - minOrderGen)) + minOrderGen;
			while (randOrder-- > 0) {
				int randProb = (int) (Math.random() * 100 + 1);
				if (randProb > probability) {
					orders.enqueue(randOrderGen());
				} else {
					orders.enqueue(randOrderGen(), (int) randProb / 10);
				}
			}
			try {
				Thread.sleep(OrderFreq * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public GenericList<Ingredient> randOrderGen() {
		GenericList<Ingredient> ord = new GenericList<Ingredient>();
		int randIC = (int) (Math.random() * maxIceCream);
		int randTPP = (int) (Math.random() * maxToppings);
		while (randIC-- > 0) {
			ord.add(getRandIceCream());
		}
		while (randTPP-- > 0) {
			ord.add(getRandTopping());
		}
		return ord;
	}

	public Ingredient getRandIceCream() {
		int rand = (int) (Math.random() * IceCreamL.getLength());
		return IceCreamL.getValue(rand);
	}

	public Ingredient getRandTopping() {
		int rand = (int) (Math.random() * ToppingL.getLength());
		return ToppingL.getValue(rand);
	}
}
