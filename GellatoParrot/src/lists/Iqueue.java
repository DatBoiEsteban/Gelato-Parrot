package lists;

public interface Iqueue<T> {

	public void enqueue(T pValor);

	public void enqueue(T pValor, int prioridad);

	public T dequeue();
}
