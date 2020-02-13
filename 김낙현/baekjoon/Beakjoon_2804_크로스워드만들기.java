package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_2804_크로스워드만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		char[] A = st.nextToken().toCharArray(); // 가로로 놓아야할 문자열 A
		char[] B = st.nextToken().toCharArray(); // 세로로 놓아야할 문자열 B

		char[][] word = new char[B.length][A.length];

		int start_y = 0; // A가 놓일 시작 위치
		int start_x = 0; // B가 놓일 시작 위치
		
		boolean flag = true; // 이중포문 빠져나올 flag
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length && flag; j++) {
				if (A[i] == B[j]) { // 같은 문자의 위치를 찾으면
					start_y = j; // 저장하고
					start_x = i;
					flag = false; // 반복문 탈출
					break;
				}
			}
		}

		for (int i = 0; i < B.length; i++) { 
			for (int j = 0; j < A.length; j++) {
				if (i == start_y) { // 가로 놓일 위치에 오면
					word[i][j] = A[j];  // 문자열 A 넣고
				}
				if (j == start_x) { // 세로의 위치에 오면
					word[i][j] = B[i]; // 문자열 B 넣고
				}
			}
		}

		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (word[i][j] == '\0') // 만약 공백이면 . 출력
					System.out.print('.');
				else					// 공백이 아니면
					System.out.print(word[i][j]); // 출력
			}
			System.out.println();
		}
	}
}
