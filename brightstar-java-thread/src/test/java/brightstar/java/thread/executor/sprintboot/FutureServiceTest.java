package brightstar.java.thread.executor.sprintboot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import brightstar.java.thread.executor.springboot.AsyncServiceWithFuture;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FutureServiceTest {

	Logger logger = LoggerFactory.getLogger(AsyncServiceWithFuture.class);
	
	@Autowired
	AsyncServiceWithFuture futureService;
	
	@Test
	public void test() throws InterruptedException, ExecutionException, TimeoutException {
		futureService.callFuture();
		
		Thread.sleep(10*1000);
	}
}
