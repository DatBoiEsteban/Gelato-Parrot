package main;

import gui.GellatoGui;
import lists.Ingredient;
import lists.Stack;
import loader.JsonLoader;
import threads.ThreadManager;

public class GellatoParrot {

	public static void main(String[] args) {
		JsonLoader json = new JsonLoader();
		GellatoGui window = new GellatoGui();
		ThreadManager threadM = new ThreadManager(window, json);
		threadM.start();
		
	}

}
