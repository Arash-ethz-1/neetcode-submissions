class Solution {
    public int maxArea(int[] heights) {
        int start_pointer = 0; 
        int end_pointer = heights.length - 1; 
        int max_area = area(start_pointer, end_pointer, heights);

        while (start_pointer != end_pointer){
            if (heights[start_pointer] > heights[end_pointer]) {
                end_pointer--;
                max_area = Math.max(max_area, area(start_pointer, end_pointer, heights));
            } else {
                start_pointer ++; 
                max_area = Math.max(max_area, area(start_pointer, end_pointer, heights));
            }
        }

        return max_area;
    }

    private int area(int start, int end, int[] heights){
        return Math.min(heights[start], heights[end]) * (end - start);
    }
}
