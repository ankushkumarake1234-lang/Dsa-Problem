class Solution {
    public int findMin(int[] nums) {
     int n = nums.length;
     int min = nums[0];
     for(int i = 0; i<n; i++){
        min = Math.min(nums[i], min);
     }   
     return min;
    }
}