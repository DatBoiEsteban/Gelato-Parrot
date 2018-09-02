package lists;

public class Stack<T> extends GenericList<T> implements Istackable<T> {
	
	private Nodo<T> Top = getFirst();

	public Nodo<T> getTop() {
		return Top;
	}

	public void setTop(Nodo<T> top) {
		Top = top;
	}

	@Override
	public void Push(T pValor) {
		insert(pValor, 0);
		
	}

	@Override
	public void Pop() {
		remove(0);
		
	}

}
