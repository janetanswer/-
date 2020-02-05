package brightstar.java.thread.java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import brightstar.java.util.random.RandomUtil;

/**
 * FixedThreadPool:固定数量的线程池
 *
 */
public class FixedThreadPoolExecutor {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("task1:"+Thread.currentThread());
					try {
						Thread.sleep(RandomUtil.genRandomInt(0,5));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("task2:"+Thread.currentThread());
				}
				try {
					Thread.sleep(RandomUtil.genRandomInt(0,5));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("task3:"+Thread.currentThread());
				}
				try {
					Thread.sleep(RandomUtil.genRandomInt(0,5));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
	}
}
