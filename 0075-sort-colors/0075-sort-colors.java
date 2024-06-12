class Solution {
    public void sortColors(int[] nums) {
        int s =0;
        int mid =0;
        int end = nums.length - 1;
        while(mid<=end){
            switch(nums[mid]){
                case 0:
                    swap(nums, s, mid);
                    s++;
                    mid++;
                    break;
                case 1:
                    mid ++;
                    break;
                case 2:
                    swap(nums, mid, end);
                    end --;
                    break;                
            }
        }
    }
    
    private void swap(int[] arr, int p1, int p2){
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}