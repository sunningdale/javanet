package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioServer {
	private int port = 8000;
	private ServerSocketChannel serverSocketChannel = null;
	private ExecutorService executorService;
	private static final int POOL_MULTIPLE = 4;

	public NioServer() throws IOException {
		// create a thread pool
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
				.availableProcessors() * POOL_MULTIPLE);
		// create a ServerSocketChannel
		serverSocketChannel = ServerSocketChannel.open();

		serverSocketChannel.socket().setReuseAddress(true);
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		System.out.println("server is starting...");

	}

	public void service() {
		while (true) {
			SocketChannel socketChannel = null;
			try {
				socketChannel = serverSocketChannel.accept(); // connection
				executorService.execute(new Handler(socketChannel));

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	public static void main(String[] agrs) throws IOException {
		new NioServer().service();
	}
}

class Handler implements Runnable {

	private SocketChannel socketChannel;

	public Handler(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}

	@Override
	public void run() {
		handler(socketChannel);

	}

	public void handler(SocketChannel socketChannel) {
		try {
			Socket socket = socketChannel.socket();
			System.out.println("receive from client:" + socket.getInetAddress()
					+ ":" + socket.getPort());

			BufferedReader br;

			br = getReader(socket);

			PrintWriter pw = getWriter(socket);

			String msg = null;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
				pw.write(echo(msg));
				if ("bye".equals(msg)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socketChannel != null) {
					socketChannel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream op = socket.getOutputStream();
		return new PrintWriter(op, true);
	}

	private BufferedReader getReader(Socket socket) throws IOException {
		InputStream is = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(is));
	}

	private String echo(String msg) {
		return "echo:" + msg;
	}

}