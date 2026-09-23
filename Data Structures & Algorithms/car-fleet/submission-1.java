class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] positionSpeedPair  = new int[n][2];
        for(int i = 0; i < n; i++){
            positionSpeedPair[i][0] = position[i];
            positionSpeedPair[i][1] = speed[i];
        }
        Arrays.sort(positionSpeedPair, (x, y) -> Integer.compare(x[0], y[0]));

        float currReachingMile = 0; 
        int counter_fleet = 1;
        for (int i = n-1; i > 0; i--) {
            currReachingMile = reachingMile(positionSpeedPair[i][0], positionSpeedPair[i-1][0], positionSpeedPair[i][1], positionSpeedPair[i-1][1]);
            if (currReachingMile == -1) {
                counter_fleet++;
            } else if (currReachingMile > target){
                counter_fleet++;
            } else {
                positionSpeedPair[i-1] = positionSpeedPair[i]; 
                continue;
            }
        }
        

        return counter_fleet;
    }

    private float reachingMile(int position1, int position2, int speed1, int speed2){
        if (position1 != position2 && speed1 >= speed2) {
            return -1;
        } else if (position1 == position2 && speed1 == speed2){
            return 0;
        } else {
            float reachingTime = ((float) (position1- position2)) / (speed2 - speed1);
            return position1 + reachingTime * speed1;
        }
    }
}
