package ex_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converting {
    public static void main(String[] args) {
        convert(Collections.singletonList("When I was younger"));
        convert(Collections.singletonList("I never needed"));
//        convert(getInput(2));
    }

    public static void convert(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            Pattern pattern = Pattern.compile("(U)^[a-z]");
            Matcher m = Pattern.compile("(?U)(\\w)(\\w+)").matcher(input.toString());
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                m.appendReplacement(sb, m.group(1).toUpperCase() + m.group(2));
            }
            m.appendTail(sb);
            System.out.println(sb.toString());
        }

    }

    private static ArrayList<String> getInput(int num) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Write text: ");
            list.add(sc.nextLine());
        }
        return list;
    }

}
