public class StackLL<E> implements StackInt<E> {
	private LinkedList<E> stackData;

	public StackLL() {
		stackData = new LinkedList<>();
	}

  @Override
  public void push(E item) {
    stackData.add(item, 0);
  }

  @Override
  public E pop() {
    return stackData.delete(0).getData();
  }

  @Override
  public E peek() {
    return stackData.get(0).getData();
  }

  @Override
  public boolean isEmpty(){
    return stackData.isEmpty();
  }
}
