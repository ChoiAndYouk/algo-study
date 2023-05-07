import java.io.*;
import java.util.StringTokenizer;

/*

    L W H인
    N, L, W, H가 주어질 때, 가능한 A의 최댓값을 찾는 프로그램을 작성하시오.

    첫쨰 줄에 가능한 A의 최댓값을 출력한다. 절대/상대 오차는 10^-9까지 허용한다.
 */

public class Main_1166_선물_재귀 {
    private static int N, L, W, H;
    private static double result = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1166.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        sb.append(binarySearch(0.0, Math.max(L, Math.max(W, H)), 0));
        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static double binarySearch(double low, double high, int count) {
        if (low > high || count == 60) {
            return low;
        }

        double mid = (low + high) / 2.0;

        if (check(mid)) {
            low = mid;
            double temp = binarySearch(low, high, count + 1);

            if (temp == -1) {
                return low;
            } else {
                return temp;
            }
        } else {
            high = mid;
            return binarySearch(low, high, count + 1);
        }
    } // End of binarySearch

    private static boolean check(double mid) {
        if ((long) (L / mid) * (long) (W / mid) * (long) (H / mid) >= N) {
            // check가 true이면, low = mid가 됨 (기준 높임).
            return true;
        } else {
            // check가 false이면, high = mid가 된다 (기준 내림).
            return false;
        }

    } // End of check
} // End of Main class
