package practiseinputoutput;


import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example1 {

    public static void main(String[] args) throws IOException {
        Example1 example = new Example1();
        example.readAndChangePublicToPrivate("converting", "Converting.java");
        example.readAndChangePublicToPrivate("demo", "Demo.java");
        example.readAndChangePublicToPrivate("userinfo", "UserInfo.java");
        example.readAndChangePublicToPrivate("util", "Util.java");
    }
//    public void convertingInputStreamToFile()
//            throws IOException {
//        InputStream initialStream = new FileInputStream(
//                new File(Settings.getInstance().value("demo")));
//        byte[] buffer = new byte[initialStream.available()];
//        initialStream.read(buffer);
//        File targetFile = new File(String.format("%s%s",
//                this.getClass().getResource("/").getPath(), "Demo.java"));
//        Files.write(buffer, targetFile);
//    }

    private Path convertingInputStreamToFile(String fileProperty, String fileName)
            throws IOException {
        InputStream initialStream = FileUtils.openInputStream
                (new File(Settings.getInstance().value(fileProperty)));
        File targetFile = new File(String.format("%s%s", "/tmp/", fileName));
        FileUtils.copyInputStreamToFile(initialStream, targetFile);
        return targetFile.toPath();
    }

    private void readAndChangePublicToPrivate(String fileProperty, String fileName) throws IOException {
        Path targetFile = null;
        try {
            targetFile = this.convertingInputStreamToFile(fileProperty, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(targetFile)) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        Pattern pattern = Pattern.compile("(?mi)^(\\s*private)");
        Matcher matcher = pattern.matcher(sb.toString());
        StringBuffer sbuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sbuffer, "public");
        }
        StringBuffer buffer = matcher.appendTail(sbuffer);


        File resultTargetFile = new File(targetFile.toString());
        OutputStream outStream = new FileOutputStream(resultTargetFile, false);
        outStream.write(buffer.toString().getBytes());
        outStream.flush();
        outStream.close();
    }

}
