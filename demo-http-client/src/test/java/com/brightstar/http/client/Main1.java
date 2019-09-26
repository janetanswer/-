package com.brightstar.http.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.assertj.core.util.Arrays;

public class Main1 {
	
	
	public static void main(String[] args) {
//		System.out.println(compare("123","132"));
		
		String[] x = new String[] {"123","12","124","441"};
		order(x);
		order(x);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<x.length;i++) {
			sb.append(x[i]);
		}
		System.out.println(sb.toString());
		
	}
	
	public static void test(String[] args) {
		
		List<String> input = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		if (sc.hasNext()) {
            String str = sc.nextLine();
            input.add(str);
		}
		
//		for(int i=0;i<input.size();i++) {
//			System.out.println(input.get(i));
//		}
		
		String[] paras = input.get(0).split("\\s+");
		
		
	}

	public static void order(String[] list) {
		for(int x=0;x<list.length-1;x++) {
			for(int i=0;i<list.length-1;i++) {
				if(compare(list[i],list[i+1])==-1) {
					String temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
				}
			}
		}
		
	}
	
	public static int compare(String x1,String x2) {
		char[] x1c = splitNum(x1);
		char[] x2c = splitNum(x2);
		
		int i = x1c.length<x2c.length?x1c.length:x2c.length;
		for(int j=0;j<i;j++) {
			if(x1c[j]<x2c[j]) {
				return -1;
			}else if(x1c[j]>x2c[j]) {
				return 1;
			}
		}
		if(x1.length()<x2.length()) {
			return -1;
		}else if(x1.length()>x2.length()) {
			return 1;
		}
		return 0;
		
	}
	
	public static List array2List(String[] strs) {
		List ret = new ArrayList<String>();
		for(int i=0;i<strs.length;i++) {
			ret.add(strs[i]);
		}
		return ret;
	}
	
	
	public static char[] splitNum(String str) {
		char[] c = str.toCharArray();
		return c;
	}
	
	
}
