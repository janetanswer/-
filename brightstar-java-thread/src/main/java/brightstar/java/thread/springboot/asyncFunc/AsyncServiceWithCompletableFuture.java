package brightstar.java.thread.springboot.asyncFunc;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * CompletableFuture提供了非常强大的Future的扩展功能，可以简化异步编程的复杂性，
 * 并且提供了函数式编程的能力，可以通过回调的方式处理计算结果，也提供了转换和组合 CompletableFuture 的方法。
 * 
 * 
 *
 */
@Component
public class AsyncServiceWithCompletableFuture {
	
	Logger logger = LoggerFactory.getLogger(AsyncServiceWithCompletableFuture.class);
	
	
	
	
	/*https://blog.csdn.net/u014203449/article/details/88830287*/
	
	/*https://www.cnblogs.com/cjsblog/p/9267163.html*/
	
	/*正常能回来的服务*/
	@Async("ThreadPoolTaskExecutor1")
	public CompletableFuture<String> invoke(int i){
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        logger.info("hello "+i);
        
        return CompletableFuture.completedFuture("hello "+i);
    }
	
	/*
	 * 不能回来的服务,会抛出 
	 * java.util.concurrent.TimeoutException
	 * */
	@Async("ThreadPoolTaskExecutor1")
	public CompletableFuture<String> invoke2(int i){
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        logger.info("hello "+i);
        return CompletableFuture.completedFuture("hello "+i);
    }
	
	/**
	 * 会抛出异常的服务
	 * 会抛出java.util.concurrent.ExecutionException
	 */
	@Async("ThreadPoolTaskExecutor1")
	public CompletableFuture<String> invoke3(){
       throw new RuntimeException();
    }

}
