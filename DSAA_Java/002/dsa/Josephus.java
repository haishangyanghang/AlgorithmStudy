/*
 * Josephu环的实现
 * 俗称“烫手的山芋”游戏 
 */
package dsa;
import java.io.*;

public class Josephus {
	
	//利用队列结构模拟Josephu环
	public static Object Josephu(Queue Q, int k){
		if(Q.isEmpty())
			return null;
		while(Q.getSize()>1){
			//不断迭代
			Q.Traversal();//显示当前的环
			for(int i=0;i<k;i++)//将山芋向前传递k次
				Q.enqueue(Q.dequeue());
			Object e = Q.dequeue();//山芋在手之人退出
		    System.out.println("\n\t" + e + "退出");
		}
		return Q.dequeue();//山芋在手的最后一个孩子
	}
	
	//将一组对象组织为一个队列
	public static Queue buildQueue(Object a[]){
		Queue Q = new Queue_Array();
		for(int i=0;i<a.length;i++){
			Q.enqueue(a[i]);
		}
		return Q;
	}

	//Main方法
	public static void main(String[] args){
		String[] kid = {"Alice","Bob","LiLi","Hope","Jack","Tom","Tony","Kim","Liudehau","Kruad"};
		System.out.println("最终的幸运者是 "+Josephu(buildQueue(kid), 8));
	}
}
