package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestClient {

    /**
     * mainÇé¿çsÇ∑ÇÈÅB<br>
     * @param args
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException {
     InetAddress addr = InetAddress.getLocalHost();
     System.out.println("localhost Address:"+addr);
     
     InetAddress addr2 = InetAddress.getByName("S2D-CAOXY-PC");
     System.out.println("localhost Address:"+addr2);
     
     //InetAddress addr3 = InetAddress.getByName("www.javathinker.com");
     InetAddress addr3 = InetAddress.getByName("194.165.34.129");
     System.out.println("localhost Address:"+addr3);
    }

}
