class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        
        for (int x : arr1)
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        
        for (int temp : arr2) {
            if (mp.containsKey(temp)) {
                int count = mp.get(temp);
                for (int i = 0; i < count; i++) {
                    ans.add(temp);
                }
                mp.remove(temp);
            }
        }
        
        int index = 0;
        int[] remaining = new int[arr1.length - ans.size()];
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int ele = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remaining[index++] = ele;
            }
        }
        
        Arrays.sort(remaining);
        
        for (int num : remaining) {
            ans.add(num);
        }
        
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}