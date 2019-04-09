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

    public static void convert4(List<String> lines) {
        Random r = new Random();
        int n = 0;
        List<String> convertingLines = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++, n = (int) (1000 + r.nextFloat() * 9000)) {
            String result = "";
            Pattern pattern = Pattern.compile("(?Ui)(\\w+);(\\w+);(\\w+)");
            Pattern pattern1 = Pattern.compile("(?Ui)(\\w+);((\\w+) (\\w+));(\\w+@\\w+\\.\\w+)");
            Matcher matcher = pattern.matcher(lines.get(i));
            Matcher matcher1 = pattern1.matcher(lines.get(i));
            if (matcher1.matches()) {
                result = matcher1.group().replaceAll(matcher1.group(), matcher1.group() + ";" + n);
            }
            if (matcher.matches()) {
                result = matcher.group().replaceAll(matcher.group(), matcher.group() + ";Password");
            }
            convertingLines.add(result);
        }
        printLines(convertingLines);
        System.out.println("===============");
    }

    public static void convert5(List<String> lines) {
        TreeMap<Integer, HashSet<String>> map = new TreeMap<>();
        Integer wordLength;
        for (int i = 0; i < lines.size(); i++) {
            String[] array = lines.get(i).split("( )|(')|(,)|-");
            System.out.println(array[0]);
            for (String word : array) {
                wordLength = word.length();
                if (wordLength != 0) {
                    if (!map.containsKey(wordLength)) {
                        map.put(wordLength, new HashSet<String>());
                    }
                    map.get (wordLength).add(word);
                }

            }
        }
        System.out.println(map.firstEntry());
        System.out.println(map.lastEntry());
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



