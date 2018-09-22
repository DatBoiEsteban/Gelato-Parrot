package lists;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
			First.setPrevious(newNode);
			newNode.setNext(First);
			newNode.setPrevious(Last);
			Last = newNode;

		} else {
			First = newNode;
			Last = First;
		}

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
		} else if (fndNode == Last) {
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
		if (pPosition >= getLength()) {
			add(pValor);
		} else {
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
				searchPointer.setPrevious(newNode);
			} else {
				Nodo<T> prevNode = searchPointer.getPrevious();
				newNode.setNext(searchPointer);
				newNode.setPrevious(prevNode);
				searchPointer.setPrevious(newNode);
				prevNode.setNext(newNode);
			}
			Length++;
		}

		update();

	}

	public String toHash() {
		if (!isEmpty()) {
			String iDString = "";
			Nodo<T> temp = getFirst();
			do {
				iDString += ((Ingredient) temp.getValor()).getiD();
				temp = temp.getNext();
			} while (temp != getFirst());
			StringBuffer sb = new StringBuffer();
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(iDString.getBytes());
				byte[] digest = md.digest();

				for (byte b : digest) {
					sb.append(String.format("%02x", b & 0xff));
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sb.toString();
		}

		return "";
	}
}
