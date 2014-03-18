package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocket {

    /**
     * mainÇé¿çsÇ∑ÇÈÅB<br>
     * @param args
     * @throws IOException
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        InetAddress remoteAddress = InetAddress.getByName("www.baidu.com");
        InetAddress localAddress = InetAddress.getByName("10.6.1.116");
        Socket socket = new Socket(remoteAddress,80,localAddress,3456);
        
        System.out.println("net address:"+socket.getInetAddress());
        System.out.println("net port:"+socket.getPort());
        System.out.println("local address:"+socket.getLocalAddress());
        System.out.println("local port:"+socket.getLocalPort());
        
//        Socket socket1 = new Socket("www.baidu.com", 80);

//        new TestSocket().testSocketStatus(socket1, "socket1");
//
//        // socket1.getOutputStream().close();
//        socket1.getInputStream().close();
//        new TestSocket().testSocketStatus(socket1, "socket1");
//
//        Socket socket2 = new Socket();
//        new TestSocket().testSocketStatus(socket2, "socket2");
//
//        socket2.close();
//        new TestSocket().testSocketStatus(socket2, "socket2");

    }

    public void testSocketStatus(Socket socket, String name) {
        System.out.println(name + ".isClosed:" + socket.isClosed());
        System.out.println(name + ".isConnected:" + socket.isConnected());
        if (socket.isConnected() && !socket.isClosed()) {
            System.out.println(name + "--Now is connection!!");
        } else {
            System.out.println(name + "--Now is not connection!!");
        }
    }

}
