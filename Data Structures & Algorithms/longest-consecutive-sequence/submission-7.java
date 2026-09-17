class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);  
        }

        int result = 1;
        int curr;
        int curr_longest = 1;
        for(int num : nums){
            if (set.contains(num-1)){
                continue;
            } else {
                curr = num; 
                while(set.contains(curr+1)){
                    curr_longest++;
                    curr++;
                }
                if(curr_longest > result){
                    result = curr_longest;
                }

                curr_longest = 1;
            }
        }
        return result; 
    }
}
