package thread.multiThread;

public class UserThread extends Thread {
	private Gate gate;
	private String name;
	private String address;
	public UserThread(Gate gate , String name, String address){
		
		this.gate = gate;
		this.name = name;
		this.address = address;
		
	} 
	
	public void run(){
		System.out.println(name + " Begin");
		while(true){
			gate.pass(name, address);
		}
			
	}
}
