package brightstar.java.thread.basic;

public class RunnableDemo implements Runnable{

	String name; 
	
	public RunnableDemo(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i=0;i<3;i++) {
			System.out.println(name+"-"+i+":"+Thread.currentThread());
		}
	};

}
