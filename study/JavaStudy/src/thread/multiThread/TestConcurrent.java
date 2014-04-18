package thread.multiThread;
import java.util.concurrent.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.channels.*;

public class TestConcurrent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      Charset charset = Charset.forName("UTF-8");
      System.out.println("default charset:"+charset.name());
	}

}
