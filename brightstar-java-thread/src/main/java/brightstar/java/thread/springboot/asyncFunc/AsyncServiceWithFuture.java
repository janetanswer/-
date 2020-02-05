package brightstar.java.thread.springboot.asyncFunc;

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
	
	
	/*正常能回来的服务*/
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
	
	/*
	 * 不能回来的服务,会抛出 
	 * java.util.concurrent.TimeoutException
	 * */
	@Async("ThreadPoolTaskExecutor1")
	public Future<String> invoke2(int i){
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        logger.info("hello "+i);
        return new AsyncResult<String> ("hello "+i);
    }
	
	/**
	 * 会抛出异常的服务
	 * 会抛出java.util.concurrent.ExecutionException
	 */
	@Async("ThreadPoolTaskExecutor1")
	public Future<String> invoke3(){
       throw new RuntimeException();
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
