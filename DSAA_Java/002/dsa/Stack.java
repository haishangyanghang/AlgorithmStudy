package dsa;

/**
 *  栈接口
 * */

public interface Stack {
	public int getSize(); //返回栈中元素个数
	public boolean isEmpty();//判断栈是否为空
	public Object top() throws ExceptionStackEmpty;//取栈顶元素，但不删除
	public void push(Object ele);//入栈
	public Object pop() throws ExceptionStackEmpty;//出栈                                                                                                                                                                   
}
