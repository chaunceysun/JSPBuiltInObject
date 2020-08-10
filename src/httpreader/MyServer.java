package httpreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Chauncey 2020/8/10 23:35
 */
public class MyServer {
    public static void main(String[] args) {
        try {
            System.out.println("服务器开启");
            //开启一个服务
            ServerSocket server = new ServerSocket(9999);
            //等待客户端连接
            Socket socket = server.accept();
            //通过socket对象读取浏览器发送的请求，获取一个字节输入流
            InputStream is = socket.getInputStream();
            //字节流转化成字符流
            InputStreamReader isr = new InputStreamReader(is);
            //因为是按行读取的，为了里面的readLine方法
            BufferedReader br = new BufferedReader(isr);
            //读取请求头协议信息
            String value = br.readLine();
            while (value != null && !"".equals(value)) {
                System.out.println(value);
                value = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
