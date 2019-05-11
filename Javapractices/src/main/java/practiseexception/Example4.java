package practiseexception;

import java.util.ArrayList;

public class Example4 {
    public static void main(String[] args) {
        indexOutOfBoundExMethod();
    }

    private static void indexOutOfBoundExMethod() {
        try {
            ArrayList<String> list = new ArrayList<String>();
            String s = list.get(18);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
