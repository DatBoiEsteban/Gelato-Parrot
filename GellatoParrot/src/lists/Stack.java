package lists;

public class Stack<T> extends GenericList<T> implements Istackable<T> {
	
	private Nodo<T> Top = getFirst();

	public Nodo<T> getTop() {
		return Top;
	}

	public void setTop(Nodo<T> top) {
		Top = top;
	}


	public void Push(T pValor) {
		insert(pValor, 0);
		setTop(getFirst());
	}


	public T Pop() {
		Nodo<T> temp = Top;
		remove(0);
		return temp.getValor();
		
	}

}
