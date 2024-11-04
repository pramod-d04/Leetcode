class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int res =0;
        for(int num : nums){
            if(!hmap.containsKey(num)){
                hmap.put(num, hmap.getOrDefault(num-1, 0) + hmap.getOrDefault(num+1,0) +1);
                hmap.put(num - hmap.getOrDefault(num - 1, 0), hmap.get(num));
                hmap.put(num + hmap.getOrDefault(num + 1, 0), hmap.get(num));
                res = Math.max(res, hmap.get(num));
            }
        }
        return res;        
    }
}