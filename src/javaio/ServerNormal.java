package javaio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class ServerNormal {
    //默认的端口号
    private static int DEFAULT_PORT=12345;
    //单例的ServerSocket
    private static ServerSocket server;

    public static void start() throws IOException{
        start(DEFAULT_PORT);
    }
    public synchronized static void start(int port) throws IOException{
        if (server != null){
            return;
        }
        server=new ServerSocket(port);
        System.out.println("服务器已启动，端口号："+port);
        while (true){
            Socket socket = server.accept();
            new Thread(new ServerHandler(socket)).start();
        }
    }

    public static void main(String[] args) throws IOException {
        start();
    }
}
