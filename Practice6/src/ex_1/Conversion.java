package ex_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Conversion {
    public static void main(String[] args) {
        Conversion conversion = new Conversion();
        try {
            conversion.convertingToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convertingToFile() throws IOException {
        Path path = Paths.get("text.txt");

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        Pattern pattern = Pattern.compile("(?iUm)([а-яё]{3,})");
        Matcher matcher = pattern.matcher(data);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        Files.write(Paths.get("textconv.txt"), sb.toString().getBytes());

    }
}
