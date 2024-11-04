class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0; // Variable to store the length of the longest consecutive sequence
        if (nums.length > 0) {
            // Check if the array length is less than 10,000
            if (nums.length < 10000) {
                Arrays.sort(nums); // Sort the array
                int current = 0; // Counter for the current consecutive sequence
                for (int i = 1; i < nums.length; i++) {
                    // Check for unique elements
                    if (nums[i] != nums[i - 1]) {
                        // Check if the current number is consecutive
                        if (nums[i] - nums[i - 1] == 1) {
                            current++; // Increment the current sequence length
                        } else {
                            // Update the result if the current sequence is longer
                            if (current + 1 > result) {
                                result = current + 1;
                            }
                            current = 0; // Reset current counter
                        }
                    }
                }
                // Final check for the last sequence
                if (current + 1 > result) {
                    result = current + 1;
                }
            } else {
                // For larger arrays, find min and max
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int num : nums) {
                    if (num > max) {
                        max = num; // Update max
                    }
                    if (num < min) {
                        min = num; // Update min
                    }
                }
                // Create a bit array to track presence of numbers
                byte[] bits = new byte[max - min + 1];
                for (int num : nums) {
                    bits[num - min] = 1; // Mark the presence of the number
                }
                int current = 0; // Counter for the current consecutive sequence
                for (byte bit : bits) {
                    if (bit > 0) {
                        current++; // Increment for consecutive presence
                    } else {
                        // Update the result if the current sequence is longer
                        if (current > result) {
                            result = current;
                        }
                        current = 0; // Reset current counter
                    }
                }
                // Final check for the last sequence
                if (current > result) {
                    result = current;
                }
            }
        }
        return result; // Return the length of the longest consecutive sequence
    }
}