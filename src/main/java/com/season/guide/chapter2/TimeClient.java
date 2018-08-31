package com.season.guide.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Administrator on 2018/8/31.
 */
public class TimeClient {


    public static void main(String... args) throws IOException {

        int port = 8888;


        //-------- AIO写法 ------
        new Thread(new AsyncTimeClientHandler("127.0.0.1",port), "AIO-AsyncTimeClientHandler-001").start();


        //---------  nio写法 ------------
//        new Thread(new TimeClientHandler("127.0.0.1",port),"TimeClientHandler-001").start();




        //-----------阻塞I/O写法----------------------

//        Socket socket = null;
//        BufferedReader in = null;
//        PrintWriter out = null;
//        try {
//            socket = new Socket("127.0.0.1", port);
//            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            out = new PrintWriter(socket.getOutputStream(), true);
//            out.println("time");
//            System.out.println("客户端发送命令");
//            String result = in.readLine();
//            System.out.println("现在时间是：" + result);
//        } catch (IOException e) {
////            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                out.close();
//                out = null;
//            }
//            if (in != null) {
//                in.close();
//                in = null;
//            }
//            if (socket != null) {
//                socket.close();
//                socket = null;
//            }
//        }

    }

}
