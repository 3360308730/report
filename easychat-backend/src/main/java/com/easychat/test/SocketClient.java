package com.easychat.test;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) {
        Socket socket = null;
        try{
            socket = new Socket("127.0.0.1",1024);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            System.out.println("请输入你需要发生的信息:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            printWriter.println(input);
            printWriter.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
