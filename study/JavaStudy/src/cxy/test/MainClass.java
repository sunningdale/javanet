package cxy.test;

import java.awt.FontFormatException;

class Animal{										
	void howl(){System.out.println("�K�I�["); }									
}										
										
class Dog extends Animal{										
	//void howl(){System.out.println("�����A����"); }									
}										
										
class Chihuahua extends Dog{										
	void howl(){System.out.println("�L�����A�L����"); }									
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
