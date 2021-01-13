package io.hotcool;

import java.util.Arrays;

public class RemoveDup {

    public int removeDuplicates(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;

        boolean flag = false;
        int length = nums.length;
        int lastVal = 11111;
        for(int i = 1; i < nums.length; ++i){
            if(!flag) {
                if (nums[i - 1] == nums[i]) {
                    flag = true;
                    lastVal = nums[i];
                }
            }
            else{
                if(nums[i - 1] == nums[i] || lastVal == nums[i]) {
                    nums[i] = 11111;
                    --length;
                }
                else {
                    flag = false;
                    lastVal = nums[i];
                }
            }
        }

        Arrays.sort(nums);

        return new int[length].length;
    }

}
