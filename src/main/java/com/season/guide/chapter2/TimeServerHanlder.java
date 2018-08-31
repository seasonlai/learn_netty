package com.season.guide.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/31.
 */
public class TimeServerHanlder implements Runnable {

    private Socket socket;

    public TimeServerHanlder(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            String currentTime;
            String body = null;

            while (true) {
                body = reader.readLine();
                if (body == null) {
                    break;
                }
                System.out.println("服务器收到命令:" + body);
                currentTime = "time".equals(body) ? new Date(System.currentTimeMillis()).toString() : "无效命令";
                writer.println(currentTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
                writer = null;
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                socket = null;
            }
        }


    }
}
