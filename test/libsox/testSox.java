package libsox;

import java.util.List;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.Subscription;

import com.sun.istack.internal.NotNull;

import edu.cmu.wise.sox.android.tools.*;

public class testSox {

	public static void main(String[] args) {
		String xmppServer = "sensor.andrew.cmu.edu";
		int port = 5222;
		String userName = "charles";
		String password = "boschtop75";
		XMPPConnection mXMPPConnection;
		
		System.out.println("Testing Connection...");
		ConnectionConfiguration config = new ConnectionConfiguration(xmppServer,port);
		System.out.println("Testing Connection...");
		mXMPPConnection = new XMPPConnection(config);

		try {
			mXMPPConnection.connect();
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SoxLibrary soxConn = new SoxLibrary(xmppServer, port, userName, password);
		
		
	
		try {
			soxConn.connectXMPPServer();
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection established...");
		@NotNull List<Subscription> NodeList = soxConn.getSubscribeNodeList();
		if (NodeList != null) {
			for (Subscription Node : NodeList) {
				System.out.println(Node);
			}
		}
	}
}
