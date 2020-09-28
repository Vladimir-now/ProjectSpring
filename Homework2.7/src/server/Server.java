package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clients;

    public Server() {
        ServerSocket server = null;
        Socket socket = null;

        try {
            AuthService.connect();
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");
            clients = new Vector<>();

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
        broadcastClientList();
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastClientList();
    }

    public void broadcastMsg(ClientHandler from, String msg) {
        for (ClientHandler o : clients) {
            if(!o.checkBlackList(from.getNick())) {
                o.sendMsg(msg);
            }
        }
    }

    public boolean hasNick (String nick) {
        for (ClientHandler o : clients){
            if (o.getNick().equals((nick))){
                return true;
            }
        }
        return false;
    }

    public void personalMsg (ClientHandler person, String toNick,  String msg) {
        for (ClientHandler o: clients) {
            if (o.getNick().equals(toNick)) {
                o.sendMsg("от " + person.getNick() + ": " + msg);
                person.sendMsg("для " + toNick + ": " + msg);
                return;
            }
        }
        person.sendMsg(toNick + " нет в чате");
    }

    public void broadcastClientList() {
        StringBuilder sb = new StringBuilder();
        sb.append("/clientlist ");
        for (ClientHandler o: clients) {
            sb.append(o.getNick() + " ");
        }
        String out = sb.toString();

        for (ClientHandler o: clients) {
            o.sendMsg(out);
        }
    }
}
