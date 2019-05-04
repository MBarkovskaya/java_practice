package practiseinputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Example6 {
    private static final String INTPUT = "Honor-logo.tiff";
    private static final String JUST_OUTPUT = "Honor-logo-just-output.tiff";
    private static final String OUTPUT_ZIP = "to.zip";
    private static final String INTPUT_ZIP_TO_NEW_FILE = "Honor-logo-1.tiff";

    public static void main(String[] args) throws IOException {
        Example6 example6 = new Example6();
        example6.convertingToFile();

        long fileSizeOriginal = Paths.get(INTPUT).toFile().length();
        long zipFileSize = (long) example6.createZip().get("fileLength");
        long difference = fileSizeOriginal - zipFileSize;

        System.out.printf("File original size is %s, ZIP file size is %s, Difference is %s", fileSizeOriginal, zipFileSize, difference);
        System.out.println("\n" + "===================");

        long timeDif = (long) example6.createZip().get("timeElapsed") - example6.convertingToFile();
        System.out.printf("ZIP file time of the record %s, original file time of the record %s, Difference is %s",
                example6.createZip().get("timeElapsed"), example6.convertingToFile(), timeDif);

        example6.unzipAndWriteNewFile();
    }

    private long convertingToFile() throws IOException {
        long timeElapsed = 0L;

        try (FileChannel in = new FileInputStream(INTPUT).getChannel();
             FileChannel out = new FileOutputStream(JUST_OUTPUT).getChannel()
        ) {
            ByteBuffer buff = ByteBuffer.allocateDirect(10 * 1024);

            while (in.read(buff) > 0) {
                buff.flip();
                long start = System.currentTimeMillis();
                out.write(buff);
                buff.clear();
                long finish = System.currentTimeMillis();
                timeElapsed = finish - start;
            }
        }
        return timeElapsed;
    }

    private HashMap createZip() {
        HashMap<String, Long> map = new HashMap<>();
        // the zip file name that we will create
        File zipFileName = Paths.get(OUTPUT_ZIP).toFile();
        File inputFileName = Paths.get(INTPUT).toFile();
        // open the zip stream in a try resource block, no finally needed

        // traverse every file in the selected directory and add them
        // to the zip file by calling addToZipFile(..)
        String inputFileNameStr = inputFileName.getPath();
        try (FileInputStream inputStream = new FileInputStream(inputFileNameStr); ZipOutputStream zipStream = new ZipOutputStream(
                new FileOutputStream(zipFileName))) {

            // create a new ZipEntry, which is basically another file
            // within the archive. We omit the path from the filename
            ZipEntry entry = new ZipEntry(inputFileName.getName());

            entry.setCreationTime(FileTime.fromMillis(inputFileName.lastModified()));
            entry.setComment("Created by TheCodersCorner");
            zipStream.putNextEntry(entry);

            // Now we copy the existing file into the zip archive. To do
            // this we write into the zip stream, the call to putNextEntry
            // above prepared the stream, we now write the bytes for this
            // entry. For another source such as an in memory array, you'd
            // just change where you read the information from.
            byte[] readBuffer = new byte[2048];
            int amountRead;

            long start = System.currentTimeMillis();
            while ((amountRead = inputStream.read(readBuffer)) > 0) {
                zipStream.write(readBuffer, 0, amountRead);
                long finish = System.currentTimeMillis();
                long timeEl = finish - start;
                String timeElapsed = "timeElapsed";
                map.put(timeElapsed, timeEl);
            }

        } catch (IOException | ZipParsingException e) {
            System.err.println("Error parsing " + e.getMessage());
        }
        long length = zipFileName.length();
        String fileLength = "fileLength";

        map.put(fileLength, length);
        return map;
    }

    private void unzipAndWriteNewFile() {

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(OUTPUT_ZIP))) {
            while (zin.getNextEntry() != null) {
                // unzip
                FileOutputStream fout = new FileOutputStream(INTPUT_ZIP_TO_NEW_FILE);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    /**
     * We want to let a checked exception escape from a lambda that does not
     * allow exceptions. The only way I can see of doing this is to wrap the
     * exception in a RuntimeException. This is a somewhat unfortunate side
     * effect of lambda's being based off of interfaces.
     */
    private class ZipParsingException extends RuntimeException {
        public ZipParsingException(String reason, Exception inner) {
            super(reason, inner);
        }
    }

}
