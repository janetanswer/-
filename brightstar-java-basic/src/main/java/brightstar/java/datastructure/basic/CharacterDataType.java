package brightstar.java.datastructure.basic;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharacterDataType {
	final static Logger logger = LoggerFactory.getLogger(CharacterDataType.class);
	
	/**
	 * 存放字符的数据类型
	 * 	1)char/Character
	 * 		char也可以看成一种特殊的整型
	 * 		默认值:空字符(这个不是'',也不是空格,在ASCII中是NUL)/null
	 * 		16位，最小值0000(0)，最大值ffff(65535)
	 * 		GB2312、GBK、BIG5码表内字符占用一个char;Unicode-2码表内字符占用一个char
	 * 
	 * 	2)String
	 * 		是一个char[]
	 * 		a="b":a是一个成员变量在堆里 ,局部变量在栈里;b在常量池里 
	 * 
	 * 	3)StringBuilder/StringBuffer
	 * 		StringBuffer线程安全、慢
	 * 		StringBuilder线程不安全、快
	 * 
	 * 
	 * 类型转换
	 * 1) char能够自动转换成int
	 * 
	 * */

	static char c;
	public static void main(String[] args) {
		
		/************初始化***************/
		logger.info("char的默认值是空字符:[{}],对应的ASCII值:{}",c,(int)c);
		
		char c1=65;
		char c2='A';
		char c3='我';
		logger.info("{}[unicode:{}]-{}[unicode:{}][{}]",c2,(int)c2,c3,(int)c3,NumberDataType.int2Bit((int)c3));
	
		String s1="ABC你";
		String s2=new String("124");

		string_Function();
	}
	
	
	public static void string_Function() {
		String str = "key";

		/*String转成char数组*/
		char[] cArray = str.toCharArray();
		
		/*isEmpty会将null和""判断为true*/
		System.out.println(StringUtils.isEmpty(null));
		System.out.println(StringUtils.isEmpty(""));
		
		/*isBlank判断比isEmpty要多，如果没有有效字符，也判断为true*/
		System.out.println(StringUtils.isBlank(null));
		System.out.println(StringUtils.isBlank(""));
		System.out.println(StringUtils.isBlank(" "));
	}
	

	
	

}
