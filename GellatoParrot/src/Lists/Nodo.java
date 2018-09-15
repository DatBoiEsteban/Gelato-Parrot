package lists;

public class Nodo<T> {
	private T Valor	;
	private Nodo<T> Next;
	private Nodo<T> Previous; 
	private int Priority;
	
	public Nodo() {
		 Valor = null;
		 Next = null;
		 Previous = null;
		 Priority =0;	
	}
	
	@Override
	public String toString() {
		return Valor.toString();
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

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



