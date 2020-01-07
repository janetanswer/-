package brightstar.java.basic.opeator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bit {

	final static Logger logger = LoggerFactory.getLogger(Bit.class);
	
	/**
	 * 1.位运算是直接操作二进制，在性能要求高的场合使用
	 * 位运算符：
	 * 	与（&）
	 * 	非（~）
	 * 	或（|）
	 * 	异或（^）
	 * 位移运算：
	 * 	<<带符号左移: m<<n(数字m在无溢出的前提下乘以2的n次方)
	 * 	>>带符号右移: m>>n(数字m除以2的n次方，原来是正数的还是正数，负数还是负数)
	 *  >>>无符号右移: m>>>n(同右移，但是结果全变正数)
	 *  
	 *  
	 *  2.二进制
	 *  https://www.cnblogs.com/kendn/p/8276560.html
	 *  
	 * */
	public final static void main(String[] args) {
		
		logger.info("---------运算符 按位与 &----------");
		/*&两边都为true,则结果为true*/
		logger.info("true&true结果为:{}",true&true);
		logger.info("true&false结果为:{}",true&false);
		logger.info("false&false结果为:{}",false&false);
		
		logger.info("---------运算符 按位或 |----------");
		/*|两边只要有一个为true,则结果为true*/
		logger.info("true|true结果为:{}",true|true);
		logger.info("true|false结果为:{}",true|false);
		logger.info("false|false结果为:{}",false|false);
		
		logger.info("---------运算符 按位异或 ^----------");
		/*|两边不一致，结果为true*/
		logger.info("true^true结果为:{}",true^true);
		logger.info("true^false结果为:{}",true^false);
		logger.info("false^false结果为:{}",false^false);
		
		logger.info("---------交换整数1-5----------");
		swapInt(1,5);
		
		logger.info("---------判断奇偶，77是{},286是{}----------",isOddNumber(77),isOddNumber(286));
		

	} 
	
	/**
	 * 利用异或(^)交换两个整数
	 * */
	public static void swapInt(Integer a,Integer b) {
		a = a^b;
		b = b^a;
		a = a^b;
		logger.info("交换整数结果为：{}-{}",a,b);
	}
	
	/**
	 * 利用与(&)判断整数是基数还是偶数
	 */
	public static boolean isOddNumber(int i) {
		if((i & 1) == 1) return true;
		return false;
	}
	
	

}
