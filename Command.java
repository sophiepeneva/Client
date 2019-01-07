# Client
for my upload/download server

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;

public class Command {
    public static byte[] getAction(String action, byte[] filename, PrintWriter pOut,
                                   BufferedReader reader, DataOutputStream dOut, DataInputStream dIn) {
        switch (action.toUpperCase()) {
            case "UPLOAD":
                return new Action(new Uploader()).doWork(filename,pOut,reader,dOut,dIn);
            case "DOWNLOAD":
                return new Action(new Downloader()).doWork(filename,pOut,reader,dOut,dIn);
            case "EXIT":
                System.exit(1);
            default:
                System.out.println("Illegal action");
                break;
        }
        return null;
    }
}
