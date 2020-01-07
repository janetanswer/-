package brightstar.java.datastructure.collection.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class JavaUtil_ArrayDeque {
	
	
	/**
	 * 
	 * https://www.cnblogs.com/lxyit/p/9080590.html
	 * https://blog.51cto.com/12098949/1929549
	 * 
	 * ArrayDeque是java中对双端队列的线性实现，可以用作栈和队列：
	 * 用做栈时，性能优于Stack，用于队列时，性能优于LinkedList。
	 * 
	 * 底层通过循环数组实现，数组的任何一点都可能被看作起点或者终点,适用于频繁的随机访问操作。
	 * 初始大小
	 * 
	 * 非线程安全的
	 * 
	 * 不允许放入null元素
	 */
	private static ArrayDeque arrayDeque = new ArrayDeque();
	
	private static ArrayDeque<String> arrayDequeWithInitSize = null;
	
	private static Queue q =null;
	
	
	public final static void main(String[] args) {
		
		init();
		oper();
	}
	
	private static void init() {
		arrayDeque = new ArrayDeque();
		arrayDequeWithInitSize = new ArrayDeque<String>(100);
		
		LinkedList<Integer> llist = new LinkedList<Integer>(Arrays.asList(3, 2, 1));  
		q = Collections.asLifoQueue(llist);  
	}
	private static void oper() {
		
		/*添加元素*/
		System.out.println(q.offer(4));  
	    System.out.println(q);  
	    
	    /*查看栈顶元素，不取*/
	    System.out.println(q.peek());
	    System.out.println(q);  
	    
	    /*获取栈顶元素，取*/
	    System.out.println(q.poll());  
	    System.out.println(q);
	}
	
	

}
