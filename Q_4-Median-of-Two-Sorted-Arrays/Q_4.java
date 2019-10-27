public class findMedianSortedArrays_4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        findMedianSortedArrays_4 f = new findMedianSortedArrays_4();

        double a = f.findMedianSortedArrays(nums1, nums2);
        System.out.println(a);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        double target = 0;
        int k = 0;
        int count = 1;
        int l1 = 0;
        int l2 = 0;

        if ((m + n) % 2 == 1) {
            k = (m + n) / 2 + 1;
            while (count < k) {
                if (l2 >= n) {
                    l1++;
                    count++;
                } else if (l1 >= m) {
                    l2++;
                    count++;
                } else if (nums1[l1] <= nums2[l2]) {
                    l1++;
                    count++;
                } else {
                    l2++;
                    count++;
                }
            }
            if (l2 >= n) {
                return nums1[l1];
            } else if (l1 >= m) {
                return nums2[l2];
            } else if (nums1[l1] <= nums2[l2]) {
                return nums1[l1];
            } else {
                return nums2[l2];
            }

        } else {
            int l = 0, r = 0;
            k = (m + n) / 2;
            while (count < k) {
                if (l2 >= n) {
                    l1++;
                    count++;
                } else if (l1 >= m) {
                    l2++;
                    count++;
                } else if (nums1[l1] <= nums2[l2]) {
                    l1++;
                    count++;
                } else {
                    l2++;
                    count++;
                }
            }
            if (l2 >= n) {
                l = nums1[l1++];
            } else if (l1 >= m) {
                l = nums2[l2++];
            } else if (nums1[l1] <= nums2[l2]) {
                l = nums1[l1++];
            } else {
                l = nums2[l2++];
            }
            if (l2 >= n) {
                r = nums1[l1];
            } else if (l1 >= m) {
                r = nums2[l2];
            } else if (nums1[l1] <= nums2[l2]) {
                r = nums1[l1];
            } else {
                r = nums2[l2];
            }
            target = (l + r) / 2.0;
        }
        return target;
    }
}
