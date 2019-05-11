package practiseexception;

public class Example3 {
    public static void main(String[] args) {
        outOfBoundExMethod();
    }

    private static void outOfBoundExMethod() {
        try {
            int[] m = new int[2];
            m[8] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
