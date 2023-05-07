import java.util.Map;
import java.util.Scanner;

public class 선물 {
    static double N, L, W, H;
    static double answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        L = scanner.nextDouble();
        W = scanner.nextDouble();
        H = scanner.nextDouble();
        double max = Math.min(L, Math.min(W, H));
        bs( 0, max, 0);
        System.out.println(answer);
    }

    static void bs(double left, double right, int level) {
        double mid = (left + right) / 2;
        if (level == 10000) {
            answer = mid;
            return;
        }
        long l = (long) (L / mid);
        long w = (long) (W / mid);
        long h = (long) (H / mid);

        if (l * w * h >= N) {
            bs(mid, right, level + 1);
        } else if (l * w * h < N) {
            bs(left, mid, level + 1);
        }
    }
}
