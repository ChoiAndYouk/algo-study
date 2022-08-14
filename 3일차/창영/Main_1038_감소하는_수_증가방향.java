import java.util.*;
import java.io.*;

public class Main_1038_감소하는_수_증가방향 {
	static List<Long> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1038.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		if(N<=10) {
			System.out.println(N);
			return;
		} else {
			DFS(0, 0, 0);
			Collections.sort(list);
			
			if(N > list.lastIndexOf(list.size())) {
				System.out.println(-1);
			} else {
				System.out.println(list.get(N));
			}
		}
	} // End of main
	
	private static void DFS(int number, int numberLength, long beforeNum) {
		if(numberLength >= 10 || beforeNum >= 10) {
			return;
		}
		
		for(int i=number; i<10; i++) {
			long decreasingNum = i * (long) (Math.pow(10, numberLength)) + beforeNum;
			list.add(decreasingNum);
			DFS(i+1, numberLength + 1, decreasingNum);
		}
	} // End of DFS
} // End of Main class