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

    @Test
    public void testFind(){
        int[] nums = new int[]{2,5,6,0,0,1,2};
        RemoveDup removeDup = new RemoveDup();
        assertEquals(true, removeDup.search(nums, 0));
        assertEquals(false, removeDup.search(nums, 3));
        assertEquals(true, removeDup.search(nums, 2));
        assertEquals(true, removeDup.search(nums, 6));
        assertEquals(false, removeDup.search(nums, 7));
        assertEquals(false, removeDup.search(new int[]{1,1}, 0));
        assertEquals(false, removeDup.search(new int[]{3,1}, 0));
        assertEquals(true, removeDup.search(new int[]{3,1}, 1));

    }

}