package com.brightstar.http.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			list.add(scanner.nextLine());
			if(list.size()%2==0)
			{
				int n=Integer.parseInt(list.get(0));
		        String[] strlist=list.get(1).split("\\s+");
		        int[] ins=new int[strlist.length];
		        
		        
		        for(int i=0;i<strlist.length;i++)
		        {
		        	ins[i]=Integer.parseInt(strlist[i]);
		        }
		        
		        
		        Arrays.sort(ins);
		        System.out.print(ins[ins.length-1]+" "+ins[ins.length-2]);
			}
		}


	}

}
