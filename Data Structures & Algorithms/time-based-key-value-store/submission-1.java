class TimeMap {
    private record pair(String value, int timestamp) {}

    private final Map<String, List<pair>> map = new HashMap<>(); 

    public TimeMap() {}
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).add(new pair(value, timestamp));
        } else {
            map.put(key, new ArrayList<>());
            map.get(key).add(new pair(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)){
            return "";
        } else {
            return binarySearch(timestamp, map.get(key));
        }
    }

    private String binarySearch(int timestamp, List<pair> currList) {
        if (currList.isEmpty()){
            return "";
        }

        int m = currList.size() / 2;
        pair mid = currList.get(m);
        if (mid.timestamp() > timestamp) {
            return binarySearch(timestamp, currList.subList(0, m));
        }
        if (currList.size() == m + 1 || currList.get(m+1).timestamp() > timestamp) {
            return mid.value();
        }

        return binarySearch(timestamp, currList.subList(m, currList.size()));
    }
}

