package lists;

public class GenericList<T> {
	private Nodo<T> First;
	private Nodo<T> Last;
	private int Length;

	public GenericList() {
		First = null;
		Last = null;
		Length = 0;
	}

	public Nodo<T> getFirst() {
		return First;
	}

	public void setFirst(Nodo<T> first) {
		First = first;
	}

	public Nodo<T> getLast() {
		return Last;
	}

	public void setLast(Nodo<T> last) {
		Last = last;
	}

	public void setLength(int length) {
		Length = length;
	}

	public boolean isEmpty() {
		return Length == 0;
	}

	public int getLength() {
		return Length;
	}

	private void update() {
		First.setPrevious(Last);
		Last.setNext(First);
	}

	public void add(T pValor) {
		Nodo<T> newNode = new Nodo<T>(pValor);

		if (!isEmpty()) {
			Last.setNext(newNode);
			newNode.setPrevious(Last);
			Last = newNode;
		} else {
			First = newNode;
			Last = newNode;
		}
		update();
		Length++;
	}

	public void remove(int pIndex) {
		int index = 0;
		Nodo<T> fndNode = First;
		while (index < pIndex) {
			fndNode = fndNode.getNext();
			index++;
		}
		Nodo<T> prevNode = fndNode.getPrevious();
		Nodo<T> nextNode = fndNode.getNext();
		if (fndNode == First) {
			First = nextNode;
		}else if(fndNode == Last) {
			Last = prevNode;
		}
		fndNode.setNext(null);
		fndNode.setPrevious(null);
		prevNode.setNext(nextNode);
		nextNode.setPrevious(prevNode);
		Length--;

	}

	public T getValue(int pPosition) {
		Nodo<T> search = First;
		int count = 0;
		while (search != null && pPosition != count) {
			search = search.getNext();
			count++;
		}
		return search.getValor();
	}

	public void insert(T pValor, int pPosition) {
		if (pPosition > getLength() - 1) {
			add(pValor);
		}
		int cont = 0;
		Nodo<T> searchPointer = First;
		Nodo<T> newNode = new Nodo<T>(pValor);
		while (cont != pPosition) {
			searchPointer = searchPointer.getNext();
			cont++;
		}
		if (cont == 0) {
			newNode.setNext(searchPointer);
			First = newNode;
			update();
		} else {
			Nodo<T> prevNode = searchPointer.getPrevious();
			newNode.setNext(searchPointer);
			newNode.setPrevious(prevNode);
			searchPointer.setPrevious(newNode);
			prevNode.setNext(newNode);
		}
		update();
		Length++;
	}
}
