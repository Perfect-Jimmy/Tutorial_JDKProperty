package com.tutorial.jdk7.language;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/1/16.
 *
 */
public class Language_Demo {

    public static void main(String[] args) throws IOException {
        /*switch语句可以使用字符串*/
        Language_Demo.switchMethod("one");
        /*数字下面可以加下划线*/
        Language_Demo.numberMethod();
        /*泛型的简化*/
        Language_Demo.genericsMethod();
        /*try-with-resources自动关闭资源*/
        Language_Demo.tryWithResource();
    }

    private static void switchMethod(String str){
            switch (str) {
                  case "one":
                      System.out.println("one");
                      break;
                  case "two":
                      System.out.println("two");
                      break;
                  case "three":
                      System.out.println("three");
                      break;
                  default:
                      System.out.println("default");
              }
    }
    private static void numberMethod(){
             int a = 1_000_000;
             System.out.println(a);
    }
    private static void genericsMethod(){
            List<String> list = new ArrayList<>();
            list.add("jimmy");
            //old 写法
            Map<String,List<String>> mapOld = new HashMap<String,List<String>>();
            mapOld.put("hello",list);
            //current 写法
            Map<String,List<String>> mapCur = new HashMap<>();
            mapCur.put("hello",list);
            System.out.println(mapOld);
            System.out.println(mapCur);
    }
    /* try-with-resources 语句会确保在try语句结束时关闭所有资源。实现了java.lang.AutoCloseable或java.io.Closeable的对象都可以做为资源。*/
    private static void tryWithResource() throws IOException {
            String path = "E:\\try.txt";
            try(
                    BufferedReader br = new BufferedReader(new FileReader(path))
            ){
                    System.out.println(br.readLine());
            }
    }
}

