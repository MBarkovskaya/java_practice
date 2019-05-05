package practiseinputoutput;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example3 {
    public static void main(String[] args) throws IOException {
        Example3 example = new Example3();
        example.readAndDeleteComments("converting", "Converting.java");
        example.readAndDeleteComments("userinfo", "UserInfo.java");
        example.readAndDeleteComments("util", "Util.java");
    }

    private Path convertingInputStreamToFile(String fileProperty, String fileName)
            throws IOException {
        InputStream initialStream = FileUtils.openInputStream
                (new File(Settings.getInstance().value(fileProperty)));
        File targetFile = new File(String.format("%s%s", "/tmp/", fileName));
        FileUtils.copyInputStreamToFile(initialStream, targetFile);
        return targetFile.toPath();
    }

    private void readAndDeleteComments(String fileProperty, String fileName) throws IOException {

        Path targetFile = this.convertingInputStreamToFile(fileProperty, fileName);
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

        Pattern pattern = Pattern.compile("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/");
        Matcher matcher = pattern.matcher(sb.toString());
        StringBuffer sbuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sbuffer, "");
        }
        StringBuffer buffer = matcher.appendTail(sbuffer);


        File resultTargetFile = new File(targetFile.toString());
        OutputStream outStream = new FileOutputStream(resultTargetFile, false);
        outStream.write(buffer.toString().getBytes());
        outStream.flush();
        outStream.close();
    }
}
