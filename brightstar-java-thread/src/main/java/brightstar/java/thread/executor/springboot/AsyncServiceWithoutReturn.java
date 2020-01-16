package brightstar.java.thread.executor.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncServiceWithoutReturn {
	
	Logger logger = LoggerFactory.getLogger(AsyncServiceWithoutReturn.class);
	
	
	@Async()
	public void invoke_noReturn(){
		logger.info("do something async");
		try {
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Async("ThreadPoolTaskExecutor2")
	public void invoke_noReturn_withThreadPoolTaskExecutor2(){
		logger.info("do something async");
		try {
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
