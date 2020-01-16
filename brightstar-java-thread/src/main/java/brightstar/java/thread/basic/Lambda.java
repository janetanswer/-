package brightstar.java.thread.basic;

public class Lambda {

	public static void main(String[] args) {
		//Thread
//		ThreadDemo thread1 = new ThreadDemo("ThreadDemo1");
//		ThreadDemo thread2 = new ThreadDemo("ThreadDemo2");
//		ThreadDemo thread3 = new ThreadDemo("ThreadDemo3");
//		thread1.start();
//		thread2.start();
//		thread3.start();
		
		//Runnable
//		Thread thread4 = new Thread(new RunnableDemo("RunnableDemo1"));
//		Thread thread5 = new Thread(new RunnableDemo("RunnableDemo2"));
//		Thread thread6 = new Thread(new RunnableDemo("RunnableDemo3"));
//		thread4.start();
//		thread5.start();
//		thread6.start();
		
		//Runnable Lambda
//		Runnable runnable = () -> {
//			for(int i=0;i<15;i++) {
//				System.out.println(Thread.currentThread()+":"+i);
//			}
//			System.out.println("end");
//        };
//        Thread one = new Thread(runnable,"t1");
//        Thread two = new Thread(runnable,"t2");
//        one.start();
//        two.start();
        
        //Lambda: public Thread(Runnable target, String name)
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
