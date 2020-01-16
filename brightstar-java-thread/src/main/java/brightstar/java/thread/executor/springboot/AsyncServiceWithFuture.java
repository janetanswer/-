package brightstar.java.thread.executor.springboot;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncServiceWithFuture {
	
	Logger logger = LoggerFactory.getLogger(AsyncServiceWithFuture.class);
	

	public void callFuture() throws InterruptedException, ExecutionException, TimeoutException{
		
		Future<String> future1 = this.invoke(1);
		Future<String> future2 = this.invoke(2);
		Future<String> future3 = this.invoke(3);

		String ret1 = (String) future1.get(5,TimeUnit.SECONDS);
		String ret2 = (String) future2.get(5,TimeUnit.SECONDS);
		String ret3 ="";
		if(future3.isDone()) {
			ret3 = (String) future3.get();
		}
		
		logger.info("{}-{}-{}",ret1,ret2,ret3);
		
	}
	
	
	@Async("ThreadPoolTaskExecutor1")
	public Future<String> invoke(int i){
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        logger.info("hello "+i);
        return new AsyncResult<String> ("hello "+i);
    }
	
	
	
	
	
	
//	
//	Map<Future,Boolean> futures = new HashMap<Future,Boolean>();
//	List<String> rets = new ArrayList<String>();
//	
//	for(int i=0;i<5;i++) {
//		Future<String> future = this.invoke(i);
//		futures.put(future, false);
//	}
//	
//	/*超时时间,单位是s*/
//	long timelimit = 5;
//	LocalTime lt = LocalTime.now().plusSeconds(timelimit);
//	
//	while(LocalTime.now().isBefore(lt)) {			
//		for(int i=0;i<futures.size();i++) {
//			if(futures.get(i).isDone()) {
//				try {
//					String ret = (String) futures.get(i).get();
//					rets.add(i, ret);
//				} catch (InterruptedException e) {
//					logger.error("异步调用服务失败");
//				} catch (ExecutionException e) {
//					logger.error("异步调用服务失败");
//				}finally {
//					futures.remove(i);
//					i--;
//				}
//				
//				
//			}
//		}
//		
//	}

}
