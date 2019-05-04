package practiseinputoutput;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) throws IOException {
        String filename = "scan.txt";
        Scanner fileScanner;
        System.out.println("Enter the type of data: ");
        Scanner con = new Scanner(System.in);
        String str = con.next();
        switch (str) {
            case "int":

                try (FileReader fr = new FileReader(filename)) {
                    fileScanner = new Scanner(fr);
                    while (fileScanner.hasNext()) {
                        if (fileScanner.hasNextInt()) {
                            System.out.println(", there is value: " + fileScanner.nextInt());
                        } else {
                            fileScanner.next();
                        }
                    }
                }
                break;
            case "boolean":
                try (FileReader fr = new FileReader(filename)) {
                    fileScanner = new Scanner(fr);
                    while (fileScanner.hasNext()) {
                        if(fileScanner.hasNextBoolean())
                        System.out.println(", there is value: " + fileScanner.nextBoolean());
                        else {
                            fileScanner.next();
                        }
                    }
                }
                break;
            case "double":
                try (FileReader fr = new FileReader(filename)) {
                    fileScanner = new Scanner(fr);
                    while (fileScanner.hasNext()) {
                        if(fileScanner.hasNextDouble())
                        System.out.println(", there is value: " + fileScanner.nextDouble());
                        else {
                            fileScanner.next();
                        }
                    }

                }
                break;
            case "String":
                try (FileReader fr = new FileReader(filename)) {
                    fileScanner = new Scanner(fr);
                    while (fileScanner.hasNext()) {
                        System.out.println(", there is value: " + fileScanner.next());
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + str);
        }
    }
}
