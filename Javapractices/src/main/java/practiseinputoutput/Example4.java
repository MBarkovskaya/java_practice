package practiseinputoutput;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example4 {
    public static void main(String[] args) throws IOException {
        Example4 example4 = new Example4();
        String[][] arrStr = example4.getArrayFromFileInput();

//        FileOutputStream file = new FileOutputStream("filewithmatrixout.txt");
//        try (DataOutputStream data = new DataOutputStream(file)) {
        try (FileOutputStream data = new FileOutputStream("filewithmatrixout.txt")) {
            int strIdx = 0;
            while (strIdx < arrStr.length) {
                for (int i = 0; i < arrStr.length; i++) {
                    data.write(arrStr[strIdx][i].getBytes());
                    data.write(" ".getBytes());
                }
                data.write("\n".getBytes());
                strIdx++;
            }
        }
    }

    private String[][] getArrayFromFileInput() {
        String[][] array = null;
        try (BufferedReader br = Files.newBufferedReader(Paths.get("filewithmatrix.txt"))) {
            String line;
            int rowIdx = 0;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(" ");
                if (array == null) {
                    array = new String[strings.length][strings.length];
                }
                for (int i = 0; i < strings.length; i++) {
                    array[i][rowIdx] = strings[i];
                }
                rowIdx++;

            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return array;
    }

}
