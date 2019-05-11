package practiseexception;

public class Example1 {
    public static void main(String[] args) {
        divisionByZero(1);
    }

    public static void divisionByZero(int x){
        try {
            int res = x/0;
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
