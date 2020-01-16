package brightstar.java.thread.executor.sprintboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import brightstar.java.thread.executor.springboot.AsyncServiceWithoutReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest {
	
	@Autowired
	AsyncServiceWithoutReturn asyncService; 
	

	@Test
	public void test_1() throws InterruptedException {
		
		for(int i=0;i<5;i++) {
			asyncService.invoke_noReturn();
			asyncService.invoke_noReturn_withThreadPoolTaskExecutor2();
		}
		
		Thread.sleep(10*1000);
	}

}
