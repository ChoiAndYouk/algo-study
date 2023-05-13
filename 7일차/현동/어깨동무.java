import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://www.acmicpc.net/problem/27932
public class 어깨동무 {
    static int N, K;
    static long answer;
    static Integer[] heights;
    static List<Integer> gab;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        if (N == 1) {
            System.out.println(0);
            return;
        }

        heights = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        gab = IntStream.range(0, N)
                .mapToObj(i -> {
                    if (i == 0) {
                        return Math.abs(heights[i] - heights[i + 1]);
                    } else if (i == heights.length - 1) {
                        return Math.abs(heights[i] - heights[i - 1]);
                    } else {
                        return Math.max(Math.abs(heights[i] - heights[i - 1]), Math.abs(heights[i] - heights[i + 1]));
                    }
                })
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        long left = 0;
        long right = 1000000000;
        bs(left, right);
        System.out.println(answer);
    }

    static void bs(long left, long right) {
        long mid = left + ((right - left) / 2);
        if (left == right) {
            answer = mid;
            return;
        }

        int count = getCount(mid);

        if (count <= K) {
            bs(left, mid);
        } else {
            bs(mid + 1, right);
        }
    }

    static int getCount(long target) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (gab.get(i) > target) result++;
            else return result;
        }
        return result;
    }
}
