package io.hotcool;

import org.junit.Test;

public class TwoSumTest {

    @Test
    public void testTwoSum(){
        int[] nums = {3,2,4};
        int target = 6;

        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);

    }

}
