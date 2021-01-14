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

    public boolean search(int[] nums, int target) {
        if (null == nums || 0 == nums.length)
            return false;

        if(1 == nums.length){
            return nums[0] == target;
        }

        int turningPoint = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                return true;
            }

            if ((i + 1) < nums.length && nums[i] > nums[i + 1]) {
                break;
            }

            ++turningPoint;
        }

        //There is no rotation, violating the pre-conditions
        if(nums.length <= turningPoint){
            return false;
        }

        int[] rawArray = new int[nums.length];
        int j = 0;
        for (int i = turningPoint + 1; i < nums.length; ++i) {
            rawArray[j++] = nums[i];
        }

        for (int i = 0; i < turningPoint + 1; ++i) {
            rawArray[j++] = nums[i];
        }

        //binary search
        return findTarget(rawArray, 0, rawArray.length, target);

    }

    private boolean findTarget(int[] array, int l, int r, int target){
        if(l < r){
            int mid = (l + r) / 2;
            if(array[mid] == target)
                return true;
            if(array[mid] > target)
                return findTarget(array, 0, mid, target);
            if(array[mid] < target)
                return findTarget(array, mid + 1, r, target);
        }
        return false;
    }

}
