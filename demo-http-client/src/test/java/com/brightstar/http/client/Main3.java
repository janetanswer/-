package com.brightstar.http.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	
	
	public static void main(String[] args) {
		System.out.println(binaryToDecimal(65025));
//		System.out.println(decimal2Binary("1000"));
		
//		char[] c = {'1','0','1','1'};
//		covertc(c,new int[] {1,2});
//		System.out.print(c);
		
//		System.out.print(convertR1("100"));
		
//		System.out.print(1-0.1-0.1-0.1-0.1==0.5);
//		double bear[];
//		
//		Thread r = new Thread();
//		r.suspend();
	}
	
//	int[] change = {51200,58368,29184,12544,
//		     35968,20032,10016,4880,
//			 2248,1252,626,305,
//			 140,78,39,19};

	public static void test(String[] args) {
		List<String> input = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		if (sc.hasNext()) {
            String str = sc.nextLine();
            input.add(str);
		}
		
		int para = decimal2Binary(input.get(0));

		System.out.println(bfs(para));	
	}
	
	/**
	 * @param 初始布局
	 * @return 最小深度
	 */
	public static int bfs(int para) {
		int ret=0;
		
		List<String> c = new ArrayList<>();
		
		List<Integer> already = new ArrayList<Integer>();
		already.add(para);
		if(bingo(""+para)) {
			return 0;
		}
		
		
		
		
		for(int i=0;i<16;i++) {
			
		}
		
		
		return ret;
	}
	
	public static boolean bingo(String x) {
		if(Integer.parseInt(x)==0 || Integer.parseInt(x)==65535) {
			return true;
		}
		return false;
	}
	
	
	public List<Integer> covertAll(int x){
		List<Integer> ret = new ArrayList<Integer>();
		String bi = binaryToDecimal(x);
		ret.add(convertR1(bi));
		ret.add(convertR2(bi));
		ret.add(convertR3(bi));
		ret.add(convertR4(bi));
		
		ret.add(convertC1(bi));
		ret.add(convertC2(bi));
		ret.add(convertC3(bi));
		ret.add(convertC4(bi));
		
		ret.add(convertJ1(bi));
		ret.add(convertJ2(bi));
		ret.add(convertJ3(bi));
		ret.add(convertJ4(bi));
		ret.add(convertJ5(bi));
		ret.add(convertJ6(bi));
		ret.add(convertJ7(bi));
		ret.add(convertJ8(bi));
		ret.add(convertJ9(bi));
		
		return ret;
	}
	
	
	/**
	 * @param 100
	 * @return 61540
	 */
	public static Integer convertR1(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {0,1,2,3});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertR2(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {4,5,6,7});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertR3(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {8,9,10,11});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertR4(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {12,13,14,15});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertC1(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {0,4,8,12});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertC2(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {1,5,9,13});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertC3(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {2,6,10,14});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertC4(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {3,7,11,15});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertJ1(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {0,1,4,5});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertJ2(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {1,2,6,5});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertJ3(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {2,3,6,7});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertJ4(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {4,5,8,9});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertJ5(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {6,5,10,9});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertJ6(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {6,7,10,11});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertJ7(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {8,9,12,13});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertJ8(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {10,9,14,13});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	public static Integer convertJ9(String x) {
		//十进制转二进制
		char[] c = binaryToDecimal(Integer.parseInt(x)).toCharArray();
		//转位第一行
		covertc(c,new int[] {10,11,14,15});
		//二进制转十进制返回
		return decimal2Binary(new String(c));
	}
	
	
	
	
	
	/**
	 * 十进制转二进制
	 */
	public static String binaryToDecimal(int n){
		StringBuilder sb = new StringBuilder();
		for(int i = 15;i >= 0; i--) {
			sb.append(n >>> i & 1);
//			System.out.print(n >>> i & 1);
		}
		return sb.toString();
	}
	
	/**
	 * 二进制转十进制
	 */
	public static int decimal2Binary(String decimal) {
		return Integer.valueOf(decimal,2);
	}
	
	
	public static void covertc(char[] c,int[] locs) {
		for(int i=0;i<locs.length;i++) {
			int loc = locs[i];
			if(c[loc]=='1') {
				c[loc]='0';
			}else {
				c[loc]='1';
			}
		}
		
	}
}
