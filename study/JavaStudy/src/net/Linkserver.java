package net;

import java.io.IOException;
import java.net.*;

public class Linkserver {

    /**
     * mainを実行する。<br>
     * @param args
     * @throws IOException 
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket= new ServerSocket(8000,2);
        Thread.sleep(60000);
    }

}
