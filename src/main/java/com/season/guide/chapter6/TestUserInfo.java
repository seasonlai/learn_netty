package com.season.guide.chapter6;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2018/9/1.
 */
public class TestUserInfo {


    public static void main(String... args) throws IOException {

        UserInfo userInfo = new UserInfo();
        userInfo.buildUserId(10).buildUserName("season");

//        testSize(userInfo);
        testSpeed(userInfo);

    }


    private static void testSpeed(UserInfo userInfo) throws IOException {
        int loop = 1000;
        long startTime = System.currentTimeMillis();
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        for (int i = 0; i < loop; i++) {

            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(userInfo);
            oos.flush();
            oos.close();
            byte[] b = baos.toByteArray();
            baos.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("jdk花费的时间为：" + (endTime - startTime) + "ms");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            byte[] b = userInfo.codeC(buffer);
        }
        endTime = System.currentTimeMillis();
        System.out.println("二进制编码花费时间：" + (endTime - startTime) + "ms");
    }

    private static void testSize(UserInfo userInfo) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(userInfo);
        oos.flush();
        oos.close();
        byte[] b = baos.toByteArray();
        System.out.println("jdk序列化后的大小：" + b.length);
        System.out.println("二进制编码大小：" + userInfo.codeC().length);
    }

}
