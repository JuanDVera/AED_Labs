package stack;

public interface StackInterface<T> {
	
	public void push(T elemento);
	
	public T pop();
	
	public boolean isEmpty();
	
	public T top();	
}
