package threads;

import lists.GenericList;
import lists.Ingredient;
import lists.Queue;
import main.Config;
import consts.I_IngTypes;

public class OrderProducer extends Thread {
	private Long OrderFreq;
	private Long minOrderGen;
	private Long maxOrderGen;
	private Long maxIceCream;
	private Long maxToppings;
	private Long probability;
	private GenericList<Ingredient> IceCreamL = new GenericList<Ingredient>();
	private GenericList<Ingredient> ToppingL = new GenericList<Ingredient>();
	private Queue<GenericList<Ingredient>> orders = new Queue<GenericList<Ingredient>>();
	private boolean ordersReady = false;

	public OrderProducer(Config cfg, GenericList<Ingredient> pIngL) {
		this.setName("Order Producer Thread");
		OrderFreq = cfg.getOrderFreq();
		minOrderGen = cfg.getMinOrderGen();
		maxOrderGen = cfg.getMaxOrderGen();
		maxIceCream = cfg.getMaxIceCream();
		maxToppings = cfg.getMaxToppings();
		probability = cfg.getProbability();
		for (int i = 0; i < pIngL.getLength(); i++) {
			Ingredient temp = pIngL.getValue(i);
			if (temp.getType() == I_IngTypes.HELADO) {
				IceCreamL.add(temp);
			} else {
				ToppingL.add(temp);
			}
		}
	}

	@Override
	public void run() {
		int randOrder = (int) ((int) (Math.random() * (maxOrderGen - minOrderGen)) + minOrderGen);
		int i = 0;
		while (randOrder-- > 0) {
			try {
				int prob = (int) (Math.random() * 100 + 1);
				if (prob > probability) {
					orders.enqueue(randOrderGen());
				} else {
					orders.enqueue(randOrderGen(), (int) (prob / 10));
				}
				ordersReady = true;
				if (i++ > 2) {
					Thread.sleep(OrderFreq * 1000);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private GenericList<Ingredient> randOrderGen() {
		GenericList<Ingredient> ord = new GenericList<Ingredient>();
		int randIC = (int) (Math.random() * maxIceCream + 1);
		int randTPP = (int) (Math.random() * maxToppings + 1);
		while (randTPP-- > 0) {
			ord.add(getRandTopping());
		}
		while (randIC-- > 0) {
			ord.add(getRandIceCream());
		}
		return ord;
	}

	private Ingredient getRandIceCream() {
		int rand = (int) (Math.random() * IceCreamL.getLength());
		return IceCreamL.getValue(rand);
	}

	private Ingredient getRandTopping() {
		int rand = (int) (Math.random() * ToppingL.getLength());
		return ToppingL.getValue(rand);
	}

	public GenericList<Ingredient> getOrder() {
		return orders.getValue(0);
	}

	public void orderDone() {
		orders.dequeue();
	}

	public Boolean areOrdersReady() {
		return ordersReady;
	}

	public int getOrdersLeft() {
		return orders.getLength() - 1;
	}
}
