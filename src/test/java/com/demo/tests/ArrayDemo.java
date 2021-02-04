package com.demo.tests;

import java.util.HashMap;
import java.util.Map;

public class ArrayDemo {
	
	public static void main(String[] args){
		
		ArrayDemo obj = new ArrayDemo();
		
		int[] arry ={5,4,9,2,5,9,6,9,1,2,3};
		
		HashMap<Integer, Integer> mp = obj.findOccurence(arry);
		
		  for (Map.Entry<Integer,Integer> entry : mp.entrySet())  
	         System.out.println("The Number is::" + entry.getKey() + 
	                             ", Times Occured ::" + entry.getValue()); 
		
	}
	
	public HashMap<Integer, Integer> findOccurence(int[] arry){
		HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for(int i=0;i<arry.length;i++){
			if(mp.containsKey(arry[i])){
				int cnt=0;
				cnt =mp.get(arry[i])+1;
				mp.put(arry[i],cnt);
			}else{
				mp.put(arry[i], 1);
			}
		}
		return mp;
	}

}
