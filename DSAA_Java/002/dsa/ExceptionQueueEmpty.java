/*
 * 当试图对空队列进行出队操作和取队首操作时抛出该异常
 */
package dsa;

public class ExceptionQueueEmpty extends RuntimeException{
	public ExceptionQueueEmpty(String err){
		super(err);
	}
}
