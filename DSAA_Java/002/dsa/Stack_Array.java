package dsa;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * 借助定长数组实现Stack()接口
 * 
 * */

public class Stack_Array implements Stack{
	public static final int CAPACITY = 1024;//定义数组默认容量
	protected int capacity;//数组的实际容量
	protected Object[] S; //对象数组
	protected int top = -1;//栈顶元素位置
	
	//按照默认容量创建栈对象
	public Stack_Array(){
		this(CAPACITY);
	}
	
	//指定容量创建栈对象
	public Stack_Array(int cap){
		capacity = cap;
		S = new Object[capacity];
	}
	
	//获取当前栈的规模
	public int getSize(){
		return (top + 1);
	}
	
	//测试栈是否为空栈
	public boolean isEmpty(){
		return (top < 0);
	}
	
	//入栈
	public void push(Object obj) throws ExceptionStackEmpty{
		if(getSize()== capacity)
			throw new ExceptionStackEmpty("异常，栈溢出");
		S[ ++ top ] = obj;
	}
	
	//取出栈顶元素
	public Object top() throws ExceptionStackEmpty{
		if(isEmpty())
			throw new ExceptionStackEmpty("异常：栈空");
		return S[top];
	}
	
	//出栈
	public Object pop() throws ExceptionStackEmpty{
		Object elem;
		if(isEmpty())
			throw new ExceptionStackEmpty("异常：栈空");
		elem = S[top];
		S[ top -- ] = null;
		return elem;
	}
}
