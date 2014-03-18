package cxy.test;

public class Test {

	public static void main(String[] args) {
		float x = 1.0F;
		float y = 0.57F;
		//System.out.println(x + y);
		
		int[] a = new int[5];
		//System.out.println(a[2]);

		String[] test = new String[5];
		//System.out.println(test[0]);
		
		B b = new B();						
		b.methodA();	
	}
}

class A{								
 	public void methodA(){							
		System.out.println("class A methodA");						
	}							
}	


								
class B extends A{								
	public void methodA(){							
		System.out.println("class B methodA");						
	}							
}
