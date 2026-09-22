class TimeMap {
    Map<String, List<Value>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Value> values = map.get(key);
        if (values == null) {
            values = new ArrayList<>();
            map.put(key, values);
        }

        Value val = new Value(value, timestamp);

        // int i = Collections.binarySearch(values, val);
        // if (i >= 0) {
        //     values.get(i).val = value;
        // } else {
        //     i = (i + 1) * (-1);
        //     values.add(i, val);
        // }

        values.add(val);
    }
    
    public String get(String key, int timestamp) {
        List<Value> values = map.get(key);
        if (values == null) {
            return "";
        }

        int i = Collections.binarySearch(values, new Value("", timestamp));
        if (i < 0) {
            i = (i + 1) * (-1);
            if (i == 0) return "";
            i -= 1;
        }
        return values.get(i).val;
    }
}

class Value implements Comparable<Value> {
    String val;
    int ts;

    Value(String val, int ts) {
        this.val = val;
        this.ts = ts;
    }

    public int compareTo(Value o) {
        return Integer.compare(this.ts, o.ts);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */