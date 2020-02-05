package brightstar.java.thread.java;

public class ThreadDemo extends Thread{
	
	String name; 
	
	public ThreadDemo(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i=0;i<3;i++) {
			System.out.println(name+"-"+i+":"+Thread.currentThread());
		}
	};

	
	public static void main(String[] args) {
		ThreadDemo thread1 = new ThreadDemo("ThreadDemo1");
		ThreadDemo thread2 = new ThreadDemo("ThreadDemo2");
		ThreadDemo thread3 = new ThreadDemo("ThreadDemo3");
		thread1.start();
		thread2.start();
		thread3.start();	
		
		
		/**
		 * Lambda: public Thread(Runnable target, String name)
		 * Runnable接口包含一个抽象方法:public abstract void run();
		 * */
	    new Thread(()->{
	    	for(int i=0;i<15;i++) {
				System.out.println(Thread.currentThread()+":"+i);
			}
	    	System.out.println("t1 end");
	    },"t1").start();
	    new Thread(()->{
	    	for(int i=0;i<15;i++) {
				System.out.println(Thread.currentThread()+":"+i);
			}
	    	System.out.println("t2 end");
	    },"t2").start();
	}
	
	
	
}
