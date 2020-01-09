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
		init("ele1","ele2","ele3","ele4","ele5");
		arrayList.stream().forEach(x->{System.out.println(x);});
		arrayList.parallelStream().forEach(x->{System.out.println(x);});
	}
	
	private static void init(String ... strings ) {
		arrayList.clear();
		for(int i=0;i<strings.length;i++) {
			arrayList.add(strings[i]);
		}
	}
	
	private static void arraylist_oper_stream() {
		
		/*过滤*/
		List<String> filterRet = arrayList.stream().filter(x->{
			if(x.indexOf("f")==0) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		System.out.println(filterRet.toString());
		
		
	}
	
	
	private static void arraylist_oper_parallelStream() {
		
	}

}
