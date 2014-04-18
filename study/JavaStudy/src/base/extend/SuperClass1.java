package base.extend;

public class SuperClass1 {
	
	public String name = "123";

	public SuperClass1(){
		System.out.println("SuperClass1 Constructor");	
	}
	
	public SuperClass1(String name){
		System.out.println("SuperClass1 Constructor:"+name);	
	}
	
	public void show(){
		System.out.println("this is show");
	}
	
	public void look(){
		
		System.out.println("this is super class's look");
	}
	

}
