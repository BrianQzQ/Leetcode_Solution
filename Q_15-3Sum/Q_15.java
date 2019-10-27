import java.util.*;

public class ThreeSum_15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2,-1,-4};
        ThreeSum_15 t = new ThreeSum_15();
        t.threeSum4(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> LL = new ArrayList<>();
        int l = 0;
        int r = nums.length - 2;
        //int ta = nums.length - 1;
        for (int i = nums.length - 1; i >= 2; i--) {

            int Ta = nums[i];
            for (int j = 0; j < i; j++) {
                int J = nums[j];
                for (int k = j + 1; k < i; k++) {
                    int K = nums[k];
                    if (J + Ta + K == 0) {
                        List<Integer> L = new ArrayList<>();
                        L.add(J);
                        L.add(K);
                        L.add(Ta);
                        LL.add(L);
                    }
                }
            }
        }

        return LL;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> LL = new ArrayList<>();
        if (len <= 2) return LL;
        if (len == 3 && nums[0] + nums[1] + nums[2] != 0) return LL;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1, r = len - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        LL.add(Arrays.asList(-sum, nums[l], nums[r]));
                        if (l < r && nums[l] == nums[l + 1])
                            l++;
                        if (l < r && nums[r] == nums[r - 1])
                            r--;
                        r--;
                        l++;
                    } else if (nums[l] + nums[r] > sum)
                        r--;
                    else
                        l++;
                }
            }
        }
        return LL;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int N = nums.length;
        if (N < 3) return result;
        Map<Integer, Integer> Mmap = new HashMap<>();
        Map<Integer, Integer> Pmap = new HashMap<>();
        int n = 0, m = 0, z = 0;
        boolean a = false;
        for (int i = 0; i < N; i++) {
            if (nums[i] < 0) {
                Mmap.put(i, nums[i]);
                n++;
            }
            if (nums[i] == 0) {
                z++;
            }
            if (nums[i] > 0) {
                Pmap.put(i, nums[i]);
                m++;
            }
        }
        if (z != 0) {
            for (int i = 0; i < n; i++) {
                if (nums[i + 1] == nums[i])
                    continue;
                if (Pmap.containsValue(nums[i])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(-nums[i]);
                    temp.add(0);
                    result.add(temp);
                }

            }
        }


        return result;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int N = nums.length;

        for (int fix = N - 1; fix >= 2; fix--) {
            int l = 0, r = fix - 1;

            if (nums[fix] < 0)
                break;
            if (fix < N - 1)
                if (nums[fix] == nums[fix + 1]) {
                    continue;
                }
            int target = 0 - nums[fix];
            while (l < r) {
                if (l > 0)
                    if (nums[l] == nums[l - 1]) {
                        l++;
                        continue;
                    }
                if (r < fix - 1)
                    if (nums[r] == nums[r + 1] && r < fix - 1) {
                        r--;
                        continue;
                    }
                if (nums[l] + nums[r] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[l++]);
                    temp.add(nums[r--]);
                    temp.add(nums[fix]);
                    result.add(temp);

                } else if (nums[l] + nums[r] < target)
                    l++;
                else
                    r--;
            }
        }


        return result;
    }

    public List<List<Integer>> threeSum4(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int N = nums.length;
        for (int fix = 0; fix <N- 2; fix++) {
            int l = fix+1, r = N-1;

            if (nums[fix] > 0)
                break;
            if (fix >0)
                if (nums[fix] == nums[fix - 1]) {
                    continue;
                }
            int target = 0 - nums[fix];
            while (l < r) {
                /*
                if (l > fix+1)
                    if (nums[l] == nums[l - 1]) {
                        l++;
                        continue;
                    }
                if (r < N-1)
                    if (nums[r] == nums[r + 1] ) {
                        r--;
                        continue;
                    }

                 */
                if (nums[l] + nums[r] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    temp.add(nums[fix]);
                    result.add(temp);
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;r--;

                } else if (nums[l] + nums[r] < target)
                    l++;
                else
                    r--;
            }
        }


        return result;
    }
}
