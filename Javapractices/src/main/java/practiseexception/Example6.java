package practiseexception;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Example6 {
    public static void main(String[] args) throws Exception {
        try {
            method1();
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("Catched " + e.getClass().getName());
        }
    }


    public static void method1() throws ArithmeticException, URISyntaxException, NullPointerException, FileNotFoundException {
        int i = (int) (Math.random() * 4);
        if (i == 0)
            throw new NullPointerException();
        if (i == 1)
            throw new ArithmeticException();
        if (i == 2)
            throw new FileNotFoundException();
        if (i == 3)
            throw new URISyntaxException("", "");
    }
}
