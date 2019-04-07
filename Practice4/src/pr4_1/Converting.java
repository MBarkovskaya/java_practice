package pr4_1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converting {
    public static void convert1(List<String> lines) {
        List<String> convertingLines = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String result = "";
            Pattern pattern = Pattern.compile("(?iU)(\\w+);(\\w+) (\\w+);(\\w+@\\w+\\.\\w+)");
            Matcher matcher = pattern.matcher(lines.get(i));
            if (matcher.matches()) {
                result = matcher.group(1) + "==>" + matcher.group(4);
            }
            convertingLines.add(result);
        }
        printLines(convertingLines);
        System.out.println("===============");
    }

    public static void convert2(List<String> lines) {
        List<String> convertingLines = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String result = "";
            Pattern pattern = Pattern.compile("(?iU)(\\w+);(\\w+) (\\w+);(\\w+@\\w+\\.\\w+)");
            Matcher matcher = pattern.matcher(lines.get(i));
            if (matcher.matches()) {
                result = matcher.group(3) + " " + matcher.group(2) + " (email: " + matcher.group(4) + ")";
            }
            convertingLines.add(result);
        }
        printLines(convertingLines);
        System.out.println("===============");
    }

    public static void convert3(List<UserInfo> userInfos) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (UserInfo userInfo : userInfos) {
            if (!map.containsKey(userInfo.getDomainName())) {
                map.put(userInfo.getDomainName(), new ArrayList<>());
            }
            map.get(userInfo.getDomainName()).add(userInfo.getSurmame());
        }

        for (Map.Entry<String, List<String>> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.getKey() + "==>" + listToString(mapEntry.getValue()));
        }
        System.out.println("===============");
    }

//    ("(?Ui)(\\w+);((\\w) ?(\\w+)?);(\\w+)?(\\w+@\\w+\\.\\w+)?")

    public static void convert4(List<String> lines) {
//        Random r = new Random();
//        int n = (1000 + r.nextInt() * 9000);

    }

    private static void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static String listToString(List<String> list) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
             buffer.append(list.get(i));
             if (i < list.size() - 1) {
                 buffer.append(",");
             }

        }
        return buffer.toString();
    }

}

