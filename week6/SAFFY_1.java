import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < t ; test_case++) {
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] nArr = new int[n];
            int[] mArr = new int[m];

            nArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            mArr =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                max = Math.max(max, nArr[i]);
                min = Math.min(min, nArr[i]);
            }
            if(min * 2 >= max) {
                max = min * 2;
            }


            for(int i = 0; i < m; i++) {
                if(mArr[i] <= max) {
                    result = -1;
                    break;
                }
                else
                    result = max;
            }
            System.out.println("#" + (test_case + 1) + " "+ result);
        }

    }
}