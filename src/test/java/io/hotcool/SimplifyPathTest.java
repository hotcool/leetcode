package io.hotcool;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimplifyPathTest {

    SimplifyPath simplifyPath = new SimplifyPath();

    @Test
    public void test1(){
        String path0 = "/home/";
        assertEquals("/home", simplifyPath.simplifyPath(path0));
        String path1 = "/../";
        assertEquals("/", simplifyPath.simplifyPath(path1));
        String path2 = "/home//foo/";
        assertEquals("/home/foo", simplifyPath.simplifyPath(path2));
        String path3 = "/a/./b/../../c/";
        assertEquals("/c", simplifyPath.simplifyPath(path3));
        String path4 = "/a/../../b/../c//.//";
        assertEquals("/c", simplifyPath.simplifyPath(path4));
    }

}