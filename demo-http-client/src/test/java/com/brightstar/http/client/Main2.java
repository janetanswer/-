package com.brightstar.http.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main2 {
	
	
//	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(0);
//		list.add(2);
//		list.add(7);
//		list.add(6);
//		list.add(1);
//		
//		System.out.println(max(list));
//	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		if(sc.hasNext()) {
			num = Integer.parseInt(sc.nextLine());
		}
		
		int finish = 0;
		List<String> input = new ArrayList<String>();
		while (sc.hasNext()) {
            String str = sc.nextLine();
            input.add(str);
            finish++;
            if(finish==num*4) {
            	break;
            }
        }
		
		List inputList = splitbyNum(input,4);
		
		for(int i=0;i<inputList.size();i++) {
			List l = (List) inputList.get(i);
			List<Integer> il = new ArrayList<Integer>(); 
			String[] l1 = ((String)l.get(0)).split("\\s+");
			String[] l2 = ((String)l.get(1)).split("\\s+");
			String[] l3 = ((String)l.get(2)).split("\\s+");
			String[] l4 = ((String)l.get(3)).split("\\s+");

			
			List<Integer> out = new ArrayList<Integer>();
			out.add(Integer.parseInt(l1[0]));
			out.add(Integer.parseInt(l1[1]));
			out.add(Integer.parseInt(l1[2]));
			out.add(Integer.parseInt(l1[3]));
			out.add(Integer.parseInt(l2[3]));
			out.add(Integer.parseInt(l3[3]));
			out.add(Integer.parseInt(l4[3]));
			out.add(Integer.parseInt(l4[2]));
			out.add(Integer.parseInt(l4[1]));
			out.add(Integer.parseInt(l4[0]));
			out.add(Integer.parseInt(l3[0]));
			out.add(Integer.parseInt(l2[0]));
			
			List<Integer> in = new ArrayList<Integer>();
			in.add(Integer.parseInt(l2[1]));
			in.add(Integer.parseInt(l2[2]));
			in.add(Integer.parseInt(l3[2]));
			in.add(Integer.parseInt(l3[1]));
			
			System.out.println(max(out)+max(in));
		}
		
		
		
	}
	
	
	public static int max(List<Integer> list) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		ts.add(list.get(0)+list.get(list.size()-1));
		
		for(int i=0;i<list.size()-1;i++) {
			ts.add(list.get(i)+list.get(i+1));
		}
	
		return ts.last();
	}
	
