package cxy.test;

class AA{								
 	AA(){ System.out.println("AA"); }							
}								
								
class BB extends AA{								
	BB(){ System.out.println("BB"); }							
}								
								
class Test3{								
	public static void main(String[] args){							
	  AA b = new BB();							
	}							
}								
