class Solution {
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int l =0;
        int h = pos[pos.length-1];
        int o =0;
        while(l<=h){
            int mid = l +(h-l)/2;
            if(isPP(pos,m,mid)){
                o = mid;
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return o;
    }
    private boolean isPP(int[] pos, int m, int mid){
        int count =1;
        int last = pos[0];
        for(int i =0; i< pos.length; i++){
            if(pos[i] - last >= mid){
                last = pos[i];
                count++;
            }
        }
        return count >=m;
    }
}