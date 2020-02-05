package brightstar.java.thread.springboot.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/**
 * ThreadPoolTaskExecutor是最常用的线程池
 * 本质是对java.util.concurrent.ThreadPoolExecutor的包装
 * 
 * 如果在springboot的容器里定义了一个ThreadPoolTaskExecutor，
 * 即使异步服务中@Async没有指定executor名字，也会默认使用这个executor
 * 
 */


@Configuration
@ConfigurationProperties(prefix = "common.threadpool")
public class OrgSpringframeworkSchedulingConcurrent_ThreadPoolTaskExecutor {

	// 线程池维护线程的最少数量
	private int corePoolSize = 2;
	// 线程池维护线程的最大数量，只有队列满了才会扩线程
	private int maxPoolSize = 10;
	// 线程池维护线程所允许的空闲时间
	private int keepAliveSeconds = 5000;
	// 线程池所使用的缓冲队列
	private int queueCapacity = 10;


	@Bean
	public Executor ThreadPoolTaskExecutor1() {
		SimpleAsyncTaskExecutor s = new SimpleAsyncTaskExecutor();
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setThreadNamePrefix("ThreadPoolTaskExecutor1-");
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueCapacity);
		executor.setKeepAliveSeconds(keepAliveSeconds);
		// rejection-policy：当pool已经达到max size的时候，如何处理新任务
		// CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
		// ABORT_POLICY:抛出一个拒绝异常
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		executor.initialize();
		return executor;
	}
	
	
	@Bean
	public Executor ThreadPoolTaskExecutor2() {
		SimpleAsyncTaskExecutor s = new SimpleAsyncTaskExecutor();
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setThreadNamePrefix("ThreadPoolTaskExecutor2-");
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(1);
		executor.setKeepAliveSeconds(keepAliveSeconds);
		// rejection-policy：当pool已经达到max size的时候，如何处理新任务
		// CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
		// ABORT_POLICY:抛出一个拒绝异常
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		executor.initialize();
		return executor;
	}

	

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public int getKeepAliveSeconds() {
		return keepAliveSeconds;
	}

	public void setKeepAliveSeconds(int keepAliveSeconds) {
		this.keepAliveSeconds = keepAliveSeconds;
	}

	public int getQueueCapacity() {
		return queueCapacity;
	}

	public void setQueueCapacity(int queueCapacity) {
		this.queueCapacity = queueCapacity;
	}
}
