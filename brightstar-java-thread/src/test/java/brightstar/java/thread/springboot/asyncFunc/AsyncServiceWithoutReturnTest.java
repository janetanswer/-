package brightstar.java.thread.springboot.asyncFunc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import brightstar.java.thread.springboot.asyncFunc.AsyncServiceWithoutReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncServiceWithoutReturnTest {
	
	@Autowired
	AsyncServiceWithoutReturn asyncService; 
	

	@Test
	public void test_() throws InterruptedException {
		
		for(int i=0;i<5;i++) {
			asyncService.invoke_noReturn();
		}
		
		Thread.sleep(10*1000);
	}
	
	@Test
	public void test_1() throws InterruptedException {
		
		for(int i=0;i<5;i++) {
			asyncService.invoke_noReturn_withThreadPoolTaskExecutor1();
		}
		
		Thread.sleep(10*1000);
	}
	
	@Test
	public void test_2() throws InterruptedException {
		
		for(int i=0;i<5;i++) {
			asyncService.invoke_noReturn_withThreadPoolTaskExecutor2();
		}
		
		Thread.sleep(10*1000);
	}
	
	
	

}
