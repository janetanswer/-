package brightstar.java.datastructure.datetime;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class JavaTime_LocalDate {
	
	public final static void main(String[] args) {
		
//		LocalDate ld = LocalDate.of(2019, 12, 9);
//		LocalDate ld1 = LocalDate.of(2019, 12, 9);
//		LocalDate ld2 = LocalDate.from(ld);
//		List<LocalDate> list = new ArrayList<LocalDate>() {{add(ld);add(ld2);}};
//		
//		System.out.println(list.contains(ld));
//		System.out.println(list.contains(ld1));
//		System.out.println(list.contains(ld2));
		
		Map<LocalDateTime,Integer> map = new TreeMap<LocalDateTime,Integer>();
		
		map.put(LocalDateTime.of(2019, 12, 1, 1, 1), 2);
		map.put(LocalDateTime.of(2019, 12, 5, 15, 1), 4);
		map.put(LocalDateTime.of(2019, 12, 5, 1, 1), 3);
		map.put(LocalDateTime.of(2019, 1, 1, 1, 1), 1);
		
		System.out.println(map.toString());
	}

}
