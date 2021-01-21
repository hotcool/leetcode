package io.hotcool;

import java.util.*;

public class Combination {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        process(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void process(int start, int n, int k, List<Integer> tmp, List<List<Integer>> result){
        if(tmp.size() == k){
            result.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = start; i <= n; ++i){
            tmp.add(i);
            process(i + 1, n, k, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for(int i = 0; i <= nums.length; ++i){
            processS(0, nums.length, i, new ArrayList<>(), result, nums);
        }
        return result;
    }

    private void processS(int start, int n, int k, List<Integer> tmp, List<List<Integer>> result, int[] nums){
        if(tmp.size() == k){
            result.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = start; i < n; ++i){
            tmp.add(nums[i]);
            processS(i + 1, n, k, tmp, result, nums);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(null == nums || 0 == nums.length)
            return null;

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i < nums.length; ++i){
            processD(0, new ArrayList<>(), result, nums);
        }

        return new ArrayList<>(result);
    }

    private void processD(int start, List<Integer> tmp, Set<List<Integer>> result, int[] nums){
        result.add(new ArrayList<>(tmp));

        for(int i = start; i < nums.length; ++i){
            tmp.add(nums[i]);
            processD(i + 1, tmp, result, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}
