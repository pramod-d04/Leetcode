class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] pairs = new int[profit.length][2];
        for(int i=0; i<profit.length; i++){
            pairs[i][0] = difficulty[i];
            pairs[i][1]= profit[i];
        }
        Arrays.sort(pairs, (a,b)-> Integer.compare(a[0], b[0]));
        Arrays.sort(worker);
        int p =0;
        int best =0;
        int total =0;
        for(int w :worker){
            while(p < pairs.length && w >= pairs[p][0]){
                best = Math.max(best, pairs[p++][1]);
            }
            total += best;
        }
        return total;
    }
}