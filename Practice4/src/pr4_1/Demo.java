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

public class Demo {
    private final static String FILE_NAME = "src/part1.txt";

    public static void main(String[] args) {
        Converting.convert1(readFile(FILE_NAME));
        Converting.convert2(readFile(FILE_NAME));
        Converting.convert3(readFileMakeUserInfo(FILE_NAME));
//        Converting.convert4(readFile(FILE_NAME));
    }

    private static List<String> readFile(String fileName) {
        List<String> lines = Collections.emptyList();
        try {
            lines =
                    Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static List<UserInfo> readFileMakeUserInfo(String fileName) {
        List<UserInfo> userInfos = new ArrayList<>();
        List<String> lines;
        try {
            lines =
                    Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            for (int i = 0; i < lines.size(); i++) {

//                ("(?Uui)(\\w+(\\s|;|@|\\.)?){6}")
                Pattern pattern = Pattern.compile("(?Ui)(\\w+);(\\w+) (\\w+);(\\w+)@(\\w+\\.\\w+)");
                Matcher matcher = pattern.matcher(lines.get(i));
                if (matcher.matches()) {
                    String surname = matcher.group(1);
                    String email = matcher.group(4) + "@" + matcher.group(5);
                    String domainName = matcher.group(5);
                    UserInfo userInfo = new UserInfo(surname, domainName, email);
                    userInfos.add(userInfo);
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return userInfos;
    }
}
