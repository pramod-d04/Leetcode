class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] proj = new int[n][2];
        int profit =0;
        for(int i=0; i<n; i++){
            proj[i][0]=profits[i];
            proj[i][1]=capital[i];
        }
        Arrays.sort(proj, (a,b) -> a[1]- b[1]);
        int i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(k>0){
            while(i<capital.length && proj[i][1]<=w){
                pq.add(proj[i][0]);
                i++;
            }
            if(pq.isEmpty()){
                break;
            }
            int f = pq.poll();
            w = w+f;
            
            k--;
        }
        return w;
    }
}