package io.hotcool;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if(null == nums || 0 == nums.length)
            return ans;

        permute(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    private void permute(List<List<Integer>> ans, List<Integer> tmp, int[] nums, boolean[] visited){
        if(tmp.size() >= nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; ++i){
            if(visited[i])
                continue;
            visited[i] = true;
            tmp.add(nums[i]);
            permute(ans, tmp, nums, visited);
            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

}
