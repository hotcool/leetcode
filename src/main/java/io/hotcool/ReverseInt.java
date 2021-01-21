package io.hotcool;

import java.util.LinkedList;
import java.util.List;

public class ReverseInt{
  public int reverse(int x) {
         int result = 0;
        int tail = 0;

        while (x != 0) {
            if (tail > Integer.MAX_VALUE / 10 || tail < Integer.MIN_VALUE / 10)
                return 0;
            tail = tail * 10 + x % 10;
            x = x / 10;
            result = tail + x;
        }

        return result;
    }

    int[] sum;

    public int numDecodings(String s) {
        if (null == s || 0 == s.length() || "0".equals(s))
            return 0;

        sum = new int[s.length()];
        return find(s, 0);
    }

    private int find(String s, int i){
        if(i >= s.length())
            return 1;

        if('0' == s.charAt(i))
            return 0;

        if(sum[i] != 0)
            return sum[i];

        if(i + 1 < s.length() && Integer.parseInt(String.valueOf(s.charAt(i))+ s.charAt(i+1)) < 27)
            sum[i] += find(s, i + 2);

        sum[i] += find(s, i + 1);

        return sum[i];
    }

    String template = "%s.%s.%s.%s";
    List<String> result = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if(null == s || 4 > s.length()){
            return result;
        }

        List<String> tmp = new LinkedList<>();
        restoreIpAddresses(tmp, s, 0);
        return result;
    }

    private void restoreIpAddresses(List<String> tmp, String s, int i){
        if(tmp.size() > 4)
            return;

        if(i == s.length() && 4 == tmp.size()){
            result.add(String.format(template, tmp.get(0), tmp.get(1), tmp.get(2), tmp.get(3)));
        }

        for(int j = i + 1; j <= s.length(); ++j){
            String token = s.substring(i, j);
            if(!isValid(token)){
                continue;
            }

            tmp.add(token);
            restoreIpAddresses(tmp, s, j);
            tmp.remove(tmp.size() - 1);
        }
    }

    private boolean isValid(String token) {
        if(null == token || token.isEmpty())
            return false;

        int len = token.length();
        for(int i = 0; i < token.length(); ++i){
            if('0' == token.charAt(i)){
                --len;
            }
            else {
                break;
            }
        }

        if(len > 3)
            return false;

        int v = Integer.parseInt(token);
        if(v < 0 || v > 255)
            return false;

        if(!String.valueOf(v).equals(token))
            return false;

        return true;
    }
}
