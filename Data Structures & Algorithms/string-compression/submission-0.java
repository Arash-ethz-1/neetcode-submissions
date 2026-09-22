class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        StringBuilder s = new StringBuilder();

        if(n == 1 || n == 0){
            return n;
        }

        int counter = 1;
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                counter++;
            } else {
                if (counter == 1) {
                    s.append(chars[i]);
                } else {
                    s.append(chars[i]).append("" + counter);
                    counter = 1;
                }
            }
        }

        if (chars[n-1] == chars[n-2]){
            s.append(chars[n-1]).append("" + counter);
        } else {
            s.append(chars[n-1]);
        }
        for(int i = 0; i < s.length(); i++){
            chars[i] = s.charAt(i);
        }
        return s.length();
    }

    
}