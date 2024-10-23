class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs ==null || strs.length == 0)
            return new ArrayList();
        
        Map<String, List<String>> frequency = new HashMap<>();
        
        for(String str : strs){
            String freqString = getFrequencyString(str);
            
            if(frequency.containsKey(freqString)){
                frequency.get(freqString).add(str);
            }
            else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequency.put(freqString, strList);
            }
        }
        
        return new ArrayList<>(frequency.values());
        
    }
    
    private String getFrequencyString(String str){
        int[] freq = new int[26];
        
        for(char ch:str.toCharArray()){
            freq[ch - 'a']++;
        }
        
        StringBuilder fS = new StringBuilder("");
        char c = 'a';
        for(int i : freq){
            fS.append(c);
            fS.append(i);
            c++;
        }
        
        return fS.toString();
    }
}