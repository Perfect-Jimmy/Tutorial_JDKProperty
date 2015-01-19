package com.tutorial.networkprogram;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress类是Java中用于描述IP地址的类,它在java.net包中.
 * 在Java中分别用Inet4Address和Inet6Address类来描述IPv4和IPv6的地址。
 * 创建InetAddress对象必须得依靠它的四个静态方法.
 * (1)getLocalHost()方法得到本机的InetAddress对象
 * (2)getByName()得到远程主机的InetAddress对象.
 * (3)getAllByName()得到远程主机的InetAddress对象.
 * (4)getByAddress()得到远程主机的InetAddress对象.
 * Created by Administrator on 2015/1/19.
 */
public class Lesson1_InetAddress_Demo {
    public static void main(String[] args) {
           /*  getLocalHost()方法*/
           //Lesson1_InetAddress_Demo.localHostMethod();
           /*  getByName()方法*/
           //Lesson1_InetAddress_Demo.byNameMethod();
           /*  getAllByNam()方法*/
           //Lesson1_InetAddress_Demo.allByNameMethod();
           /* getByAddress()方法*/
           Lesson1_InetAddress_Demo.byAddressmethod();
    }

    public static void localHostMethod(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);//Jimmy-PC/192.168.112.1
            //当本机绑定了多个IP时，getLocalHost只返回第一个IP。如果想返回本机全部的IP，可以使用getAllByName方法。
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void byNameMethod(){
        try {
            //测试本地
            //InetAddress address = InetAddress.getByName("localhost");//localhost/127.0.0.1
            //InetAddress address = InetAddress.getByName("Jimmy-PC");//Jimmy-PC/192.168.112.1
            //测试远程
            InetAddress address = InetAddress.getByName("www.csdn.net");//www.csdn.net/14.17.69.22
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void allByNameMethod(){
        try {
            InetAddress addresses[] = InetAddress.getAllByName("www.baidu.com");
            for (InetAddress address : addresses)
                 System.out.println(address);
                 //www.baidu.com/180.97.33.108
                 //www.baidu.com/180.97.33.107
           } catch (UnknownHostException e) {
             e.printStackTrace();
        }
    }

    public static void byAddressmethod(){
        try {
            byte ip[] = new byte[] { (byte) 141, (byte) 146, 8 , 66};
            InetAddress address1 = InetAddress.getByAddress(ip);
            InetAddress address2 = InetAddress.getByAddress("Oracle官方网站",ip);
            System.out.println(address1);//-----/141.146.8.66
            System.out.println(address2);//-----Oracle官方网站/141.146.8.66
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
