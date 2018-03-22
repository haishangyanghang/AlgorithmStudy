/*
 * 借助定长的数组实现Queue接口
 */
package dsa;


public class Queue_Array implements Queue{
	public static final int CAPACITY = 1000;//默认数组容量
	protected int capacity;//数组实际容量
	protected Object[] Q;//对象数组
	protected int f = 0;//队首位置
	protected int r = 0;//队尾元素位置
	
	//空队列
	/*
	 * 此处this关键字用于调用本类中的其他构造方法
	 * 1.构造方法不会有返回值，由于构造方法的特殊性，返回类型不需要声明为void（也不能这么做）；
	 * 2.this调用构造方法时需要在无参数的构造方法的第一行使用，否则会报错； 
	 */
	public Queue_Array(){
		this(CAPACITY);
	}
	
	//指定容量的队列创建
	public Queue_Array(int cap){
		capacity = cap;
		Q = new Object[capacity];
	}
	
	//查询当前队列规模
	public int getSize(){
		return (CAPACITY+r-f) % CAPACITY;
	}
	
	//判断队是否为空
	public boolean isEmpty(){
		return (f==r);
	}
	
	//入队
	public void enqueue(Object obj)throws ExceptionQueueFull{
		if(getSize() == CAPACITY -1) throw new ExceptionQueueFull("Queue overflow");
		Q[r] = obj;
		r = (r + 1) % CAPACITY;
		}
	
	//出队
	public Object dequeue(){
		Object elem;
		if(isEmpty()) throw new ExceptionQueueEmpty("意外：队列为空");
		elem = Q[f];
		Q[f] = null;
		f = (f+1) % CAPACITY;
		return elem;
	}
	
	//取队首元素但不删除
	public Object front(){
		if(isEmpty()) throw new ExceptionQueueEmpty("意外：队列为空");
	    return Q[f];	
	}
	
	//遍历，不属于ADT
	public void Traversal(){
		for(int i=f;i<r;i++)
			System.out.print(Q[i] + " ");
		System.out.println();
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
