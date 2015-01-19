package com.tutorial.networkprogram;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 获取本机所有的物理网络接口和虚拟机等软件利用本机的物理网络接口创建的逻辑网络接口的信息
 * 创建NetworkInterface对象的两个静态方法
 * (1)getByName()
 * (2)getByInetAddress()
 * Created by Administrator on 2015/1/19.
 */
public class Lesson2_NetworkInterface_Demo {
    public static void main(String[] args) {
        /*getByName()方法*/
        // Lesson2_NetworkInterface_Demo.byNameMethod();
        /* getByInetAddress()方法*/
        Lesson2_NetworkInterface_Demo.byInetAddress();
    }
    public static void byNameMethod(){
        try {
              NetworkInterface networkInterface = NetworkInterface.getByName("eth0"); //name:eth0 (WAN Miniport (IPv6))
           // NetworkInterface networkInterface = NetworkInterface.getByName("abcd"); //null
              System.out.println(networkInterface);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    public static void byInetAddress(){
        try {
            InetAddress local = InetAddress.getByName("Jimmy-PC");
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(local);//name:eth4 (VMware Virtual Ethernet Adapter for VMnet1)
            System.out.println(networkInterface);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
