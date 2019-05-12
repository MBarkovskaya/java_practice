package practiseinputoutput;

import com.google.common.io.Files;

import java.io.*;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex {
    public static void main(String[] args) {
        Example1 example = new Example1();
        try {
            example.readAndChangePublicToPrivate("converting", "Converting.java");
            example.readAndChangePublicToPrivate("demo", "Demo.java");
            example.readAndChangePublicToPrivate("userinfo", "UserInfo.java");
            example.readAndChangePublicToPrivate("util", "Util.java");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Path convertingInputStreamToFile(String fileProperty, String fileName) throws IOException {
        InputStream initialStream = new FileInputStream(
                new File(Settings.getInstance().value(fileProperty)));
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);
        File targetFile = new File(String.format("%s%s", "/tmp/", fileName));
        Files.write(buffer, targetFile);
        return targetFile.toPath();
    }

//    private Path convertingInputStreamToFile(String fileProperty, String fileName)
//            throws IOException {
//        InputStream initialStream = FileUtils.openInputStream
//                (new File(Settings.getInstance().value(fileProperty)));
//        File targetFile = new File(String.format("%s%s", "/tmp/", fileName));
//        FileUtils.copyInputStreamToFile(initialStream, targetFile);
//        return targetFile.toPath();
//    }

    public void readAndChangePublicToPrivate(String fileProperty, String fileName) throws IOException {

        Path targetFile = this.convertingInputStreamToFile(fileProperty, fileName);

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = java.nio.file.Files.newBufferedReader(targetFile)) {

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
