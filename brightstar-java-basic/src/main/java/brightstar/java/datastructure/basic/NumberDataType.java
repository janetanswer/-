package brightstar.java.datastructure.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberDataType {
	
	final static Logger logger = LoggerFactory.getLogger(NumberDataType.class);
	
	/**
	 * 整数型: 
	 * 1) byte-Byte
	 * 		默认值:0/null
	 * 		8位长度
	 * 		取值范围-128[1000 0000]取反[0111 1111]补1[1000 0000]]~127[0111 1111]
	 * 		ASCII码表范围内的字符(英文字符、控制字符)占用一个byte的空间
	 * 		在需要节省存储空间的时候可以考虑使用byte类型
	 * 
	 * 2) short-Short 
	 * 		默认值:0/null
	 * 		16位长度
	 * 
	 * 3) int-Integer
	 * 		默认值:0/null
	 * 		32位长度
	 * 		取值范围(-2147483648——2147483647)
	 * 
	 * 4) long-Long
	 * 		64位长度
	 * 		在 32位JVM里运行是非原子的，会出现写高低位的问题。在64位JVM里，事实上的确能保证原子性。
	 * 
	 * 浮点型：
	 * 1) float-Float
	 * 
	 * 1) double-Double
	 * 
	 * 
	 * 类型转换：
	 * 	1) 整数可以直接赋值给byte、short、char，但不能超出取值范围
	 * 	2) byte、short、char参与运算的时候，都会被转成int处理
	 * 	3) 自动类型转换：小类型到大类型的转换(byte→short→int→long→float→double)
	 * 	4) 强制类型转换：大类型转到小类型的时候要在变量前加数据类型
	 * 
	 * */
	
	
	public static void main(String[] args) {
		
		/************************byte初始化********************/
		byte b1 = 65;
		//8进制0开头,16进制0x开头
		byte b2 = 0101;
		byte b3 = 0x41;
		byte b4 = 'A';
		logger.info("{}-{}-{}-{}",b1,b2,b3,b4);
		byte2Bit(b1);
		
		/************************short初始化********************/
		short s1 = -1159;
		short2Bit(s1);
		
		
		/*********************自动类型转换***********************/
		byte bb = -11;
		short ss = bb;
		short2Bit(ss);
		int ii = ss;
		int2Bit(ii);
		
		
		/***************byte计算结果为int类型，需要强制转回byte************/
		byte a = 15;
		byte c = (byte)(a+b1);
	}
	
	
	public static void typeConvert() {
		
	}
	
	
	/**
	 * 将byte类型转成八位的二进制字符串
	 */
	public static String byte2Bit(byte b) {  
		String binary =""  
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)  
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)  
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)  
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1); 
		logger.info("byte[{}]的二进制码为{}",b,binary);
		return binary;
    }
	
	
	/**
	 * 将byte类型转成八位的二进制字符串
	 */
	public static String short2Bit(short b) {  
		String binary ="" 
				+ (short) ((b >> 15) & 0x1) + (short) ((b >> 14) & 0x1)  
                + (short) ((b >> 13) & 0x1) + (short) ((b >> 12) & 0x1)  
                + (short) ((b >> 11) & 0x1) + (short) ((b >> 10) & 0x1)  
                + (short) ((b >> 9) & 0x1) + (short) ((b >> 8) & 0x1)
                + (short) ((b >> 7) & 0x1) + (short) ((b >> 6) & 0x1)  
                + (short) ((b >> 5) & 0x1) + (short) ((b >> 4) & 0x1)  
                + (short) ((b >> 3) & 0x1) + (short) ((b >> 2) & 0x1)  
                + (short) ((b >> 1) & 0x1) + (short) ((b >> 0) & 0x1); 
		logger.info("short[{}]的二进制码为{}",b,binary);
		return binary;
    }

	/**
	 * 将int类型转成八位的二进制字符串,前面为0会省略
	 */
	public static String int2Bit(int i) {
		String binary = Integer.toBinaryString(i);
		logger.info("int[{}]的二进制码为{}",i,binary);
		return binary;
	}
	

}
