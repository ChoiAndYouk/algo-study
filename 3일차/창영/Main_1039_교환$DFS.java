import java.util.*;
import java.io.*;

public class Main_1039_교환$DFS {
	static int memo[][];
	static int K, len, result;
	static String N;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1039.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = st.nextToken(); // 주어진 값(문자열)
		K = Integer.parseInt(st.nextToken()); // 위치를 바꿀 횟수
		len = N.length(); // 주어진 값의 길이
		memo = new int[K + 1][1000001];

	} // End of main

	private static void DFS(int depth) {
		
		if(depth == K) {
			
		}
		
	} // End of DFS

	private static int swap(String str, int i, int j) {
		char chArr[] = str.toCharArray();

		if (i == 0 && chArr[j] == '0') {
			return -1;
		}
		char tmp = chArr[i];
		chArr[i] = chArr[j];
		chArr[j] = tmp;

		return Integer.parseInt(String.valueOf(chArr));
	} // End of swap
} // End of Main class