import java.util.*;
import java.io.*;

// x가 0이 아니라면, 배열에 x라는 값을 넣는 연산,
// x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.

public class Main_11286_절댓값_힙 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/11286.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pque = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			if(abs1 == abs2) return o1 - o2;
			return abs1 - abs2;
		});
		
		
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			int x = Integer.parseInt(br.readLine());
			
			if(x != 0) {
				pque.offer(x);
			}		
			else {
				if(pque.isEmpty()) sb.append(0).append('\n');
				else sb.append(pque.poll()).append('\n');
			}
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
} // End of Main class