package ÍøÂç±à³Ì;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ind = InetAddress.getLocalHost();
		InetAddress ind1 = InetAddress.getByName("192.168.11.2");
		System.out.println(ind1.getHostName());
		System.out.println(ind1.getHostAddress());
	}

}
