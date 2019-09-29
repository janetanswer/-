package com.brightstar.http.client;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NMain1 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		if(sc.hasNext()) {
			num = Integer.parseInt(sc.nextLine());
		}
		
		List<String> input = new ArrayList<String>();
		if(sc.hasNext()) {
			String str = sc.nextLine();
			String[] strs = str.split("\\s+");
			
			for(int i=0;i<strs.length;i++) {
				input.add(strs[i]);
			}
		}
		
		float f = count(input);
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		System.out.println(decimalFormat.format(f));
		
	}
	
	
	public static float count(List<String> input) {

		
		float f1 = 0.8f;
		float f2 = 0.5f;
		
		float ret = 0.00f;
		for(int i=0;i<input.size();i++) {
			if(ret<100) {
				ret = ret+Float.parseFloat(input.get(i));
			}else if(ret>=100 && ret<150) {
				ret = ret+Float.parseFloat(input.get(i))*f1;
			}else if(ret>=150 && ret<400) {
				ret = ret+Float.parseFloat(input.get(i))*f2;
			}else {
				ret = ret+Float.parseFloat(input.get(i));
			}
		}
		return ret;
				
	}

}
