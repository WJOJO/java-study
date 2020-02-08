package general.leetcode.stack;

/**
 * ˳��ջ--��������ʵ��
 * @author javon
 *
 */
public class SequenceStack<E> {
	
	private static final int INIT_SIZE = 10;
	
	private Object[] data ;
	
	private int top = -1;
	
	public SequenceStack(int initSize) {
		data = new Object[initSize];
	}
	
	public SequenceStack() {
		this(INIT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized E push(E e){
		//����
		if(top >= data.length - 1){
			int newSize = (data.length >> 1) + data.length;
			Object[] tmp = new Object[newSize];
			System.arraycopy(data, 0, tmp, 0, top + 1);
			data = tmp;
		}
		data[++ top] = e;
		return (E) data[top];
	}
	
	@SuppressWarnings("unchecked")
	public synchronized E pop(){
		if(top < -1){
			throw new RuntimeException("ջΪ��");
		}
		return (E)data[ top -- ];
	}

}
