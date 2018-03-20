/*
 * 队列接口
 * 
 */


package dsa;

public interface Queue {
	public int getSize();//返回队列中元素个数
	public boolean isEmpty();//队列是否为空
	public Object front() throws ExceptionQueueEmpty;//取队首元素，但不删除,若为空队则抛出对空异常
	public void enqueue(Object obj) throws ExceptionQueueFull;//入队，若满则抛出队满异常
	public Object dequeue()throws ExceptionQueueEmpty;//出队，若为空队则抛出对空异常
	public void Traversal();//遍历    
}
