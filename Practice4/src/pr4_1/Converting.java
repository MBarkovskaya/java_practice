package pr4_1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converting {
    public static void convert1(String fileName) {

        List<String> lines = Collections.emptyList();
        List<String> convertingLines = new ArrayList<>();
        String result = "";
        try {
            lines =
                    Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            for (int i = 0; i < 5; i++) {
                Pattern pattern = Pattern.compile("([\\wа-яА-Я]+);([\\wа-яА-Я]+) ([\\wа-яА-Я]+);([\\wа-я]+)@([\\wа-я]+\\.[\\w]+)");
                Matcher matcher = pattern.matcher(lines.get(i));
                if (matcher.matches()) {
                    result = matcher.group(1) + "==>" + matcher.group(4) + "@" + matcher.group(5);
                }
                convertingLines.add(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String convertingLine : convertingLines) {
            System.out.println(convertingLine);
        }
    }

    public static void convert2(String fileName) {
        List<String> lines = Collections.emptyList();
        List<String> convertingLines = new ArrayList<>();
        String result = "";
        try {
            lines =
                    Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            for (int i = 0; i < 5; i++) {
                Pattern pattern = Pattern.compile("([\\wа-яА-Я]+);([\\wа-яА-Я]+) ([\\wа-яА-Я]+);(\\w+@\\w+\\.\\w+)");
                Matcher matcher = pattern.matcher(lines.get(i));
                if (matcher.matches()) {
                    result = matcher.group(3) + " " + matcher.group(2) + " (email: " + matcher.group(3) + matcher.group(4) + ")";
                }
                convertingLines.add(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String convertingLine : convertingLines) {
            System.out.println(convertingLine);
        }
    }

    public static void convert3(String fileName) {
        List<String> lines = Collections.emptyList();
        List<String> convertingLines = new ArrayList<>();
        String result = "";
        try {
            lines =
                    Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            for (int i = 0; i < 5; i++) {
                Pattern pattern = Pattern.compile("([\\wа-яА-Я]+);(([\\wа-яА-Я]+) ?([\\wа-яА-Я]+)?);([\\wа-яА-Я]+)?(\\w+@\\w+\\.\\w+)?");
                Matcher matcher = pattern.matcher(lines.get(i));
                if (matcher.matches()) {
                    result = matcher.group(1) + ";" + matcher.group(2) + matcher.group(3) + matcher.group(4) + ")";
                }
                convertingLines.add(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String convertingLine : convertingLines) {
            System.out.println(convertingLine);
        }
    }
}
