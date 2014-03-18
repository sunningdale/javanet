package cxy.test;

class D {
	public  void method11() {
		method22();
		//return "method1";
	}

	private  String method22() {
		return "method2";
	}
}							
								
public class Test2 {
	public void method() {
		D a = new D();
		//System.out.println(method11());
		//System.out.println(method22());
	}
}
