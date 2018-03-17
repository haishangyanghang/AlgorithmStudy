package dsa;

/*
 * 测试栈
 */
public class TestStack {
	public static void main(String[] args){
		Stack_Array stack_array = new Stack_Array();
		System.out.println(stack_array.isEmpty());
		stack_array.push(3);
		stack_array.push(6);
		stack_array.push(9);
		stack_array.push(10);
		System.out.println("isEmpty?  --> " + stack_array.isEmpty());
		for(int i=stack_array.getSize();i>0;i--)
			System.out.println(stack_array.pop());
		System.out.println("isEmpty?  --> " + stack_array.isEmpty());		
	}

}
