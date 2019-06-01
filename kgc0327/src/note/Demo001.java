package note;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Demo001 {
	
	public static void main(String[] args) throws IOException {
		Socket client = new Socket("localhost", 1926);
		System.out.println("客户端启动...");
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		//控制台输入流
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
		
		//单独开辟一个线程来读取数据
		Runnable runable = () -> {
			while (true) {
				try {
					String readLine = dis.readUTF();
					System.out.println(readLine);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runable).start();
		String readLine;
		
		//主线程写数据
		while ((readLine = sin.readLine()) != null) {
			dos.writeUTF(readLine);
			dos.flush();
		}
		
		dis.close();
		dos.close();
		client.close();
	}

}
