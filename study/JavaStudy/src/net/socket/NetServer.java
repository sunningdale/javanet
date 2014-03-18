package net.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServer {

    private int port = 8000;

    private ServerSocket serverSocket;

    public NetServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("server is starting");
    }

    public String echoMsg(String msg) {
        return "server:" + msg;

    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream os = socket.getOutputStream();
        return new PrintWriter(os, true);

    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream is = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(is));
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept(); // wait for client connet
                System.out.println("new connetion accepted." + socket.getInetAddress() + ":" + socket.getPort());

                BufferedReader br = getReader(socket);

                PrintWriter pw = getWriter(socket);

                String msg = null;
                while ((msg = br.readLine()) != null) {
                    System.out.println(msg);
                    pw.println(echoMsg(msg));
                    if ("bye".equalsIgnoreCase(msg)) {
                        break;
                    }
                }

            } catch (IOException e) {
                System.out.println("error");
                e.printStackTrace();
            } finally {

                try {
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * mainÇé¿çsÇ∑ÇÈÅB<br>
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new NetServer().service();
    }
}
