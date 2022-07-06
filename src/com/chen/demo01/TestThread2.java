package com.chen.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

// 练习Thread，实现多线程同步下载图片
public class TestThread2 implements Runnable{

    private String url; // 网络图片地址
    private String name; // 保存的文件名

    public TestThread2(String url,String name){
        this.url = url;
        this.name = name;
    }

    // 下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为"+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("http://192.168.2.125:10086/img/%E3%80%90%E3%82%A2%E3%83%8B%E3%83%A1%E5%8C%96%E3%80%91%E3%81%8A%E9%9A%A3%E3%81%AE%E5%A4%A9%E4%BD%BF%E6%A7%98%E3%81%AB%E3%81%84%E3%81%A4%E3%81%AE%E9%96%93%E3%81%AB%E3%81%8B%E9%A7%84%E7%9B%AE%E4%BA%BA%E9%96%93%E3%81%AB%E3%81%95%E3%82%8C%E3%81%A6%E3%81%84%E3%81%9F%E4%BB%B6.a292341d.jpg","1.jpg");
        TestThread2 t2 = new TestThread2("http://192.168.2.125:10086/img/_-removebg.081b755e.png","2.png");
        TestThread2 t3 = new TestThread2("http://192.168.2.125:10086/img/1624784334510.0db1336e.png","3.png");
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

// 下载器
class WebDownloader{
    // 下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
