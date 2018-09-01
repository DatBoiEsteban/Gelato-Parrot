package main;

public class Config {
	private int OrderFreq;
	private int minOrderGen;
	private int maxOrderGen;
	private int maxIceCream;
	private int maxToppings;
	private int probability;

	public int getProbability() {
		return probability;
	}

	public void setProbability(int pProbability) {
		this.probability = pProbability;
	}

	public int getOrderFreq() {
		return OrderFreq;
	}

	public void setOrderFreq(int pOrderFreq) {
		OrderFreq = pOrderFreq;
	}

	public int getMinOrderGen() {
		return minOrderGen;
	}

	public void setMinOrderGen(int pMinOrderGen) {
		this.minOrderGen = pMinOrderGen;
	}

	public int getMaxOrderGen() {
		return maxOrderGen;
	}

	public void setMaxOrderGen(int pMaxOrderGen) {
		this.maxOrderGen = pMaxOrderGen;
	}

	public int getMaxIceCream() {
		return maxIceCream;
	}

	public void setMaxIceCream(int pMaxIceCream) {
		this.maxIceCream = pMaxIceCream;
	}

	public int getMaxToppings() {
		return maxToppings;
	}

	public void setMaxToppings(int pMaxToppings) {
		this.maxToppings = pMaxToppings;
	}
}
