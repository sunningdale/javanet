package net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ReceiveServer {

    /**
     * mainÇé¿çsÇ∑ÇÈÅB<br>
     * @param args
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8000);
        //
        Socket socket = serverSocket.accept();

        //socket.setSoTimeout(20000);
        System.out.println("-----"+System.currentTimeMillis());
        Thread.sleep(5000);
        System.out.println("+++++"+System.currentTimeMillis());
        InputStream in = socket.getInputStream();

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        byte[] buff = new byte[1024];

        int len = -1;

        do {
            try {
                len = in.read(buff);
                if (len != -1) {
                    buffer.write(buff, 0, len);
                }
            } catch (SocketTimeoutException e) {
                System.out.println("time out");
                len = 0;
            }
        } while (len != -1);
        System.out.println("buffer----" + new String(buffer.toByteArray()));
    }

}
