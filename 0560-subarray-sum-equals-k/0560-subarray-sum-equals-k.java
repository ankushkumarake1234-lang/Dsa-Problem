import java.lang.*;
import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        // int n = nums.length;
        // int count = 0;
        // for(int i = 0; i<n; i++){
        //     int sum = 0;
        //     for(int j = i; j<n; j++){
        //         sum += nums[j];
        //         if(sum == k){
        //             count++;
        //         }
        //     }
        // }
        // return count;

        int n = nums.length;
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num : nums){
            sum += num;
            int remaining = sum - k;
            if(map.containsKey(remaining)){
                count += map.get(remaining);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;

    }
}