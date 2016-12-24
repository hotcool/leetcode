package io.hotcool;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    //brute force
    /*
    public int[] twoSum(int[] nums, int target) {
        if(nums == null)
            return null;
        if(nums.length == 0)
            return null;

        int[] result = new int[2];

        for(int i=0;i<nums.length;++i){
            int adder = nums[i];
            for(int j=i+1; j<nums.length;++j){
                if(adder + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return null;
    }
    */

    //O(n) using Map
    public int[] twoSum(int[] nums, int target){
        if(nums == null)
            return null;
        if(nums.length == 0)
            return null;

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; ++i){
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

}
