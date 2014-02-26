

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;

public class NetClient {
    
    private String host = "10.6.1.116";
    private int port = 8000;
    private Socket socket = null;
    
    public NetClient() throws IOException{
        socket = new Socket(host,port);
        
    }
    
    public String echoMsg(String msg) {
        return msg;

    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream os = socket.getOutputStream();
        return new PrintWriter(os, true);

    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream is = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(is));
    }
    
    public void talk(){
        
        try {
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);
            
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            
            while ((msg = localReader.readLine()) != null){
                pw.println(echoMsg(msg));
                System.out.println(br.readLine());
                if ("bye".equalsIgnoreCase(msg)){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * mainÇé¿çsÇ∑ÇÈÅB<br>
     * @param args
     * @throws IOException 
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
      new NetClient().talk();
    }

}
