import java.io.*;
import java.util.StringTokenizer;

public class Main_17393_다이나믹_롤러 {
    private static long N; // 통로의 길이
    private static final int MAX = 500_000;
    private static long[] arrA = new long[MAX]; // 잉크 지수
    private static long[] arrB = new long[MAX]; // 점도 지수

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/17393.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Long.parseLong(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrB[i] = Long.parseLong(st.nextToken());
        }

        // 내가 있는 칸을 포함하되 index는 0이 된다.
        // index를 이분 탐색을 통해서 찾아야됨
        for (int i = 0; i < N; i++) {
            // 여기 인덱스를 기준으로 i부터 idx까지 몇개를 칠 할 수 있는지 적어야됨
            sb.append(binarySearch(i, N - 1, arrA[i]) - i).append(' ');
        }


        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static long binarySearch(long low, long high, long inkValue) {
        if (low > high) {
            return -1;
        }

        // 같은 값 중에서 가장 뒤의 값을 선택해야 됨.
        long mid = (low + high) / 2;
        // res가 true이면 더 mid를 더 올려도됨
        if (check(mid, inkValue)) {
            long ret = binarySearch(mid + 1, high, inkValue);
            if (ret == -1) {
                return mid;
            } else {
                return ret;
            }
        } else {
            return binarySearch(low, mid - 1, inkValue);
        }
    } // End of binarySearch

    private static boolean check(long mid, long inkValue) {
        // 잉크지수 보다 점도지수가 작거나 같은지 확인해야됨
        if (arrB[(int) mid] <= inkValue) {
            return true;
        }
        return false;
    } // End of check
} // End of Main class
