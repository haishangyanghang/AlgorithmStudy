/*
 * 当队列满时，对其进行入队操作将抛出该异常
 */

package dsa;

public class ExceptionQueueFull extends RuntimeException{
	public ExceptionQueueFull(String err){
		super(err);
	}
}
