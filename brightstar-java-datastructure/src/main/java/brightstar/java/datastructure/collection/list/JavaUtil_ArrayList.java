package brightstar.java.datastructure.collection.list;

import java.util.ArrayList;
import java.util.Iterator;

public class JavaUtil_ArrayList {
	

	final static ArrayList<String> arrayList = new ArrayList<String>();
	
	
	
	public final static void main(String[] args) {
		arraylist_oper();
//		arraylist_iter();
	}
	
	
	/** ArrayList: 
	 * 	1. 底层是动态数组。默认的长度是10,满了以后按1.5倍扩容
	 *  2. 有下标的情况下，查找都是O(1),很快。插入和删除操作涉及到数组的copy,在数据量不大的情况下，效率也可以
	 *  3. 非线程安全：因为有个modCount记录集合修改的次数。
	 *  
	 */
	private static void arraylist_oper() {
		//尾部增加元素 O(1)
		arrayList.add("1");
		
		//中间增加元素 O(1)
		arrayList.add(1, "2");
		
		//java.lang.IndexOutOfBoundsException: Index: 5, Size: 2
//		arrayList.add(5,"3");
		
		arrayList.add("4");
		
		//更新特定位置的元素 O(1)
		arrayList.set(2, "3");
		
		//根据位置下标查找元素O(1)
		arrayList.get(1);
		
		//查找元素,因为不清楚该元素存放的下标，所以得从头到尾进行查找。 O(n)
		arrayList.contains("3");

		System.out.println(arrayList.toString());
		
		//arrayList转array
		String[] array = new String[arrayList.size()];
		arrayList.toArray(array);
		for(String s:array) {
			System.out.println(s);
		}
	}
	
	/**
	 * ArrayList以内部类的形式实现Iterator接口
	 * 
	 * 什么时候使用迭代器？
	 * 对集合中的元素进行增加或者删除的时候(clear、remove、add等方法造成集合的size变化)，建议使用迭代器。
	 * iterator在产生的时候，会记录这个集合的修改次数(int expectedModCount = modCount;)
	 * iterator如果发现集合的size发生了变化，就会抛出java.util.ConcurrentModificationException异常
	 * 
	 * */
	private static void arraylist_iter(){
		
		arrayList.add("ele1");
		arrayList.add("ele2");
		arrayList.add("ele3");
		
//		/*java.util.ConcurrentModificationException异常*/
//		Iterator<String> iter= arrayList.iterator();
//		arrayList.remove(0);
//		iter.next();
		
//		Iterator<String> iter= arrayList.iterator();
//		
//		/*获取当前的cursor对应的数据,cursor+1*/
//		System.out.println(iter.next());
//		
//		/*判断是否有下一个元素，cursor和size比较*/
//		System.out.println(iter.hasNext());
//		
//		/*删除当前元素。remove必须在next之后调用。*/
//		iter.next();	//执行完后cursor==2，lastRet==1
//		iter.ree jmove();	//执行完后cursor==1，lastRet==-1
//		iter.next();	//执行完后cursor==2，lastRet==1
		
		for(Iterator<String> iterator = arrayList.iterator(); iterator.hasNext();) {
			String str = iterator.next();
			if(str.equals("ele2")) {
				iterator.remove();
			}
		}
		
		System.out.println(arrayList);
	}
	
	/**
	 * 遍历比较
	 * 当size < 100万时，三种方式性能差别不大；
	 * 当size >= 100万时，for > iterator >= foreach.
	 * 
	 * foreach里进行了modCount的判断，所以不能做会影响集合的size的操作
	 * 
	 */
	private static void arraylist_oper_for() {
		arrayList.add("ele1");
		arrayList.add("ele2");
		arrayList.add("ele3");
		
		for(int i=0;i<arrayList.size();i++) {
			System.out.println(arrayList.get(i));
		}
		
		for(Iterator<String> iterator = arrayList.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		
		arrayList.forEach(x ->{
			System.out.println(x);
		});
	}
	
	

}
