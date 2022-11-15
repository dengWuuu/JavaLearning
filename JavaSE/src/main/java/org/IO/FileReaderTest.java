package org.IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Wu
 * @date 2022年11月14日 21:16
 */
public class FileReaderTest {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("JavaSE/src/input.txt")) {
            int content;
            long skip = fileReader.skip(3);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fileReader.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
