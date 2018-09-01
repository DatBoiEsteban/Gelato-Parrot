package lists;

public class Nodo<T> {
	private T Valor	;
	private Nodo<T> Next;
	private Nodo<T> Previous; 
	
	public Nodo<T> getPrevious() {
		return Previous;
	}

	public void setPrevious(Nodo<T> previous) {
		Previous = previous;
	}

	public Nodo(T pValor) {
		Valor = pValor;
	}

	public T getValor() {
		return Valor;
	}

	public void setValor(T valor) {
		Valor = valor;
	}

	public Nodo<T> getNext() {
		return Next;
	}

	public void setNext(Nodo<T> next) {
		Next = next;
	}
}



