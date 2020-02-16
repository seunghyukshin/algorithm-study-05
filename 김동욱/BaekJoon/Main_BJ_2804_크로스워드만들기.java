package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2804_크로스워드만들기 {
//주어진 단어를 완전 탐색해서 첫번째 단어에서 겹치는 가장 빠른 인덱스, 두번째단어에서 가장 빠른 인덱스를 
//구하여 세로단어 입력 인덱스로 설정하고 출력, 이때 세로 단어에서 겹치는 단어는 출력하지 않음
	static int c_x,c_y;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		int N = str1.length();
		int M = str2.length();
		
		char[] ch1 = new char[N];
		char[] ch2 = new char[M];
		
		for (int i = 0; i < N; i++) {
			ch1[i] = str1.charAt(i);
		}
		for (int i = 0; i < M; i++) {
			ch2[i] =str2.charAt(i);
		}
		
		boolean flag = false;
		for (int i = 0; i < N && !flag; i++) {//초기값을 true로 놓으면 flag, false로 놓으면 !flag
			for (int j = 0; j < M; j++) {
				if(ch1[i] == ch2[j]) {
					c_x = i;
					c_y = j;//같은 문자의 위치를 저장
					flag = true;
					break;
				}else
					continue;
			}
		}
		
		for (int i = 0; i < M; i++) {//같은 문자를 기준으로 출력
			for (int j = 0; j < N; j++) {
				if(i != c_y && j == c_x) {//겹치니까 하나는 무시해야된다
					System.out.print(ch2[i]);
				}else if(i == c_y){
					System.out.print(ch1[j] );
				}else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
}