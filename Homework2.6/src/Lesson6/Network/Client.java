package Lesson6.Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket("localhost", 8189);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner console = new Scanner(System.in);

            Thread incoming = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String str = null;
                        try {
                            str = in.readUTF();
                            if (str.equals("/end")) {
                                out.writeUTF("/end");
                                break;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Server: " + str);
                    }
                }
            });
            incoming.start();

            Thread outgoing = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String str = console.nextLine();
                        try {
                            out.writeUTF(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            outgoing.setDaemon(true);
            outgoing.start();

            try {
                incoming.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
