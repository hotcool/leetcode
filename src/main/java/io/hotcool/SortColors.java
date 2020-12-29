package io.hotcool;

public class SortColors {

    public void sortColors(int[] nums) {
        if(null == nums || nums.length == 0)
            return;

        int i = 0, j = 0, l = nums.length - 1;
        int tmp;
        while (j <= l){
            switch (nums[j]){
                case 0:
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    ++i;
                    ++j;
                    break;
                case 1:
                    ++j;
                    break;
                case 2:
                    tmp = nums[l];
                    nums[l] = nums[j];
                    nums[j] = tmp;
                    --l;
                    break;
                default: break;
            }
        }
    }

}
