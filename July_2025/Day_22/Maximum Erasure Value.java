class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum=0,max=0,left=0;
        HashSet<Integer> set= new HashSet<>();
        for(int right=0;right<nums.length;right++){
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
            set.add(nums[right]);
            sum+=nums[right];
            max=Math.max(sum,max);
        }
        return max;
    }
}
