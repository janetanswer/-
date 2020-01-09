package brightstar.java.thread.basic;

public class ThreadDemo extends Thread{
	
	String name; 
	
	public ThreadDemo(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(name+"-"+i+":"+Thread.currentThread());
		}
	};

	

}
