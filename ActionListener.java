# Client
for my upload/download server

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;

public interface ActionListener {
    byte[] execute(ActionEvent actionEvent, PrintWriter pOut,
                   BufferedReader reader, DataOutputStream dOut, DataInputStream dIn);
}
