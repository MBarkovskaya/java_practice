package pr4_1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;

/*
any notices
 */
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
    //any notices

    public static void main(String[] args) throws Exception {
        Map<String, Charset> map = Charset.availableCharsets();
        for (String key: map.keySet()) {
            Charset charset = map.get(key);
            System.out.printf("canonical: %-20s aliases: ", charset.name());
            for (String alias : charset.aliases()) {
                System.out.print(alias);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

}
