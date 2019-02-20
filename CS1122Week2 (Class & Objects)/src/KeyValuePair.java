

public class KeyValuePair {

    private String key;
    private double value;

    public KeyValuePair(String key, double value) {
        this.key = key;
        this.value = value;
    }


//    public KeyValuePair(double value) {
//        this.value = value;
//    }
//
//    public KeyValuePair(String key, double value) {
//        this(value);
//        this.key = key;
//
//    }

    public String getKey() {
        return key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString () {
        return String.format("<%s, %, .2f>", key, value);
    }

    public static void main(String[] args) {
        KeyValuePair kvp = new KeyValuePair("ID",1234.5678);
        System.out.println(kvp);
    }

}

