package com.brightstar.http.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NMain2 {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		if(sc.hasNext()) {
			num = Integer.parseInt(sc.nextLine());
		}
		
		List<String> input = new ArrayList<String>();
		int loc1 = 0;
		if(sc.hasNext()) {
			String str = sc.nextLine();
			String[] strs = str.split("\\s+");
			
			for(int i=0;i<strs.length;i++) {
				if(strs[i].equals("1")) {
					loc1=i;
				}
				input.add(strs[i]);
			}
		}
		
		System.out.println(count(input,loc1));

		
	}
	
	
	public static int count(List<String> input,int loc1) {
		
		int connect=2;
		for(int j=loc1+1;j<input.size();j++) {
			if(Integer.parseInt(input.get(j))==connect) {
				connect++;
			}else {
				break;
			}
		}
		
		
		return input.size()-connect+1;
	}
}
