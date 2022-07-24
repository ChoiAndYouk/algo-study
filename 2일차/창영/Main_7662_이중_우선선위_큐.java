import java.util.*;
import java.io.*;

// I n은 정수 n을 Q에 삽입하는 연산을 의미한다.
// 동일한 정수가 삽입될 수 있음
// D 1은 Q에서 최댓값을 삭제하는 연산
// D -1은 Q에서 최솟값을 삭제하는 연산을 의미

public class Main_7662_이중_우선선위_큐 {
	static StringBuilder sb = new StringBuilder();
	static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/7662.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int Q = Integer.parseInt(br.readLine());
			
			while(Q-->0) {
				st = new StringTokenizer(br.readLine());
				String func = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(func.equals("I")) input(num); // num을 삽입하는 연산
				else delete(num); // D 1은 최댓값 삭제, D -1은 최솟값을 삭제
				// 최대, 최소 값이 둘 이상인 경우, 하나만 삭제 된다.
			}
			
			if(treeMap.isEmpty()) sb.append("EMPTY").append('\n');
			else sb.append(treeMap.lastKey()).append(' ').append(treeMap.firstKey()).append('\n');
			
			treeMap.clear();
		}

		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
	
	private static void input(int num) {
		treeMap.put(num, treeMap.getOrDefault(num, 0)+1);
	} // End of input
	
	private static void delete(int num) {
		if(treeMap.isEmpty()) return;
		else if(num == 1) { // 최댓값 삭제
			int maxNum = treeMap.lastKey();
			int defaultNum = treeMap.get(maxNum);
			if(defaultNum == 1) treeMap.remove(maxNum); // default수가 1이면 해당 key삭제
			else treeMap.put(maxNum, defaultNum-1); // 1이상이면 해당 key의 value를 value-1로 갱신
	
		}
		else if(num == -1) { // 최솟값 삭제
			int minNum = treeMap.firstKey();
			int defaultNum = treeMap.get(minNum);
			if(defaultNum == 1) treeMap.remove(minNum); // default수가 1이면 해당 key삭제
			else treeMap.put(minNum, defaultNum-1); // 1이상이면 해당 key의 value를 value-1로 갱신
		}
		
	} // End of delete
	
} // End of Main class