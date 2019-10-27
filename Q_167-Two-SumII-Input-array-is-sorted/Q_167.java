package Easy;

public class Q_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] a = new int[2];
        int m = 0;
        int n = 0;//int temp;
        for (m = 0; m < numbers.length; m++) {
            //temp=0;
            for (n = m + 1; n < numbers.length; n++) {
                if (numbers[m] + numbers[n] == target) {
                    a = new int[]{++m, ++n};
                    return a;
                }
                if (numbers[m] + numbers[n] < target) {
                    continue;
                } else {
                    break;
                }
            }
        }

        a = new int[]{m++, n++};
        return a;
    }

    public int[] twoSum2(int[] numbers, int target) {

        int[] a = new int[2];
        int m = 0;
        int n = numbers.length - 1;
        while (numbers[m] + numbers[n] != target) {
            if (numbers[m] + numbers[n] > target) {
                n--;
                continue;
            } else {
                m++;
            }
        }
        a = new int[]{++m, ++n};
        return a;
    }
}
