package brightstar.java.thread.synchronizedd;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {

	public static void main(String[] args) {

		// 初始值5
		AtomicInteger atomicInteger = new AtomicInteger(5);
		atomicInteger.compareAndSet(5, 10);

		// 自旋操作成功
		System.out.println("预期值:5,当前值:" + atomicInteger);
		System.out.println("是否设置成功:" + atomicInteger.compareAndSet(5, 10));
		
		// 自旋操作失败
		System.out.println("预期值:5,当前值:" + atomicInteger);
		System.out.println("是否设置成功:" + atomicInteger.compareAndSet(5, 15));

		System.out.println("当前值:" + atomicInteger);
	}
}
