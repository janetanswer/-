package brightstar.java.thread.java.future;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<String>{
	
	String name;
	
	public CallableDemo(String name ) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		 Thread.sleep(2000);
	     return this.name;
	}

}
