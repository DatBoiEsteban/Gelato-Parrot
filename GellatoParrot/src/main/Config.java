package main;

public class Config {
	private Long OrderFreq;
	private Long minOrderGen;
	private Long maxOrderGen;
	private Long maxIceCream;
	private Long maxToppings;
	private Long probability;

	public Long getProbability() {
		return probability;
	}

	public void setProbability(Long pProbability) {
		this.probability = pProbability;
	}

	public Long getOrderFreq() {
		return OrderFreq;
	}

	public void setOrderFreq(Long pOrderFreq) {
		OrderFreq = pOrderFreq;
	}

	public Long getMinOrderGen() {
		return minOrderGen;
	}

	public void setMinOrderGen(Long pMinOrderGen) {
		this.minOrderGen = pMinOrderGen;
	}

	public Long getMaxOrderGen() {
		return maxOrderGen;
	}

	public void setMaxOrderGen(Long pMaxOrderGen) {
		this.maxOrderGen = pMaxOrderGen;
	}

	public Long getMaxIceCream() {
		return maxIceCream;
	}

	public void setMaxIceCream(Long pMaxIceCream) {
		this.maxIceCream = pMaxIceCream;
	}

	public Long getMaxToppings() {
		return maxToppings;
	}

	public void setMaxToppings(Long pMaxToppings) {
		this.maxToppings = pMaxToppings;
	}
}
