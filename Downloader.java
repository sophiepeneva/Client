# Client
for my upload/download server

import java.io.*;
import java.util.Scanner;

public class Downloader implements ActionListener {

    void write(String outputFileName,byte[] input) {
        try (OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFileName))) {
            output.write(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public byte[] execute(ActionEvent actionEvent, PrintWriter pOut,
                          BufferedReader reader, DataOutputStream dOut, DataInputStream dIn){
        System.out.println("What name would you like your file to be saved under : ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        write(filename,actionEvent.filename);
        return null;
    }
}
