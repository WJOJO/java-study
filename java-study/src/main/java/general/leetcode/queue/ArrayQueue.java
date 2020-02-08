package general.leetcode.queue;

/**
 * À≥–Ú∂”¡–
 * @author javon
 *
 */
public class ArrayQueue<E> {
	
	private Object[] items;
	
	private int n = 0;
	
	private int head = 0;
	private int tail = 0;
	
	public ArrayQueue(int capacity) {
		super();
		this.n = capacity;
	}
	
	public boolean enqueue(E item){
		if(tail == n){
			if(head == 0) return false;
			for (int i = head; i < tail; ++i) {
				items[i - head] = items[i];
			}
			tail -= head;
			head = 0;
		}
		items[tail ++] = item;
		return true;
	}
	
	public E dequeue(){
		if(head == tail)	return null;
		return (E)items[head ++];
	}

}
