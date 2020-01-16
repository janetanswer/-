package brightstar.java.datastructure.collection.list.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaUtil_Collections {
	
	static List<String> strlist = new ArrayList<String>() {{add("Kae");add("Aeu");add("Zii");add("zii");add("aeu");}};
	
	static List<String> chStrlist = new ArrayList<String>() {{add("咳嗽");add("阿姨");add("仔细");add("工程");}};

	
	public static final void main(String[] strs) {
		/*排序*/
		sort();
		
		/*获取最大值*/
		System.out.println(Collections.max(strlist));
		
		/*判断两个集合是否有相同元素*/
		System.out.println(Collections.disjoint(strlist, chStrlist));
		System.out.println(Collections.disjoint(strlist, strlist));
		
		/*统计某个对象在Collection中出现的次数*/
		System.out.println(Collections.frequency(strlist, "Kae"));
	
		/*反转*/
		Collections.reverse(strlist);
		System.out.println(strlist);
		
		
		
	}
	

	public static void sort(){
		
		/*数字从小到大排序*/
		List<Long> longlist = new ArrayList<Long>() {{add(5l);add(1l);add(2l);add(8l);}};
		Collections.sort(longlist);
		System.out.println(longlist.toString());
		
		/*英文按编码排序*/
		Collections.sort(strlist);
		System.out.println(strlist.toString());
		
		Collections.sort(chStrlist);
		System.out.println(chStrlist.toString());
		
	}
	
	

}
