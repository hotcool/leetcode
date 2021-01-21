package io.hotcool;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntTest {

    ReverseInt reverseInt = new ReverseInt();

    @Test
    public void test(){

        assertEquals(5, reverseInt.numDecodings("1123"));
        assertEquals(3, reverseInt.numDecodings("226"));
        assertEquals(2, reverseInt.numDecodings("12"));
        assertEquals(9, reverseInt.numDecodings("123123"));
    }

}