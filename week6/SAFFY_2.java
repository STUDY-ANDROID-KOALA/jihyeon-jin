import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution2 {
    static int min = Integer.MAX_VALUE;
    static int[] input;
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            min = Integer.MAX_VALUE;
            combination(0, 0, new int[K]);

            System.out.println("#" + test_case + " " + min);
        }
    }

    static void combination(int start, int depth, int[] selected) {
        if (depth == K) { //k개의 조합이 되면 각
            int sum = 0;
            for (int i = 0; i < K; i++) {
                for (int j = i + 1; j < K; j++) {
                    sum += Math.abs(selected[i] - selected[j]);
                }
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = start; i <= N - (K - depth); i++) {
            selected[depth] = input[i];
            combination(i + 1, depth + 1, selected);
        }
    }
}