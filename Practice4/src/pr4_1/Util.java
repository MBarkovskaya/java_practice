package pr4_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Util {
    public static String getInput(String fileName) {
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(lineSeparator);
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }

}