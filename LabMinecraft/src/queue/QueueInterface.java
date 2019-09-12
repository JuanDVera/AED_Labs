package queue;

public interface QueueInterface <T> {
	
	public void add(T element);
	
	public T poll();
	
	public boolean isEmpty();
	
	public T head();
}
