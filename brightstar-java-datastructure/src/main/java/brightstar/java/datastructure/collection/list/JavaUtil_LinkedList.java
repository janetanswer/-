package brightstar.java.datastructure.collection.list;

import java.util.LinkedList;

public class JavaUtil_LinkedList {
	
	final static LinkedList<String> linkedList = new LinkedList<String>();
	
	
	public final static void main(String[] args) {
		linkedlist_oper();
	}
		
	/**	
	 * LinkedList: 
	 * 	1.实现了 Deque 接口(double ended queue 双端队列：既可以当栈使用，也可以当做队列使用)，主要是对首尾元素的添加删除方法
	 * 	2.底层是双向链表，访问不快，插入和删除操作只涉及前后节点的操作，所以效率较高
	 * 	3.非线程安全。
	 * 
	 * 	这个对象用的不多。用做List的时候get的效率较低；用做堆栈时，效率又不如ArrayDeque
	 * 
	*/
	private static void linkedlist_oper() {
		//头部插入数据O(1)
		linkedList.addFirst("First");
		
		//尾部插入数据O(1)
		linkedList.addLast("Last");
		
		//尾部插入数据O(1)
		linkedList.add("random1");
		
		/*
		 * 中间插入数据O(n)。
		 * 实际是根据元素的位置是在前半段还是后半段来决定从前开始找还是从后开始找
		 * */
		linkedList.add(2, "Second");
		
		System.out.println(linkedList.toString());
		
		//java.lang.IndexOutOfBoundsException: Index: 10, Size: 5
//		linkedList.add(10, "Second");
		
		//删除头部数据O(1)
		linkedList.remove();
		
		/*
		 * 中间删除数据O(n)。
		 * 实际是根据元素的位置是在前半段还是后半段来决定从前开始找还是从后开始找
		 * */
		linkedList.remove(2);
		
		/*
		 * 中间删除数据O(n)。
		 * 从头找到尾，确定元素后进行删除操作
		 * */
		linkedList.remove("X");
		
		System.out.println(linkedList.toString());
	}
	


}
