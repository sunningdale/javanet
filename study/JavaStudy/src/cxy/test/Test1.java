package cxy.test;

class C{										
	public C() { System.out.println("default constructor"); }									
	public C(String s){									
	  this();									
	  System.out.println(s);									
	}									
}										
										
public class Test1{										
	public static void main(String[] args){									
	  C a = new C ("Hello");									
	}									
}										
