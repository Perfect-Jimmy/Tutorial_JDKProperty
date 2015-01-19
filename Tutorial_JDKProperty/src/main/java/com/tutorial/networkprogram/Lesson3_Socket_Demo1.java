package com.tutorial.networkprogram;

import java.io.*;
import java.net.Socket;

/**
 * 网络应用分为客户端和服务端两部分,而Socket类是负责处理客户端通信的Java类.
 * 通过这个类可以连接到指定IP或域名的服务器上,并且可以和服务器互相发送和接受数据.
 * Socket类的基本步骤:
 * 1 连接服务器
 * 2 发送和接收数据
 * 3 关闭网络连接
 * Created by Administrator on 2015/1/19.
 */
public class Lesson3_Socket_Demo1 {
    public static void main(String[] args) {
        /* 连接操作*/
        // Lesson3_Socket_Demo1.connectMethod();
        /*发送和接收数据*/
        Lesson3_Socket_Demo1.dataOperateMethod();
    }

    public static void connectMethod(){
        try {
            Socket socket = new Socket("www.baidu.com",80);//Socket[addr=www.baidu.com/58.217.200.37,port=80,localport=3517]
         // Socket socket = new Socket("127.0.0.1",3306);  //Socket[addr=/127.0.0.1,port=3306,localport=3494]
            System.out.println(socket);
            socket.close();//关闭
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dataOperateMethod(){
        try {
            Socket socket = new Socket("www.baidu.com", 80);
            // 向服务端程序发送数据
            OutputStream ops  = socket.getOutputStream();
            OutputStreamWriter opsw = new OutputStreamWriter(ops);
            BufferedWriter bw = new BufferedWriter(opsw);

            bw.write("hello world\r\n\r\n"); // --- \r\n\r\n代表输入结束
            bw.flush();

            // 从服务端程序接收数据
            InputStream ips = socket.getInputStream();
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String s = "";
            while((s = br.readLine()) != null)
                System.out.println(s);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
