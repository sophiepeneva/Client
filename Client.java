# Client
for my upload/download server


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter pOut =
                        new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(echoSocket.getInputStream()));
                DataOutputStream dOut = new DataOutputStream(echoSocket.getOutputStream());
                DataInputStream dIn = new DataInputStream(echoSocket.getInputStream());
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                pOut.println(userInput);
                byte[] reaction = null;
                if (userInput.equals("upload")) {
                    System.out.println("Enter the filename : ");
                    Scanner scanner = new Scanner(System.in);
                    String filename = scanner.nextLine();
                    while (!Verifier.isValid(filename)) {
                        System.out.println("This file does not exist. Please enter a valid name : ");
                        filename = scanner.nextLine();
                    }
                    pOut.println(filename);
                    reaction = Command.getAction(userInput, filename.getBytes(),pOut,reader,dOut,dIn);
                }
                if (userInput.equals("download")) {
                    System.out.println("Enter the filename : ");
                    Scanner scanner = new Scanner(System.in);
                    String filename = scanner.nextLine();
                    pOut.println(filename);
                    int length = Integer.parseInt(reader.readLine());
                    byte[] text = new byte[length];
                    int data = -1;
                    while(data==-1) {
                        System.out.println("here");
                        data = dIn.readNBytes(text,0,length);
                        System.out.println("not here");
                    }
                    System.out.println(new String(text));

                    if (!(new String(text)).equals("file does not exist")) {
                        Command.getAction(userInput, text,pOut,reader,dOut,dIn);
                    } else {
                        System.out.println(new String(text));
                    }
                }
                if (userInput.equals("list files")) {
                    int length = Integer.parseInt(reader.readLine());
                    System.out.println(length);
                    byte[] fileDirs = dIn.readNBytes(length);
                    String[] files = new String(fileDirs).split(" ");
                    for (String s : files) {
                        System.out.println(s);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
