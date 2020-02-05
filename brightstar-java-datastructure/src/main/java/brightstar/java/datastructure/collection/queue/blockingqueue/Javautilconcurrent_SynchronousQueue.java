package brightstar.java.datastructure.collection.queue.blockingqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue类实现了BlockingQueue接口
 *
 * SynchronousQueue是一个内部只能包含一个元素的队列。
 * 插入元素到队列的线程被阻塞，直到另一个线程从队列中获取了队列中存储的元素。
 * 同样，如果线程尝试获取元素并且当前不存在任何元素，则该线程将被阻塞，直到线程将元素插入队列。
 * 
 * SynchronousQueue的内部实现了两个类：
 * 	一个是TransferStack类，使用LIFO顺序存储元素，这个类用于非公平模式；
 * 	还有一个类是TransferQueue，使用FIFI顺序存储元素，这个类用于公平模式。
 * "Nonblocking Concurrent Objects with Condition Synchronization"算法：http://www.cs.rochester.edu/u/scott/synchronization/pseudocode/duals.html
 * 
 * 
 */
public class Javautilconcurrent_SynchronousQueue {
	static SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();
	
	
	public final static void main(String[] args) throws InterruptedException {
		System.out.println("start");

		synchronousQueue.put("123");
		
//		System.out.println(synchronousQueue.take());
	}

}
