public interface StackInt<E> {
	void push(E obj); // push and return
	E peek();
	E pop();
	boolean isEmpty();
}
