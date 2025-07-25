class Solution {
    public int maxSum(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int crnt:set){
            if(crnt>0)
            sum+=crnt;    
        }
        return (sum==0)?Collections.max(set):sum;
    }
}
