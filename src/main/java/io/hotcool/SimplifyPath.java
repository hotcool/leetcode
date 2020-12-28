package io.hotcool;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if(null == path || path.isEmpty())
            return path;

        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String t : s){
            if(t.length() > 0) {
                if (".".compareTo(t) == 0) {
                    continue;
                }
                if ("..".compareTo(t) == 0) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(t);
                }
            }
        }
        return "/" + String.join("/", stack);
    }

}
