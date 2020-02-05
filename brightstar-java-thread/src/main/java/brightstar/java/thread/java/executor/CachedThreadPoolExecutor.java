package brightstar.java.thread.java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import brightstar.java.util.random.RandomUtil;

/**
 * @author lixing
 *
 */
public class CachedThreadPoolExecutor {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();
		
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
		
	}

}
