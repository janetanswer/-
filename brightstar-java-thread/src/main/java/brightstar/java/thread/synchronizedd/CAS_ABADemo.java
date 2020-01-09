package brightstar.java.thread.synchronizedd;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CAS_ABADemo {
	
	private static AtomicReference<String> atomicReference = new AtomicReference<>("A");
	private static AtomicStampedReference<String> stampReference = new AtomicStampedReference<>("A",1);

	public static void main(String[] args) {
		
//		case1();
//		aba();
		noaba();
	}
	
	private static void case1() {
		
		System.out.println("t1 cas ret:"+atomicReference.compareAndSet("A","B")+" AtomicReference is:"+atomicReference.get());
		System.out.println("t1 cas ret:"+atomicReference.compareAndSet("B","A")+" AtomicReference is:"+atomicReference.get());
		System.out.println("t1 cas ret:"+atomicReference.compareAndSet("B","A")+" AtomicReference is:"+atomicReference.get());
		
	}
	
	private static void aba() {
		
		new Thread(()->{			
			for(int i=0;i<5;i++) {
				System.out.println("t1 cas ret "+i+":"+atomicReference.compareAndSet("A","B")+" AtomicReference is:"+atomicReference.get());
			}
		},"t1").start();
		
		
		new Thread(()->{			
			for(int i=0;i<5;i++) {
				System.out.println("t2 cas ret "+i+":"+atomicReference.compareAndSet("B","A")+" AtomicReference is:"+atomicReference.get());
			}
		},"t1").start();
		
	}
	
	/*https://www.cnblogs.com/dream2true/p/10759763.html*/
	private static void noaba() {
		
		new Thread(()->{			
			int stamp = stampReference.getStamp();
			System.out.println("t1获取到的版本号："+stamp);
			for(int i=0;i<5;i++) {
				System.out.println("t1 cas ret:"+stampReference.compareAndSet("A","B",stamp,stamp+1)+" AtomicReference is:"+stampReference.getReference());
			}
		},"t1").start();
		
		
		new Thread(()->{	
			int stamp = stampReference.getStamp();
			System.out.println("t2获取到的版本号："+stamp);
			for(int i=0;i<5;i++) {
				System.out.println("t2 cas ret:"+stampReference.compareAndSet("B","A",stamp,stamp+1)+" AtomicReference is:"+stampReference.getReference());
			}
		},"t2").start();
		
	}
}
