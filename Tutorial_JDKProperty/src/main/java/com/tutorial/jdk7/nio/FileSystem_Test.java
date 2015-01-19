package com.tutorial.jdk7.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


/**
 * Created by Administrator on 2015/1/16.
 */
public class FileSystem_Test {
    public static void main(String[] args) throws IOException {
        /*获取文件属性*/
        //FileSystem_Test.listFileProperties();
        /*读文件*/
       // FileSystem_Test.readFile();
        /*写文件*/
         FileSystem_Test.writeFile();
        /*删除文件*/
        // FileSystem_Test.deleteFile();
    }

     public static void listFileProperties() throws IOException {
           Path path = Paths.get("E:\\Jimmy.txt");

           System.out.println(Files.exists(path));//判断文件是否存在
           System.out.println(path.getFileName());//获取文件名
           System.out.println(Files.isRegularFile(path));//是否常规文件
           System.out.println(Files.isReadable(path));//是否可读
           System.out.println(Files.isWritable(path));//是否可写
           System.out.println(Files.isExecutable(path));//是否可执行

           Map<String, Object> attr = Files.readAttributes(path, "*"); //读取文件所有属性

    }
   /* Buffer的三个属性：
      capacity
      position
      limit
      position和limit的含义取决于Buffer处在读模式还是写模式。不管Buffer处在什么模式，capacity的含义总是一样的。*/
    public static void readFile(){
           try{
                 Charset charset = Charset.forName("GBK");
                 CharsetDecoder decoder = charset.newDecoder();
                 FileInputStream stream = new FileInputStream("E:\\Jimmy.txt");
                 FileChannel channel = stream.getChannel(); //获取文件通道
                 ByteBuffer byteBuffer  = ByteBuffer.allocate(1024);//分配缓冲区
                 CharBuffer charBuffer = CharBuffer.allocate(1024);
                 int bytesRead = channel.read(byteBuffer);//读到缓冲区
                 while(bytesRead != -1){
                       byteBuffer.flip();//写模式切换到读模式--------准备读
                       decoder.decode(byteBuffer, charBuffer, false);
                       charBuffer.flip();
                       System.out.println(charBuffer);
                       charBuffer.clear();
                       byteBuffer.clear();//清空缓冲区，准备再次读取
                       bytesRead = channel.read(byteBuffer);
                 }
             } catch ( IOException e) {
                 e.printStackTrace();
             }
     }

      public static void writeFile(){
             try{
                  FileOutputStream stream = new FileOutputStream("E:\\Lucy.txt");
                  FileChannel channel = stream.getChannel(); //获取文件通道
                  ByteBuffer  buffer  = ByteBuffer.allocate(1024);//分配缓冲区
                  String str = "Hello Lucy 将卢卡斯惊呆了缴交贷款炼金啊塑料袋爱上了惊呆了卡三季度垃圾塑料袋将阿里数据库等垃圾卡死掉了空间按手榴弹快速了解啦将卢卡斯惊呆了数据连接撒了点空间拉斯惊呆了就爱上了空间的快乐几啊塑料袋看见快乐撒娇地了解阿斯顿了空间拉克丝建档立卡涉及到垃圾收快递件阿拉斯加的拉斯惊呆了将阿斯顿了就爱了坚实的辣椒水"; //写入的字符串
                  for(int i=0;i<str.length();i++) {//字符串逐渐写到缓冲区
                      buffer.putChar(str.charAt(i));
                  }
                  buffer.flip();
                  channel.write(buffer);//缓冲区数据写入到文件中
                  channel.close();
                  stream.close();
              } catch ( IOException e) {
                  e.printStackTrace();
              }
    }
     public static void deleteFile(){
            try {
                 Path path = Paths.get("E:\\test.txt");
                 Files.delete(path);
             } catch (IOException e) {
                 e.printStackTrace();
             }
     }




}
