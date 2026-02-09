package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(9123);
            System.out.println("Сервер запущен на порту 9123");
            System.out.println("Ожидаем клиента");
            while (true){
                Socket socket = serverSocket.accept(); // Ожидаем подключения клиента
                System.out.println("Клиент подключился");
                User user = new User(socket);
                users.add(user);
                Thread thread = new Thread(()->{
                    try {
                        user.getOut().writeUTF("Ваше имя: ");
                        user.setName(user.getIn().readUTF());
                        while (true){
                            String request = user.getIn().readUTF();
                            System.out.println(request);
                            for (User user1 : users){
                                if (user1 != user){
                                    user1.getOut().writeUTF(user.getName()+": "+request);
                                }
                            }
                        }
                    }catch (IOException e){
                        System.out.println("Клиент отключился");
                        users.remove(user);
                    }
                });
                thread.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
