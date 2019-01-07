# Client
for my upload/download server

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;

public class Action {
    private ActionListener actionListener;

    public Action(ActionListener actionListener){
        this.actionListener = actionListener;
    }

    public byte[] doWork (byte[] filename, PrintWriter pOut,
                          BufferedReader reader, DataOutputStream dOut, DataInputStream dIn) {
        if(actionListener!=null){
            return actionListener.execute(new ActionEvent(filename),pOut,reader,dOut,dIn);
        }
        return null;
    }
}
