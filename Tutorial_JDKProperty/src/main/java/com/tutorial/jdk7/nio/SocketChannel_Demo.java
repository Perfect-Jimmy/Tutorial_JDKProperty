package com.tutorial.jdk7.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Administrator on 2015/1/19.
 * TCP协议
 */
public class SocketChannel_Demo {
    public static void main(String[] args){
           /* 读取数据*/
           SocketChannel_Demo.readFromSocketChannel();
    }

    public static void readFromSocketChannel(){
        try {
            SocketChannel socketChannel = SocketChannel.open(); //打开SocketChannel通道
            socketChannel.connect(new InetSocketAddress("www.baidu.com",80));//获取连接
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);//分配缓冲区
            int bytesRead = socketChannel.read(byteBuffer);
            System.out.println(bytesRead);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
