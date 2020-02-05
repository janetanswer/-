package brightstar.java.thread.springboot.asyncFunc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncServiceWithFutureTest {

	Logger logger = LoggerFactory.getLogger(AsyncServiceWithFuture.class);
	
	@Autowired
	AsyncServiceWithFuture futureService;
	
	@Test
	public void test() {
		Future<String> future1 = futureService.invoke(1);
		Future<String> future2 = futureService.invoke2(2);
		Future<String> future3 = futureService.invoke3();
		try {
			String ret1 = (String) future1.get(2,TimeUnit.SECONDS);
			String ret2 = (String) future2.get(2,TimeUnit.SECONDS);
			String ret3 = (String) future3.get(2,TimeUnit.SECONDS);
			
			logger.info("{}-{}-{}",ret1,ret3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
