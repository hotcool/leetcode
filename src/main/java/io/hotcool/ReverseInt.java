package io.hotcool;

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
}