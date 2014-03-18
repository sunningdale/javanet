package cxy.test;

import java.awt.FontFormatException;

class Animal{										
	void howl(){System.out.println("ガオー"); }									
}										
										
class Dog extends Animal{										
	//void howl(){System.out.println("ワン、ワン"); }									
}										
										
class Chihuahua extends Dog{										
	void howl(){System.out.println("キャン、キャン"); }									
}										
										
public class MainClass{										
	public static void main(String[] args){									
		Dog dog = new Chihuahua();								
		dog.howl();	
		
		try{
			int i = 3/0;
		}catch(ArithmeticException e){
			System.out.println();
		}

	}									
}										
