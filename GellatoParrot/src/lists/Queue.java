package lists;

public class Queue<T> extends GenericList<T> implements Iqueue<T> {


	public void enqueue(T pValor) {
		add(pValor);
		  
	}
	public void enqueue(T pValor,int prioridad) {
		Nodo<T> searchpointer=getLast();
		int pos = getLength();
		if (getLength()==0) {
			add(pValor);
		}
		if (getLength()==1) {
			if(searchpointer.getPriority()==0|searchpointer.getPriority()>prioridad) {
				Nodo<T> orden = new Nodo<T>(pValor);
				orden.setNext(searchpointer);
				searchpointer.setPrevious(orden);
				orden.setPrevious(getLast());
				getLast().setNext(orden);
				setLength(getLength()+1);
			}else add(pValor);
		}
		
		while(searchpointer.getPriority()==0|searchpointer.getPriority()>prioridad) {
			if(searchpointer.getPrevious()==getLast()) {
				break;
			}else {
			searchpointer = searchpointer.getPrevious();
			pos--;
			}
		}
		if(pos==1) {
			Nodo<T> orden = new Nodo<T>(pValor);
			orden.setNext(searchpointer);
			searchpointer.setPrevious(orden);
			orden.setPrevious(getLast());
			getLast().setNext(orden);
			setLength(getLength()+1);
			
		}
		Nodo<T> orden = new Nodo<T>(pValor);
		Nodo<T> NextNode = searchpointer.getNext();
		orden.setNext(NextNode);
		searchpointer.setNext(orden);
		orden.setPrevious(searchpointer);
		NextNode.setPrevious(orden);
		setLength(getLength()+1);
		

				
	}

	public void dequeue() {
		remove(0);
		
	}
	

}


