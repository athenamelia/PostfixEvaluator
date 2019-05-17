public class LinkedList<T>{

	LinkedListNode<T> head;

	public LinkedList(){}

	public LinkedList(LinkedListNode<T> h){
		head = h;
	}

	public LinkedList(T d){
		head = new LinkedListNode<T>(d);
	}

	public void add(T d, int index){
		add(new LinkedListNode<T>(d), index);
	}

	public void add(LinkedListNode<T> node, int index){
		if (index == 0){
			LinkedListNode<T> temp = head;
			head = node;
			head.setNext(temp);
		} else if (index > 0 && index < size()){
			LinkedListNode<T> temp = head;
			for(int i = 0; i < index-1; i++){
				temp = temp.getNext();
			}
			LinkedListNode<T> next = temp.getNext();
			node.setNext(next);
			temp.setNext(node);
		} else {
			if (head == null){
				add(node, 0);
			} else {
				LinkedListNode<T> temp = head;
				for(int i = 0; i < size()-1; i++){
					temp = temp.getNext();
				}
				temp.setNext(node);
			}
		}
	}

	public LinkedListNode<T> get(int index){
		if (index == 0){
			return head;
		} else if (index > 0 && index < size()){
			LinkedListNode<T> temp = head;
			for(int i = 0; i < index; i++){
				temp = temp.getNext();
			}
			return temp;
		} else {
			LinkedListNode<T> temp = head;
			for(int i = 0; i < size()-1; i++){
				temp = temp.getNext();
			}
			return temp;
		}
	}

	public LinkedListNode<T> delete(int index){
		LinkedListNode<T> ret = null;
		if (index == 0){
			if (head != null) {
				ret = head;
				head = head.getNext();
			}
		} else if (index > 0 && index < size()){
			LinkedListNode<T> temp = head;
			for(int i = 0; i < index-1; i++){
				temp = temp.getNext();
			}
			ret = temp.getNext();
			if (temp.getNext() != null){
				temp.setNext(temp.getNext().getNext());
			}

		} else {
			if (head != null){
				LinkedListNode<T> temp = head;
				for(int i = 0; i < size()-2; i++){
					temp = temp.getNext();
				}
				ret = temp.getNext();
				temp.setNext(null);
			}
		}
		return ret;
	}

	public int size() {
		int ret = 0;
		LinkedListNode<T> temp = head;
		while (temp != null){
			ret++;
			temp = temp.getNext();
		}
		return ret;
	}

	public boolean isEmpty(){
		return (head == null);
	}

	public String toString(){
		String ret = "";
		if (head != null) {
			LinkedListNode<T> temp = head;
			while (temp.getNext() != null){
				ret = ret + temp.toString() + " --> ";
				temp = temp.getNext();
			}
			ret = ret + temp.toString();
		}
		return ret;
	}

	/**
	* Method to test the methods we've written so far
	* @param args not used
	*/
	public static void main(String[] args){
		LinkedList<String> test = new LinkedList<String>("begin");
		System.out.println(test.toString());
		System.out.println(test.isEmpty());
		System.out.println(test.size());

		test.add("second", 1);
		System.out.println(test.toString());
		test.add("new start", 0);
		System.out.println(test.toString());
		test.add("new new start", 0);
		System.out.println(test.toString());
		test.add("end", -1);
		System.out.println(test.toString());
		test.add("third", 2);
		System.out.println(test.toString());
		System.out.println(test.isEmpty());
		System.out.println(test.size());

		System.out.println(test.get(0));
		System.out.println(test.get(2));
		System.out.println(test.get(-1));
		System.out.println(test.toString());

		test.delete(0);
		System.out.println(test.toString());
		test.delete(0);
		System.out.println(test.toString());
		test.delete(-1);
		System.out.println(test.toString());
		test.delete(2);
		System.out.println(test.toString());
		System.out.println(test.isEmpty());
		System.out.println(test.size());

		LinkedList<String> empty = new LinkedList<String>();
		System.out.println(empty.toString());
		System.out.println(empty.isEmpty());
		System.out.println(empty.size());
	}
}
