# Client
for my upload/download server

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;

public class Uploader implements ActionListener {

    public byte[] execute(ActionEvent actionEvent, PrintWriter pOut,
                          BufferedReader reader, DataOutputStream dOut, DataInputStream dIn) {
        return Reader.readBytes(new String(actionEvent.getFilename()),pOut,dOut);
    }
}
