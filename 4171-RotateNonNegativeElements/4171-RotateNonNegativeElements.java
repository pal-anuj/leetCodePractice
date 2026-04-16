// Last updated: 16/04/2026, 05:36:38
class Solution {
    public int[] rotateElements(int[] nums, int k) {

        int n = nums.length;

        int[] arr = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                arr[j++] = nums[i];
            }
        }

        if (j ==0 )
            return nums;
        
        k = k % j;
        reverse(arr, 0, k - 1);
        reverse(arr, k, j - 1);
        reverse(arr, 0, j - 1);

        // for (int num : arr)
        //     System.out.println(num);
        // System.out.println("j=" + j + ", k="  +k);

        j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0)
                nums[i] = arr[j++];
        }

        return nums;
    }

    public void reverse(int[] arr, int l, int r) {

        while (l < r) {
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}