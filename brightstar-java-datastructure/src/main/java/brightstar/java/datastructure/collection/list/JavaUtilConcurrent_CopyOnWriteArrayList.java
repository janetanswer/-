package brightstar.java.datastructure.collection.list;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import brightstar.java.datastructure.datetime.JavaTime_LocalTime;

public class JavaUtilConcurrent_CopyOnWriteArrayList {

	static List<Integer> list = new ArrayList<Integer>();

	/**
	 * list有两种方式实现线程安全：
	 * 1) list = Collections.synchronizedList(list);
	 * 	Synchronized是JVM实现
	 * 	无论读写都会加Synchronized
	 * 
	 * 2) CopyOnWriteArrayList
	 * 	ReentrantLock(可重入锁)是JDK实现，属于Java对象，使用的时候必须有明确的加锁(lock())和解锁(unlock())
	 * 	只有add/remove等操作加锁，get操作不加锁
	 * 	add/remove等操作是新建一个数组，操作在新数组上，当对象较大的时候，频繁的增删会消耗内存，从而引发GC问题
	 * 	适用于写很少读很多的场景
	 * 
	 * 
	 * */

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * 1000次插入+10000次查询：59ms
		 * 10000次查询：46s
		 * */
		init_synchronizedList();
		
		
		/*
		 * 1000次插入+10000次查询：75s
		 * 10000次查询：33s
		 * */
//		init_CopyOnWriteArrayList();
		
		
		LocalTime start = LocalTime.now();
		Random r = new Random();
		Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
            	list.add(i);
            }
            for(int i = 0; i < 10000; i++) {
            	list.get(r.nextInt(1000));
            }
        };
        Thread one = new Thread(runnable);
        Thread two = new Thread(runnable);
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println(list.size());
        LocalTime end = LocalTime.now();
        System.out.println(JavaTime_LocalTime.getDurationMills(start, end));
		
	}

	

	public static void init_synchronizedList() {
		list = Collections.synchronizedList(list);
	}
	

	public static void init_CopyOnWriteArrayList() {
		list = new CopyOnWriteArrayList<Integer>();
	}
}
