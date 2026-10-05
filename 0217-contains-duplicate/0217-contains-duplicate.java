import java.lang.*;
import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // this is normal way but time complety is diffent 

        // int n = nums.length;
        // int count = 0;
        // for(int i = 0; i<n; i++){
        //     for(int j = i+1; j<n; j++){
        //         if(nums[i] == nums[j]){
        //             count++;
        //         }
        //     }
        // }
        // if(count>0){
        //     return true;
        // }
        // else{
        //     return false;
        // }

        //  the second method of this quetsion that sorting 

        // the third method is hashset for finding unique value form array

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}