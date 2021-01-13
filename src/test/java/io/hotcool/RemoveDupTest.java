package io.hotcool;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RemoveDupTest {

    @Test
    public void test1(){
        int[] nums = new int[]{1,1,1,2,2,3};
        RemoveDup removeDup = new RemoveDup();
        assertEquals(5, removeDup.removeDuplicates(nums));
        int[] num = new int[]{0,0,1,1,1,1,2,3,3};
        assertEquals(7, removeDup.removeDuplicates(num));
    }

}