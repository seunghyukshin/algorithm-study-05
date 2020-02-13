package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		
		int count = input.length();
		
		for (int i = 1; i < input.length(); i++) {
			String temp = input.charAt(i-1) + "" + input.charAt(i);
			if(i != 1) {
				String temp2 = input.charAt(i-2) + "" + input.charAt(i-1) + "" + input.charAt(i);
				if(temp2.equals("dz=")) {
					count--;
				}
			}
			if(input.charAt(i) == '=') {
				count--;
			}else if(input.charAt(i) == '-') {
				count--;
			}else if(temp.equals("lj") || temp.equals("nj")) {
				count--;
			}
			
			
		}
		
		System.out.println(count);
		
	}
}
