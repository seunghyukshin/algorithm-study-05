import java.io.*;

public class BJ_2941_크로아티아알파벳 {
	static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int size = s.length();
		sum = 0;
		for (int i = 0; i < size; i++) {
			char c = s.charAt(i);
			if (c == 'c' && i < size - 1 && (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-')) {
				i++;
			} else if (c == 'd' && i < size - 2 && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
				i += 2;
			} else if (c == 'd' && i < size - 1 && s.charAt(i + 1) == '-') {
				i += 1;
			} else if (c == 'l' && i < size - 1 && s.charAt(i + 1) == 'j') {
				i += 1;
			} else if (c == 'n' && i < size - 1 && s.charAt(i + 1) == 'j') {
				i += 1;
			} else if (c == 's' && i < size - 1 && s.charAt(i + 1) == '=') {
				i += 1;
			} else if (c == 'z' && i < size - 1 && s.charAt(i + 1) == '=') {
				i += 1;
			}
			sum++;
		}
		System.out.println(sum);

	}
}
