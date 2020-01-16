package brightstar.java.datastructure.collection.stack;

import java.util.Stack;

public class JavaUtil_Stack {
	
	/**
	 * 后进先出的栈
	 * 是Vector的一个子类，所以底层也是数组，也是线程安全
	 * 当需要使用栈时，Java已不推荐使用Stack,而是更高效的Deque(双端队列)的实现类
	 */
	final static Stack<String> stack = new Stack<String>();
	
	
	public final static void main(String[] args) {
		oper();
	}
	
	public static void oper() {
		//入栈
		stack.push("ele1");
		
		//获取栈顶元素,不出栈
		System.out.println(stack.peek());
		//查询栈中元素
		System.out.println(stack.search("ele1"));
		
		//栈顶元素出栈
		System.out.println(stack.pop());
		System.out.println(stack.search("ele1"));
		
	}

}
