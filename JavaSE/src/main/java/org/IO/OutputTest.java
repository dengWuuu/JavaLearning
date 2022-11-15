package org.IO;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Wu
 * @date 2022年11月14日 21:12
 */
public class OutputTest {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("JavaSE/output.txt")) {
            byte[] array = "take the shit".getBytes();
            output.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

