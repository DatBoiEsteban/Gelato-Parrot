package lists;

public class IngredientsList {
	private Node First;
	private Node Last;
	private int Length;

	public IngredientsList() {
		First = null;
		Last = null;
		Length = 0;
	}

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

	public int getLength() {
		return Length;
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

	public void insert(Node pNode, int pIndex) {
		Node SearchPointer = First;
		Node PreviousPointer = null;
		int posSP = 0;
		if (pIndex < Length) {
			while (posSP++ < pIndex) {
				PreviousPointer = SearchPointer;
				SearchPointer = SearchPointer.getNext();
			}
			if (SearchPointer != First) {
				pNode.setNext(SearchPointer);
				SearchPointer.setPrevious(pNode);
				PreviousPointer.setNext(pNode);
				pNode.setPrevious(PreviousPointer);
			} else {
				First = pNode;
				First.setNext(SearchPointer);
				SearchPointer.setPrevious(First);
				if (Length == 1) {
					Last = First.getNext();
				}
				update();
			}
		} else {
			add(pNode);
		}
		Length++;
	}

	public void remove(int pIndex) {
		int index = 0;
		Node fndNode = First;
		while (index < pIndex) {
			fndNode = fndNode.getNext();
			index++;
		}
		Node prevNode = fndNode.getPrevious();
		Node nextNode = fndNode.getNext();
		prevNode.setNext(nextNode);
		nextNode.setPrevious(prevNode);
		Length--;
	}

	public Ingredient getIngredient(int pIndex) {
		return getNode(pIndex).getValor();

	}

	public Node getNode(int pIndex) {
		int index = 0;
		Node fndNode = First;
		while (index < pIndex) {
			fndNode = fndNode.getNext();
			index++;
		}
		return fndNode;

	}
}
