package io.hotcool;

import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationTest {

    private Combination c = new Combination();

    @Test
    public void testD(){
        int[] a = new int[]{4,4,4,1,4};

        System.out.println(c.subsetsWithDup(a));

        int[] b = new int[]{1,2,3};

        System.out.println(c.subsetsWithDup(b));
    }



}