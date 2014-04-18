package base.extend;

public class SonClass1 extends SuperClass1{
	
	public String name = "1234";
	
	public SonClass1(){
		System.out.println("SonClass1 Constructor");
	}
	
	public void display(){
		System.out.println("this is display");
	}

	public void look(){
		System.out.println("this is son class's look");
	}
	
	public static void main(String[] agrs){
		SuperClass1 parent = new SuperClass1();
		parent.show();
		parent.look();
		System.out.println(parent.name);
		System.out.println("-------------------");
		SonClass1 son = new SonClass1();
		son.show();
		son.display();
		son.look();
		System.out.println(son.name);
		System.out.println("-------------------");
		SuperClass1 parent1 = new SonClass1();
		parent1.show();
		parent1.look();
		System.out.println(parent1.name);
		// parent1.display(); TODO error
		System.out.println("-------------------");

// result:
//		SuperClass1 Constructor
//		this is show
//		this is super class's look
//		-------------------
//		SuperClass1 Constructor
//		SonClass1 Constructor
//		this is show
//		this is display
//		this is son class's look
//		-------------------
//		SuperClass1 Constructor
//		SonClass1 Constructor
//		this is show
//		this is son class's look
//		-------------------

	}

}
