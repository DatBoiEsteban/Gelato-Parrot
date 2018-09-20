package main;

import gui.GellatoUI;
import lists.GenericList;
import lists.Ingredient;
import loader.JsonLoader;
import threads.OrderProducer;

public class GellatoParrot {
	public static void main(String[] args) {
		JsonLoader json = new JsonLoader();
		GellatoUI window = new GellatoUI(json);
		Config cfg = json.getCfg();
		GenericList<Ingredient> ingL = json.getIngL();
		if (window.getStatus()) {
			OrderProducer ordProd = new OrderProducer(cfg, ingL);
			ordProd.start();
		}

	}

}
