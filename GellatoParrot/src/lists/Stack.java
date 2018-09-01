package lists;

public class Stack<T> extends GenericList<T> implements Istackable<T> {

	@Override
	public void Push(T pValor) {
		insert(pValor, 0);
		
	}

	@Override
	public void Pop(T valor) {
		remove(0);
		
	}

}
