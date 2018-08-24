package lists;

public class IngredientsList {
	private Node First;
	private Node Last;
	private int Length = 0;

	public boolean isEmpty() {
		return Length == 0;
	}

	public Node getFirst() {
		return First;
	}

	public Node getLast() {
		return Last;
	}

	private void update() {
		First.setPrevious(Last);
		Last.setNext(First);
	}

	public void add(Node pNode) {
		if (isEmpty()) {
			First = pNode;
			Last = pNode;
		} else {
			Last.setNext(pNode);
			pNode.setPrevious(Last);
			Last = pNode;
		}
		update();
		Length++;
	}
	/*
	 * public void remove() { First = First.getNext(); update(); Length--; }
	 */
}
