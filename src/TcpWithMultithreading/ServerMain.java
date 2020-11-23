package TcpWithMultithreading;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	
	private int count = 1;
	
	public ServerMain() throws Exception {
		ServerSocket server_socket = new ServerSocket(2020);
		System.out.println("Port 2020 is now open");
		
		while (true) {
			Socket socket = server_socket.accept();
			ServerThread server_thread = new ServerThread(socket,getConnectionNumber());
			
			Thread thread = new Thread(server_thread);
			thread.start();
			
		}
	}
	
	public int getConnectionNumber() {
		return count++;
	}
	
	public static void main(String[] args) {
		try {
			new ServerMain();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
