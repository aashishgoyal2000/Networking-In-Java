package TcpWithMultithreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{

	private Socket socket;
	private int clientNumber = 0;
	
	public ServerThread(Socket socket, int clientNumber) {
		this.socket = socket;
		this.clientNumber = clientNumber;
		
	}
	
	@Override
	public void run() {
		try {
			
			System.out.println("Client " + clientNumber + " has conneccted");
			
			// I/O buffers:
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);		
			
			out_socket.println("Welcome! Whats your name?? \n"); // send "Welcome" to the client
			String message = in_socket.readLine();
			
			System.out.println("Client says: "+ message); // display Client's message in the console
			
			socket.close();
			System.out.println("Socket is closed for Client Number: " + clientNumber);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	

}
