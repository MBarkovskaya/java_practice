package practiseexception;

import java.util.HashMap;

public class Example5 {
    public static void main(String[] args) {
        nullPointerExMethod();
    }

    private static void nullPointerExMethod() {
        try {
            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
