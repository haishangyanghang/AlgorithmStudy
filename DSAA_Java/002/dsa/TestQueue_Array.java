/*
 * 测试栈
 * 
 */
package dsa;

public class TestQueue_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue_Array queue = new Queue_Array();
		System.out.println("The Size of queue is: " + queue.getSize());
		System.out.println("Is Empty: " + queue.isEmpty());
		try{
			queue.enqueue(1);
			queue.enqueue(2);
			queue.enqueue(3);
			queue.enqueue(4);
			queue.enqueue(5);
			queue.enqueue(6);
			
			System.out.println("The Size of queue is: " + queue.getSize());
			System.out.println("Is Empty: " + queue.isEmpty());
			System.out.println("The front element of queue is: " + queue.front());
			queue.Traversal();
			
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			
			System.out.println("The Size of queue is: " + queue.getSize());
			System.out.println("Is Empty: " + queue.isEmpty());
			System.out.println("The front element of queue is: " + queue.front());
		}catch(ExceptionQueueFull e){
			e.printStackTrace();
		}catch (ExceptionQueueEmpty e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
