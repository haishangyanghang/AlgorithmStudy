/*
 * 单链表节点类 
 */

package dsa;

public class Node implements Position{
	private Object element;//链表数据对象
	private Node next;//指向后继节点
	
	/**************************** 构造函数********************************/
	public Node(){
		this(null,null);//似曾相识的this用法，调用该类中的构造方法
	}
	
	public Node(Object e,Node n){
		element = e;
		next = n;
	}
	
	/****************************** Position接口方法*********************************/
	//返回存放于该位置的元素
	public Object getElem(){
		return element;
	}
	
	//将给定元素放置到该位置，返回此前存放的元素
	public Object setElem(Object e){
		Object oldElem = element;
		element = e;
		return oldElem;
	}
	
	/********************************单链表节点方法************************************/
	//取当前节点的后继节点
	public Node getNext(){
		return next;
	}
	
	//修改当前节点的后继节点
	public void setNext(Node newNext) {
		next = newNext;
	}
}
