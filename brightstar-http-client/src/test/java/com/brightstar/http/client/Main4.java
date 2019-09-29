package com.brightstar.http.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int linenum = 0;
		int linelimit = 0;
		if(sc.hasNext()) {
			String l1 = sc.nextLine();
			String[] l1s = l1.split("\\s+");
			linenum = Integer.parseInt(l1s[0]);
			linelimit = Integer.parseInt(l1s[1]);
		}
		
		int finish = 0;
		List<String> input = new ArrayList<String>();
		while (sc.hasNext()) {
            String str = sc.nextLine();
            input.add(str);
            finish++;
            if(finish==linenum) {
            	break;
            }
        }


		StringBuilder sb = new StringBuilder();
		for(int j=0;j<input.size();j++) {
			sb.append(splitline(input.get(j),linelimit)+"\n");
		}
		System.out.println(sb.substring(0, sb.length()-1).toString());
	}
	
	public static String splitline(String str,int llimit) {
		int ret = 0;
		
		String tmp = str.trim();
		while(tmp.length()>llimit) {
			for(int i=0;i<llimit;i++) {
				
				StringBuilder ls = new StringBuilder(tmp.substring(0, llimit-i));
				StringBuilder le = new StringBuilder(tmp.substring(llimit-i)) ;
				
				if(ls.substring(ls.length()-1,ls.length()).equals(" ") || le.substring(0,1).equals(" ")) {
					ret++;
					tmp = le.toString().trim();
					break;
				}
			}
		}
		
		if(tmp.length()>0) {
			ret++;
		}

		return ret+"";
	}
	
	
	

}
