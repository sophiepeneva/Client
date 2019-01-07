# Client
for my upload/download server

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Reader {


    public static byte[] readBytes(String inputFileName, PrintWriter pOut, DataOutputStream dOut) {

        File file = new File(inputFileName);
        byte[] result = new byte[1024];
        pOut.println((int)file.length());
        try (InputStream input = new BufferedInputStream(new FileInputStream(file))) {
            int totalBytesRead = 0;
            while (totalBytesRead < (int) file.length()) {
                result = new byte[8192];
                int bytesRead = input.read(result);
                dOut.write(result);
                dOut.flush();
                if (bytesRead > 0) {
                    totalBytesRead = totalBytesRead + bytesRead;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
