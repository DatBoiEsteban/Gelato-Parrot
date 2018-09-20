package lists;

public class Scrambler {
	GenericList<Ingredient> newIngL = new GenericList<Ingredient>();
	

	public Scrambler(GenericList<Ingredient> ingL) {
		GenericList<Ingredient> temp = new GenericList<Ingredient>();
		for(int i = 0; i < ingL.getLength(); i++) {
			temp.add(ingL.getValue(i));
		}
		while (!temp.isEmpty()) {
			int rand = ((int) (Math.random() * temp.getLength()));
			newIngL.add(temp.getValue(rand));
			temp.remove(rand);
		}
	}

	public GenericList<Ingredient> getNewIngL() {
		return newIngL;
	}

}
