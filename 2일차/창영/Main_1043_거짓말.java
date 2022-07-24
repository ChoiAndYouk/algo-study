import java.util.*;
import java.io.*;

// 시루가 해방시킬 수 있는 주민들의 최대 수를 출력한다. 만약 주민을 해방시킬 수 없다면 0을 출력한다.
// 노드 탐색 문제 진실을 아는 노드와 연결된 것들은 모두 제외한 값을 구하면 된다.

// 플로이드 워샬

public class Main_1043_거짓말 {
	static boolean know[];
	static int party[][];
	static String arr[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1043.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 파티의 수
		know = new boolean[N+1];
		party = new int[N+1][N+1];
		arr = new String[M];
		
		st = new StringTokenizer(br.readLine()); 
		int knowNum = Integer.parseInt(st.nextToken());
		if(knowNum == 0) {
			System.out.println(M);
			return;
		}
		else if(knowNum != 0) {			
			while(knowNum-->0) {
				know[Integer.parseInt(st.nextToken())] = true;
			}		
		}

		for(int i=0; i<M; i++) {
			String temp = br.readLine();
			arr[i] = temp;
			st = new StringTokenizer(temp);
			
			int num = Integer.parseInt(st.nextToken());
			if(num >= 2) {
				int x = Integer.parseInt(st.nextToken());
				
				while(st.hasMoreTokens()) {
					int y = Integer.parseInt(st.nextToken());
					party[x][y] = 1;
					party[y][x] = 1;
				}
			}
		}
		
		// 플로이드 워샬
		for(int k=0; k<N+1; k++) {
			// 출발 노드 i
			for(int i=0; i<N+1; i++) {
				// 도착 노드 j
				for(int j=0; j<N+1; j++) {
					
					if(party[i][k] == 1 && party[k][j] == 1) {
						party[i][j] = 1;
					}
					
				} // for(j) of End
			} // for(i) of End
		} // for(k) of End


		for(int i=1; i<N+1; i++) {
			
			if(know[i]) {
				for(int j=1; j<N+1; j++) {
					if(party[i][j] == 1) {
						know[j] = true;
					}
				}
			}
		}
		
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			String temp = arr[i];
			Boolean canParty = true;
			
			st = new StringTokenizer(temp);
			int loop = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<loop; j++) {
				int value = Integer.parseInt(st.nextToken());
				
				if(know[value] == true) {
					canParty = false;
					break;
				}
			}
			
			if(canParty) result++;
		}
		
		System.out.println(result);
	} // End of main
} // End of Main class