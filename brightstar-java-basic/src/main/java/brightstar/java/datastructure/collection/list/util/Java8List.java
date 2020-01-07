package brightstar.java.datastructure.collection.list.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/qq_28410283/article/details/80601495
 *
 * JAVA8 Predicate【断言】接口
 */
public class Java8List {
	
	final static ArrayList<String> arrayList = new ArrayList<String>();
	
	public final static void main(String[] args) {

		
	}
	
	private static void arraylist_oper_stream() {
		arrayList.add("ele1");
		arrayList.add("ele2");
		arrayList.add("ele3");
		arrayList.add("f1");
		arrayList.add("f2");
		arrayList.add("f3");
		
		/*过滤*/
		List<String> filterRet = arrayList.stream().filter(x->{
			if(x.indexOf("f")==0) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		System.out.println(filterRet.toString());
		
		/**/
		
		
	}
	
	
	private static void arraylist_oper_parallelStream() {
		
	}

}
