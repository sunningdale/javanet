package net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

public class SendClient {
    
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException{
        Socket socket = new Socket("localhost",8000);
        socket.setSoLinger(true,10);
        OutputStream out =  socket.getOutputStream();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10000; i++){
            sb.append(i);
        }
        out.write(sb.toString().getBytes());
//        out.write("hello".getBytes());
//        out.write("everyone".getBytes());
        //Thread.sleep(60000);
        long begin = System.currentTimeMillis();
        socket.close();
        long end = System.currentTimeMillis();
        System.out.println("end:"+end);
        System.out.println("the time of shut down socket:"+(end - begin));
    }
}
