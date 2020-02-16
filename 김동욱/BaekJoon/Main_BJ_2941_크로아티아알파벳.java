package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2941_크로아티아알파벳 {
//알파벳에 대하여 경우의수를 나누어 해당 경우에 해당하면 cnt를 올리는 방식
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int len = str.length();
		int cnt = 0;
		char[] ch = new char[len + 2];
		ch[0] = '0';
		for (int i = 1; i < len + 1; i++) {
			ch[i] = str.charAt(i - 1);
		}
		for (int j = 1; j < len + 1; j++) {
			switch (ch[j]) {//탐색하는 문자에 따라 케이스 분류
			case 'c':
				if (ch[j + 1] == '=') {
					j++;
					cnt++;
				} else if (ch[j + 1] == '-') {
					j++;
					cnt++;
				} else {
					cnt++;
				}
				break;
				
			case 'd':
				if (ch[j + 1] == 'z' && ch[j + 2] == '=') {
					j += 2;
					cnt++;

				} else if (ch[j + 1] == '-') {
					j++;
					cnt++;
				} else if (ch[j + 1] == 'z' && ch[j + 2] != '=') {
					cnt++;
					break;
				} else {
					cnt++;
				}
				break;
				
			case 'l':
				if (ch[j + 1] == 'j') {
					j++;
					cnt++;
				} else {
					cnt++;
				}
				break;
			case 'n':
				if (ch[j + 1] == 'j') {
					j++;
					cnt++;
				} else {
					cnt++;
				}
				break;
			case 's':
				if (ch[j + 1] == '=') {
					j++;
					cnt++;
				} else {
					cnt++;

				}
				break;
				
			case 'z':
				if (ch[j - 1] != 'd' && ch[j + 1] == '=') {
					j++;
					cnt++;
				} else {
					cnt++;
				}
				break;
				
			case '=':
				break;
				
			case '-':
				break;
				
			case 'j':
				if (ch[j - 1] != 'l' && ch[j - 1] != 'n') {
					cnt++;
				}
				break;
				
			default:
				cnt++;
				break;
			}
		}
		System.out.println(cnt);
	}
}