class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hm = new HashSet<>();
        for(int i : nums){
            if(hm.contains(i)){
                return true;
            }
            hm.add(i);
        }
        return false;
    }
}