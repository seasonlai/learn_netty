package com.season.guide.chapter2;

import java.io.IOException;

/**
 * Created by Administrator on 2018/8/31.
 */
public class TimeServer {

    public static void main(String... args) throws IOException {

        int port = 8888;

        //-------- AIO写法 ------
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();

        //---------  nio写法 ------------
//        MultiplexerTimeServerHandler server = new MultiplexerTimeServerHandler(port);
//        new Thread(server,"nio-MultiplexerTimeServerHandler-001").start();


        //--------------------阻塞I/O的写法-------------------------
//
//        ServerSocket serverSocket =null;
//        TimeServerExecutePool executePool = new TimeServerExecutePool(20,1000);
//        try {
//            serverSocket = new ServerSocket(8888);
//            System.out.println("服务器监听端口"+port);
//
//            while (true){
//                Socket socket = serverSocket.accept();
////                new Thread(new TimeServerHanlder(socket)).start();
//                executePool.execute(new TimeServerHanlder(socket));
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(serverSocket!=null){
//                System.out.println("服务器关闭...");
//                serverSocket.close();
//                serverSocket = null;
//            }
//        }


    }


}
