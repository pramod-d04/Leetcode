class Solution {
    private int modifiedBSearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] >= nums[left]) {
            if (nums[left] <= target && target < nums[mid]) {
                return modifiedBSearch(nums, target, left, mid - 1);
            } else {
                return modifiedBSearch(nums, target, mid + 1, right);
            }
        } else {
            if (nums[mid] < target && target <= nums[right]) {
                return modifiedBSearch(nums, target, mid + 1, right);
            } else {
                return modifiedBSearch(nums, target, left, mid - 1);
            }
        }
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return modifiedBSearch(nums, target, left, right);
    }
}
