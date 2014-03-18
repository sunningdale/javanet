package net;

import java.io.IOException;
import java.net.*;

public class LinkClient {

    /**
     * mainÇé¿çsÇ∑ÇÈÅB<br>
     * @param args
     * @throws IOException 
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        Socket socket = new Socket("localhost",8000);
        System.out.println("the first connetion is success");

        Socket socket2 = new Socket("localhost",8000);
        System.out.println("the second connetion is success");
        
        Socket socket3 = new Socket("localhost",8000);
        System.out.println("the third connetion is success");

    }

}
