package brightstar.java.thread.java;

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
	
	
	public static void main(String[] args) {
		Thread thread4 = new Thread(new RunnableDemo("RunnableDemo1"));
		Thread thread5 = new Thread(new RunnableDemo("RunnableDemo2"));
		Thread thread6 = new Thread(new RunnableDemo("RunnableDemo3"));
		thread4.start();
		thread5.start();
		thread6.start();
		
		/**
		 * Runnable Lambda
		 * Runnable接口包含一个抽象方法:public abstract void run();
		 * */
		Runnable runnable = () -> {
			for(int i=0;i<15;i++) {
				System.out.println(Thread.currentThread()+":"+i);
			}
			System.out.println("end");
        };
        Thread one = new Thread(runnable,"t1");
        Thread two = new Thread(runnable,"t2");
        one.start();
        two.start();
	}

}
