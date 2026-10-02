class TimeMap {
    private record Pair(String value, int timestamp) {}

    private final Map<String, List<Pair>> map = new HashMap<>();

    public TimeMap() {}
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if (list == null) {
            return "";
        }

        int low = 0;
        int high = list.size() - 1;
        String result = "";

        while(low <= high) {
            int m = low + (high - low) / 2;
            Pair mid = list.get(m);
            if (mid.timestamp() <= timestamp) {
                result = mid.value();
                low = m + 1;
            } else {
                high = m - 1;
            }
        }

        return result;
    }
}
