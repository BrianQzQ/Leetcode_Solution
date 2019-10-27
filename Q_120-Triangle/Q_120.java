import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        int[][] memo = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(memo[i], 0);
        memo[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < N; i++)
            for (int j = 0; j < triangle.get(i).size(); j++)
                if (j == 0)
                    memo[i][j] = memo[i - 1][j] + triangle.get(i).get(j);
                else if (j == triangle.get(i).size() - 1)
                    memo[i][j] = memo[i - 1][j - 1] + triangle.get(i).get(j);
                else
                    memo[i][j] = Math.min(memo[i - 1][j - 1] + triangle.get(i).get(j), memo[i - 1][j] + triangle.get(i).get(j));

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < triangle.get(N).size(); j++)
            res = Math.min(res, memo[N][j]);
        return res;
    }
}
