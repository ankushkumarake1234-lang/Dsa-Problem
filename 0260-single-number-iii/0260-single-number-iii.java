class Solution {
    public int[] singleNumber(int[] nums) {
        // int ones = 0;
        // int twos = 0;
        // for(int i = 0; i<nums.length; i++){
        //     ones = (ones^nums[i]) & ~ones;
        //     twos = (two^nums[i]) & ~twos;
        // }
        // return nums[ones, twos];


        int n = nums.length;
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans = ans^nums[i];
        }
        int idx = -1;
        for(int i = 0; i<32; i++){
            if((ans & (1 << i)) != 0){
                idx = i;
                break;
            }
        }
        int set1 = 0;
        int set2 = 0;
        for(int a : nums){
            if((a & (1 << idx)) != 0){
                set1 = set1^a;
            }
            else{
                set2 = set2^a;
            }
        }
        return new int[]{set1, set2};
    }
}