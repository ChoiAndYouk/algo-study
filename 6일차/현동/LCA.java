import java.util.ArrayList;
import java.util.Scanner;

public class LCA {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] depth;
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        // 인접 리스트
        for (int i = 0; i < N - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // dfs 돌면서 depth, parent 저장
        depth = new int[N + 1];
        parent = new int[N + 1];
        dfs(1, 1);

        // 두 노드를 입력 받아 공통 조상을 출력
        int M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int depthA = depth[a];
            int depthB = depth[b];

            while (depthA != depthB) {
                if (depthA > depthB) {
                    depthA--;
                    a = parent[a];
                } else {
                    depthB--;
                    b = parent[b];
                }
            }

            while (a != b) {
                a = parent[a];
                b = parent[b];
            }

            System.out.println(a);
        }


    }

    static void dfs(int from, int level) {
        depth[from] = level;
        for (int next : tree.get(from)) {
            if (depth[next] != 0) continue;
            parent[next] = from;
            dfs(next, level + 1);
        }

    }

}
