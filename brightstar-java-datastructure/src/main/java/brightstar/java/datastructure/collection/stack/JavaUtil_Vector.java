package brightstar.java.datastructure.collection.stack;

import java.util.Enumeration;
import java.util.Vector;

public class JavaUtil_Vector {
	
	/**
	 * Vector:
	 * 	1.底层是动态数组
	 * 	2.线程安全 synchronized
	 */
	static Vector<String> vector = new Vector<String>();
	
	
	public final static void main(String[] args) {
		vector_create();
		oper();
		vector2Enum();
		
	}
	
	private static void vector_create() {
		/*容量由系统管理,初始容量是10*/
		vector = new Vector<String>();
		System.out.println(vector.capacity());
		
		/*指定初始容量*/
		vector = new Vector<String>(100);
		System.out.println(vector.capacity());
	}
	
	private static void oper() {
		vector.add("enum1");
		vector.remove(0);
		vector.add("enum2");
		vector.add("enum1");
	}
	
	private static void vector2Enum() {
		Enumeration<String> elements = vector.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
	}
	
	



}
