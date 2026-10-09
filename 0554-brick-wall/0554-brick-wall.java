import java.lang.*;
import java.util.*;
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        // HashMap<Integer, Interger> map = new HashMap<>();
        // int max_freq = 0;
        // for(int i = 0; i<wall.size(); i++){
        //     int temp = 0;
        //     for(int j = 0; j<wall.get(i).size()-1; j++){
        //         int current = wall.get(i).get(j);

        //     }
        // }


        HashMap<Long, Integer> map = new HashMap<>();
        int ans = 0;
        for (List<Integer> q : wall) {
            long sum = 0;
            for(int i = 0; i<q.size()-1; i++){
                sum += q.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                ans = Math.max(ans, map.get(sum));
            }
        }
        return wall.size()-ans;
    }
}