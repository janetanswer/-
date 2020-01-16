package brightstar.java.datastructure.datetime;

import java.time.Duration;
import java.time.LocalTime;

public class JavaTime_LocalTime {
	
	public final static void main(String[] args) {
		
	}
	
	
	/**
	 * 计算两个LocalTime之间的毫秒差
	 * @param start
	 * @param end
	 * @return
	 */
	public static long getDurationMills(LocalTime start,LocalTime end) {
		return Duration.between(start, end).toMillis();
	}

}
