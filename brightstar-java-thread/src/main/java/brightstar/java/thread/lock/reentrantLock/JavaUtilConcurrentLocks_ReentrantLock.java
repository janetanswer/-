package brightstar.java.thread.lock.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

import org.openjdk.jol.info.ClassLayout;

/**
 * ReentrantLock实现了Lock接口。
 * 
 * AbstractQueuedSynchronizer中以队列的形式实现线程之间的同步。
 * ReentrantLock的方法都依赖于AbstractQueuedSynchronizer的实现。
 *
 */
public class JavaUtilConcurrentLocks_ReentrantLock {
	/*https://www.cnblogs.com/liuyun1995/p/8400663.html
	 * https://blog.csdn.net/jiangjiajian2008/article/details/52226189
	 * https://blog.csdn.net/lm1060891265/article/details/81747275
	 * 
	 * blockqueue:https://www.cnblogs.com/WangHaiMing/p/8798709.html
	 * */
	
	public static void main(String[] args) {
		
		String str = "123";
		System.out.println(ClassLayout.parseInstance(str).toPrintable());
		
		ReentrantLock nonfairLock = new ReentrantLock();
		System.out.println(ClassLayout.parseInstance(nonfairLock).toPrintable());
		
		nonfairLock.lock();
		System.out.println(nonfairLock.isLocked());
		System.out.println(ClassLayout.parseInstance(nonfairLock).toPrintable());
		
//		ReentrantLock fairLock = new ReentrantLock(true);
		
		
		System.out.println("end");
	}

}
