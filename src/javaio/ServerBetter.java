package javaio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ServerBetter {
    //默认的端口号
    private static int DEFAULT_PORT=12345;
    //单例的ServerSocket
    private static ServerSocket server;
    //线程池 懒汉式的单例
    private static ExecutorService executorService= Executors.newFixedThreadPool(60);

    public static void start() throws IOException{
        start(DEFAULT_PORT);
    }
    public synchronized static void start(int port) throws IOException {
        if (server != null){
            return;
        }
        try {
            server=new ServerSocket(port);
            System.out.println("服务器已启动，端口号："+port);
            while (true){
                Socket socket = server.accept();
                executorService.execute(new ServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //一些必要的清理工作
            if(server != null){
                System.out.println("服务器已关闭。");
                server.close();
                server = null;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        start();
    }
}
