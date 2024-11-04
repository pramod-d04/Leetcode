public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] res = new int[n];
        
        // Fill the leftProducts array
        leftProducts[0] = 1;  // Nothing to the left of the first element
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }
        
        // Fill the rightProducts array
        rightProducts[n - 1] = 1;  // Nothing to the right of the last element
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }
        
        // Calculate the result by multiplying left and right products
        for (int i = 0; i < n; i++) {
            res[i] = leftProducts[i] * rightProducts[i];
        }
        
        return res;
    }
}
