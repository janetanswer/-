package brightstar.java.thread.java.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lixing
 * JDK5新增了Future接口，用于接收异步执行的结果。
 * 但对结果的获取方式却不是很方便，只能通过轮询或者阻塞的方式获取。
 * 轮询耗费CPU，阻塞不能控制响应时间
 *
 */
public class FutureDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		FutureTask<String> task1 = new FutureTask<String>(new CallableDemo("c1"));
		FutureTask<String> task2 = new FutureTask<String>(new CallableDemo("c2"));
		
		//Lambda
		FutureTask<String> task3 = new FutureTask<>(() -> {
			return "something";
		}); 
		
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		Thread thread3 = new Thread(task3);
		
		thread1.start();
		System.out.println(task1.get(3, TimeUnit.SECONDS));
		
		thread3.start();
		System.out.println(task3.get(1, TimeUnit.SECONDS));
		
		/*java.util.concurrent.TimeoutException*/
		thread2.start();
		System.out.println(task2.get(1, TimeUnit.SECONDS));
		

		
		
		
	
	}

}
