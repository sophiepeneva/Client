# Client
for my upload/download server

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

public class Verifier {
    private static boolean exists(String path, String filename) {

        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) {
            return false;
        }

        for (File f : list) {
            if (f.isDirectory()) {
                exists(f.getAbsolutePath(), filename);
            } else {

                if (f.getAbsoluteFile().toString().contains(filename)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValid(String filename){
        return exists(Paths.get(".").toAbsolutePath().toString(), filename);
    }
}
