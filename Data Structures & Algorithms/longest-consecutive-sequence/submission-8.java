class Solution {
    public int longestConsecutive(int[] nums) {
        int[] sorted = nums.clone();

        Arrays.sort(sorted);

        if(nums.length == 0){
            return 0;
        }

        int longest = 0;
        int current_length = 0;
        for(int i = 0; i < (nums.length - 1); i++){
            if(sorted[i]+1 == sorted[i+1]){
                current_length++;
            } else if(sorted[i] == sorted[i+1]){
                continue;
            } else {
                if (current_length > longest){
                   longest = current_length; 
                }
                current_length = 0;
            }
        }

        if (current_length > longest){
            longest = current_length; 
        }

        return longest+1;
    }
}
