class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;

        int nodelete = arr[0];
        int onedelete = Integer.MIN_VALUE;
        int res = arr[0];

        for(int i=1;i<n;i++){
            int prevnodelete = nodelete;
            int prevonedelete = onedelete;

            nodelete = Math.max(nodelete+arr[i],arr[i]);

            int V2 = Integer.MIN_VALUE;
           if(prevonedelete != Integer.MIN_VALUE){
           V2 = prevonedelete + arr[i];
           }

           onedelete = Math.max(V2, prevnodelete);

           res = Math.max(res, Math.max(onedelete, nodelete));
        }
        return res;
    }
}