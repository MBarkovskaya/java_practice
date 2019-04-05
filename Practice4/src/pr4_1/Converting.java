package pr4_1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converting {
    public static void convert1(List<String> lines) {
        List<String> convertingLines = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String result = "";
            Pattern pattern = Pattern.compile("([\\wа-яА-Я]+);([\\wа-яА-Я]+) ([\\wа-яА-Я]+);(\\w+@\\w+\\.\\w+)");
            Matcher matcher = pattern.matcher(lines.get(i));
            if (matcher.matches()) {
                result = matcher.group(1) + "==>" + matcher.group(4);
            }
            convertingLines.add(result);
        }
        printLines(convertingLines);
    }

    public static void convert2(List<String> lines) {
        List<String> convertingLines = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String result = "";
            Pattern pattern = Pattern.compile("([\\wа-яА-Я]+);([\\wа-яА-Я]+) ([\\wа-яА-Я]+);(\\w+@\\w+\\.\\w+)");
            Matcher matcher = pattern.matcher(lines.get(i));
            if (matcher.matches()) {
                result = matcher.group(3) + " " + matcher.group(2) + " (email: " + matcher.group(4) + ")";
            }
            convertingLines.add(result);
        }
        printLines(convertingLines);
    }

    private static void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void convert3(List<UserInfo> userInfos) {
        for (UserInfo userInfo : userInfos) {
            if (userInfo.getUserInfoMap().containsKey("mail.ru")) {
                String string = userInfo.getUserInfoMap().get("mail.ru").toString();
                Pattern pattern = Pattern.compile("(\\w+)@(\\w+\\.\\w+)");
                Matcher matcher = pattern.matcher(string);
                if (matcher.matches()) {
                    System.out.println(matcher.group(2) + "==>" + userInfo.getSurmame());
                }
            }
            if (userInfo.getUserInfoMap().containsKey("google.com")) {
                String string1 = userInfo.getUserInfoMap().get("google.com").toString();
                Pattern pattern1 = Pattern.compile("(\\w+)@(\\w+\\.\\w+)");
                Matcher matcher1 = pattern1.matcher(string1);
                if (matcher1.matches()) {
                    System.out.println(matcher1.group(2) + "==>" + userInfo.getSurmame());
                }
            }
        }
    }
}

//    public static void convert4(List<String> lines) {
//        List<String> convertingLines = new ArrayList<>();
//        int counter = lines.size();
//        String result = "";
//        for (int i = 0; i < counter; i++) {
//            Pattern pattern = Pattern.compile("([\\wа-яА-Я]+);(([\\wа-яА-Я]+) ?([\\wа-яА-Я]+)?);([\\wа-яА-Я]+)?(\\w+@\\w+\\.\\w+)?");
//            Matcher matcher = pattern.matcher(lines.get(i));
//            if (matcher.matches()) {
//                result = matcher.group(1) + ";" + matcher.group(2) + matcher.group(3) + matcher.group(4) + ")";
//            }
//            convertingLines.add(result);
//        }
//        for (String convertingLine : convertingLines) {
//            System.out.println(convertingLine);
//        }
//    }

