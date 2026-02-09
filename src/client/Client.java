package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("212.8.226.64", 9123); // Сокет - это ip + port
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            Thread thread = new Thread(()->{
                String response = null;
                while (true){
                    try {
                        response = in.readUTF();
                        System.out.println(response);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            thread.start();
            while (true){
                String msg = scanner.nextLine();
                out.writeUTF(msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}