package fac;

public class TestFactorial {
	
	/*
	 * 阶乘函数实现
	 */
	public static long factorial(long n){
		if(n<=1){
			return 1;
		}
		else{
			return n*factorial(n-1);
		}
	}


	//测试阶乘函数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 5;
        System.out.println(factorial(n));
	}
}