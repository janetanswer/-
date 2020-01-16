package brightstar.java.datastructure.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrueFalseDataType {
	
	final static Logger logger = LoggerFactory.getLogger(TrueFalseDataType.class);
	
	
	/**
	 * ture:1
	 * false:0
	 * 
	 * 1) 关系运算符： ==	!=
	 * 2) 取反运算符：!
	 * 3) 逻辑运算符(短路)： &&	||
	 * 在实际的编程中，我们一般比较少利用按位与("&")、或("|")、异或(" ^ “)对布尔类型进行操作
	 * (因为它们一定会计算两个布尔类型的值，尽管可能在得到第一个类型的值的时候就能获知表达式的结果)，
	 * 更常用的是一种短路运算，名称分别为逻辑与(”&&")、逻辑或("||"),
	 * 在计算出第一个boolean值结果的时候就有可能知道整个运算结果
	 * 
	 * 
	 * */
	static boolean b;
	static Boolean B;
	
	public static void main(String[] args) {
		
		logger.info("---------初始值----------");
		logger.info("boolean的默认值为:{}",b);
		logger.info("Boolean的默认值为:{}",B);
		
		
		
		
	}

}
