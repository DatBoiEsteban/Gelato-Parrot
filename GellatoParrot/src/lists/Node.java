package lists;

public class Node {
	private Node Next;
	private Node Previous;
	private Ingredient Valor;

	public Node getNext() {
		return Next;
	}

	public void setNext(Node pNext) {
		Next = pNext;
	}

	public Node getPrevious() {
		return Previous;
	}

	public void setPrevious(Node pPrevious) {
		Previous = pPrevious;
	}

	public Ingredient getValor() {
		return Valor;
	}

	public void setValor(Ingredient pValor) {
		Valor = pValor;
	}
}
