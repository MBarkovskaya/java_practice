package practiseexception;

public class Example2 {
    public static void main(String[] args) {
        toLowerCaseMethod();
    }

    private static void toLowerCaseMethod(){
        try {
            String s = null;
            String m = s.toLowerCase();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
