package lists;

public class Queue<T> extends GenericList<T> implements Iqueue<T> {

	@Override
	public void enqueue(T pValor) {
		add(pValor);
		
	}

	@Override
	public void dequeue() {
		remove(0);
		
	}
	

}