//	public static String[] test(String[] args) {
//		List<String> ret = new ArrayList<String>();
//		
//		int num = Integer.parseInt(args[0]);
//		int add=-1;
//		for(int i=1;i<=num;i++) {
//			String[] l1 = args[i+add+1].split("\\S+");
//			String[] l2 = args[i+add+2].split("\\S+");
//			String[] l3 = args[i+add+3].split("\\S+");
//			String[] l4 = args[i+add+4].split("\\S+");
//			
//			List<String> list = new ArrayList<String>();
//			list.add(l1[0]);
//			list.add(l1[1]);
//			list.add(l1[2]);
//			list.add(l1[3]);
//			list.add(l2[0]);
//			list.add(l2[1]);
//			list.add(l2[2]);
//			list.add(l2[3]);
//			list.add(l3[0]);
//			list.add(l3[1]);
//			list.add(l3[2]);
//			list.add(l3[3]);
//			list.add(l4[0]);
//			list.add(l4[1]);
//			list.add(l4[2]);
//			list.add(l4[3]);
//			TreeSet<Integer> max = new TreeSet<Integer>();
//			max.add(getMax(list.get(0),list.get(1),list.get(2),list.get(3)
//					,list.get(4),list.get(5),list.get(6),list.get(7)
//					,list.get(8),list.get(9),list.get(10),list.get(11)
//					,list.get(12),list.get(13),list.get(14),list.get(15)));
//			for(int j=0;j<11;j++) {
//				list = ror(list);
//				max.add(getMax(list.get(0),list.get(1),list.get(2),list.get(3)
//						,list.get(4),list.get(5),list.get(6),list.get(7)
//						,list.get(8),list.get(9),list.get(10),list.get(11)
//						,list.get(12),list.get(13),list.get(14),list.get(15)));
//			}
//			ret.add(""+max.last());
//			add=add+3;
//		}
//		
//		return ret.toArray(new String[ret.size()]);
//	}
//	
//	
//	public static List<String> ror(List<String> para){
//		List<String> ret = new ArrayList<String>();
//		ret.add(para.get(4));
//		ret.add(para.get(0));
//		ret.add(para.get(1));
//		ret.add(para.get(2));
//		ret.add(para.get(8));
//		ret.add(para.get(5));
//		ret.add(para.get(6));
//		ret.add(para.get(3));
//		ret.add(para.get(12));
//		ret.add(para.get(9));
//		ret.add(para.get(10));
//		ret.add(para.get(7));
//		ret.add(para.get(13));
//		ret.add(para.get(14));
//		ret.add(para.get(15));
//		ret.add(para.get(11));
//		
//		
//		return ret;
//	}
//	
//	public static int getMax(String x1,String x2,String x3,String x4,String x5,String x6,String x7,String x8,String x9,String x10,String x11,String x12,String x13,String x14,String x15,String x16) {
//		
//		List<Integer> list1 = new ArrayList<Integer>();
//		list1.add(Integer.parseInt(x1));
//		list1.add(Integer.parseInt(x2));
//		list1.add(Integer.parseInt(x3));
//		list1.add(Integer.parseInt(x4));
//		List<Integer> list2 = new ArrayList<Integer>();
//		list2.add(Integer.parseInt(x5));
//		list2.add(Integer.parseInt(x6));
//		list2.add(Integer.parseInt(x7));
//		list2.add(Integer.parseInt(x8));
//		List<Integer> list3 = new ArrayList<Integer>();
//		list3.add(Integer.parseInt(x9));
//		list3.add(Integer.parseInt(x10));
//		list3.add(Integer.parseInt(x11));
//		list3.add(Integer.parseInt(x12));
//		List<Integer> list4 = new ArrayList<Integer>();
//		list4.add(Integer.parseInt(x13));
//		list4.add(Integer.parseInt(x14));
//		list4.add(Integer.parseInt(x15));
//		list4.add(Integer.parseInt(x16));
//		
//		int temp = list1.get(0)+list1.get(1)+list2.get(0)+list2.get(1);
//		int temp1 = list1.get(1)+list1.get(2)+list2.get(1)+list2.get(2);
//		int temp2 = list1.get(2)+list1.get(3)+list2.get(2)+list2.get(3);
//		
//		int temp3 = list2.get(0)+list2.get(1)+list3.get(0)+list3.get(1);
//		int temp4 = list2.get(1)+list2.get(2)+list3.get(1)+list3.get(2);
//		int temp5 = list2.get(2)+list2.get(3)+list3.get(2)+list3.get(3);
//		
//		int temp6 = list3.get(0)+list3.get(1)+list4.get(0)+list4.get(1);
//		int temp7 = list3.get(1)+list3.get(2)+list4.get(1)+list4.get(2);
//		int temp8 = list3.get(2)+list3.get(3)+list4.get(2)+list4.get(3);
//		
//		TreeSet<Integer> treeSet = new TreeSet<Integer>();
//		treeSet.add(temp);
//		treeSet.add(temp1);
//		treeSet.add(temp2);
//		treeSet.add(temp3);
//		treeSet.add(temp4);
//		treeSet.add(temp5);
//		treeSet.add(temp6);
//		treeSet.add(temp7);
//		treeSet.add(temp8);
//		
//		return treeSet.last();
//	}
//	
	
	public static List splitbyNum(List list,int n){
		List<List<Object>> ret = new ArrayList<List<Object>>();
		
		int elenum = list.size()/n;
		if(list.size()%n>1) {
			elenum++;
		}
		
		for(int i=0;i<elenum;i++) {
			List<Object> objlist = list.subList(n*i, n*(i+1));
			ret.add(objlist);
		}
		
		return ret;
	}

	public static List array2List(String[] strs) {
		List ret = new ArrayList<String>();
		for(int i=0;i<strs.length;i++) {
			ret.add(strs[i]);
		}
		return ret;
	}
}
