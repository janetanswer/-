package brightstar.java.datastructure.collection.list.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrgApacheCommonsCollections4_CollectionUtils {
	
	static final Logger logger = LoggerFactory.getLogger(OrgApacheCommonsCollections4_CollectionUtils.class);
	
	static List<Long> longlist = new ArrayList<Long>() {{add(5l);add(1l);add(2l);add(8l);}};
	static List<String> strlist = null;
	static List<String> strlist2 = new ArrayList<String>();
	
	public static void main(String[] args) {

		System.out.println(CollectionUtils.isEmpty(longlist));
		System.out.println(CollectionUtils.isEmpty(strlist));
		System.out.println(CollectionUtils.isEmpty(strlist));
		
		/**/
		strlist = new ArrayList<String>() {{add("CA");add("MU");}};
		System.out.println(strlist.contains("CA"));
		System.out.println(strlist.contains("FM"));
//		CollectionUtils.containsAny(arg0, arg1);
	
	} 
	

	
	

}
