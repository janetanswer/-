package brightstar.java.thread.synchronizedd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CAS {

	private static AtomicReference<String> atomicReference = new AtomicReference<>("A");
	private static AtomicStampedReference<String> stampReference = new AtomicStampedReference<>("A", 1);

	public static void main(String[] args) {

//		demo();
//		aba();
		noaba();
	}

	private static void demo() {

		// 初始值5
		AtomicInteger atomicInteger = new AtomicInteger(5);
		
		// 自旋操作成功
		System.out.println("预期值:5,当前值:" + atomicInteger);
		System.out.println("是否设置成功:" + atomicInteger.compareAndSet(5, 10));

		// 自旋操作失败
		System.out.println("预期值:5,当前值:" + atomicInteger);
		System.out.println("是否设置成功:" + atomicInteger.compareAndSet(5, 15));

		System.out.println("当前值:" + atomicInteger);

	}

	private static void aba() {

		System.out.println("初始值:" + "A");
		
		new Thread(() -> {
			for (int i = 0; i < 15; i++) {
				System.out.println(" t1 <"+i+"> A->B cas ret :" + atomicReference.compareAndSet("A", "B"));
				System.out.println("");
			}
		}, "t1").start();

		new Thread(() -> {
			for (int i = 0; i < 15; i++) {
				System.out.println(" t2 <"+i+"> B->A cas ret :" + atomicReference.compareAndSet("B", "A"));
				System.out.println("");
			}
		}, "t2").start();

	}

	private static void noaba() {
		
		new Thread(() -> {
			int stamp = stampReference.getStamp();
			for (int i = 0; i < 5; i++) {
				System.out.println("t1 <"+i+"> A->B cas ret:" + stampReference.compareAndSet("A", "B", stamp, stamp + 1));
				System.out.println("");
			}
		}, "t1").start();

		new Thread(() -> {
			int stamp = stampReference.getStamp();
			for (int i = 0; i < 5; i++) {
				System.out.println("t2 <"+i+"> B->A cas ret:" + stampReference.compareAndSet("B", "A", stamp, stamp + 1));
				System.out.println("");
			}
		}, "t2").start();

	}
}
