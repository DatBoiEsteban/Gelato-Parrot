package threads;

import gui.FinishedWindow;
import gui.GellatoGui;
import lists.GenericList;
import lists.Ingredient;
import lists.Queue;
import loader.JsonLoader;

public class ThreadManager extends Thread {
	private GellatoGui window;
	private JsonLoader json;
	private Scramble scrambler;
	private OrderProducer OrderProd;
	private int secondsPerOrder;

	public ThreadManager(GellatoGui ui, JsonLoader pJson) {
		this.setName("ThreadManager Thread");
		window = ui;
		json = pJson;
		scrambler = new Scramble(json.getIngL());
		scrambler.start();
		OrderProd = new OrderProducer(json.getCfg(), json.getIngL());
		OrderProd.start();
		while (!OrderProd.areOrdersReady()) {
			try {
				Thread.sleep(30);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		window.setCurrentOrder(OrderProd.getOrder());
		window.addButtons(scrambler.getList());
	}

	public void run() {
		while (true) {
			window.setOrdersLeft(OrderProd.getOrdersLeft());
			if (window.isSendOrderPressed()) {
				if (window.getCurrentOrder().toHash().equalsIgnoreCase(window.getCone().toHash())) {
					window.setOrderStatus();
				}
				window.SendOrderUnpress();
			}
			if (window.doResort()) {
				window.changePoints(window.getCone().getLength());
				window.resetCone();
				window.resetOrderStatus();
				window.addButtons(scrambler.getList());
				window.incrementOrdersDone();
				OrderProd.orderDone();
				window.setCurrentOrder(OrderProd.getOrder());
			}

			if (window.getOrdersLeft() == 0) {
				System.exit(0);
			}

		}
		// FinishedWindow fw = new FinishedWindow();

	}
}
