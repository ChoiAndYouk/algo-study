import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1038
// 참고 : https://best-human-developer.tistory.com/86
public class Main_1038_감소하는_수 {
	static List<Long> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1038.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if(N <= 10) {
			System.out.print(N);
			return;
		} else if (N >= 1023) {
			// 0~9까지의 숫자를 조합하여 만들 수 있는 경우의 수
			// 2^10 (있고 없고의 2가지) 1024에서 아무것도 선택하지 않는 경우 1를 제외해서 총 1023개
			// 1023개 이상일 경우, 찾을 수 없는 숫자임.
			System.out.print(-1);
			return;
		}

		for(int i = 0; i < 10; i++) {
			DFS(i);
		}

		Collections.sort(list);
		System.out.println(list.get(N));
	} // End of main

	private static void DFS(long num) {		
		list.add(num);		
		long mod= num % 10;
		if(mod == 0) {
			return;
		}
		
		for(long i=mod-1; i>=0; i--) {
			// 나머지 값,  자신을 제외 하기 위해 -1을 해줌, 그리고 -1한 값부터 0까지 반복해서 숫자를 더해서 재귀
			long recurringValue = num * 10 + i;
			DFS(recurringValue);
		}
		
	} // End of DFS
} // End of Main class