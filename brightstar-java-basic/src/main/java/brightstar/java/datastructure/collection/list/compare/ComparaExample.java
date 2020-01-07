package brightstar.java.datastructure.collection.list.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import brightstar.java.datastructure.collection.list.util.OrgApacheCommonsCollections4_CollectionUtils;

public class ComparaExample {
	
	static final Logger logger = LoggerFactory.getLogger(OrgApacheCommonsCollections4_CollectionUtils.class);
	
	
	
	
	public static final void main(String[] strs) {
		PersonBean youngp = new PersonBean("Young",10);
		PersonBean oldp = new PersonBean("Old",50);
		PersonBean middlep = new PersonBean("Middle",30);
		
		/**
		 * 内部排序：年龄排序
		 * */
		List<PersonBean> ps = new ArrayList<PersonBean>() {{add(youngp);add(oldp);add(middlep);}};
		Collections.sort(ps);
		System.out.println(ps.toString());
		
		
		/**
		 * 外部排序：姓名排序
		 * 1.对象没有实现Comparable接口进行内部排序，又不能修改
		 * 2.对象虽然实现了内部排序，但排序方式不是应用希望的方式
		 * */
		Collections.shuffle(ps);
		Collections.sort(ps, new Comparator<PersonBean>() {
            public int compare(PersonBean o1, PersonBean o2) {
                return o2.getName().charAt(0) - o1.getName().charAt(0);
            }
        });
		System.out.println(ps.toString());
	}
	
	

}
